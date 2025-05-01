package com.gustavo.empresa_cursos_programacao.CursoController;

import com.gustavo.empresa_cursos_programacao.CursoRepository.CursoRepository;
import com.gustavo.empresa_cursos_programacao.Service.CursoService;
import com.gustavo.empresa_cursos_programacao.model.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<Curso> criarCurso(@Valid @RequestBody Curso curso) {
        Curso novoCurso = cursoService.criarCurso(curso);
        return ResponseEntity.ok(novoCurso);
    }

    @GetMapping
    public ResponseEntity<Page<Curso>> listarCursos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(cursoService.listarCursosPaginados(name, category, pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizarCurso(@PathVariable UUID id, @Valid @RequestBody Curso curso) {
        Curso cursoAtualizado = cursoService.atualizarCurso(id, curso);
        return ResponseEntity.ok(cursoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCurso(@PathVariable UUID id) {
        cursoService.deletarCurso(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Curso> alterarStatus(@PathVariable UUID id) {
        Curso cursoAtualizado = cursoService.alterarStatus(id);
        return ResponseEntity.ok(cursoAtualizado);
    }
}