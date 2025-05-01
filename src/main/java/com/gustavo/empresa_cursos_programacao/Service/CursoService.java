package com.gustavo.empresa_cursos_programacao.Service;

import com.gustavo.empresa_cursos_programacao.CursoRepository.CursoRepository;
import com.gustavo.empresa_cursos_programacao.model.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso criarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

public List<Curso> listarCursos(String name, String category) {
    if (name != null && category != null) {
        return cursoRepository.findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(name, category, Pageable.unpaged()).getContent();
    } else if (name != null) {
        return cursoRepository.findByNameContainingIgnoreCase(name, Pageable.unpaged()).getContent();
    } else if (category != null) {
        return cursoRepository.findByCategoryContainingIgnoreCase(category, Pageable.unpaged()).getContent();
    } else {
        return cursoRepository.findAll();
    }
}

public Page<Curso> listarCursosPaginados(String name, String category, Pageable pageable) {
    if (name != null && category != null) {
        return cursoRepository.findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(name, category, pageable);
    } else if (name != null) {
        return cursoRepository.findByNameContainingIgnoreCase(name, pageable);
    } else if (category != null) {
        return cursoRepository.findByCategoryContainingIgnoreCase(category, pageable);
    }
    return cursoRepository.findAll(pageable);
}

    public Curso atualizarCurso(UUID id, Curso novoCurso) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        if (novoCurso.getName() != null) {
            curso.setName(novoCurso.getName());
        }
        if (novoCurso.getCategory() != null) {
            curso.setCategory(novoCurso.getCategory());
        }

        return cursoRepository.save(curso);
    }

    public void deletarCurso(UUID id) {
        cursoRepository.deleteById(id);
    }

    public Curso alterarStatus(UUID id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        curso.setActive(!curso.getActive());

        return cursoRepository.save(curso);
    }
}