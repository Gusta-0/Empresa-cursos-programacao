package com.gustavo.empresa_cursos_programacao.CursoRepository;

import com.gustavo.empresa_cursos_programacao.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

@Repository
public interface CursoRepository extends JpaRepository<Curso, UUID> {
    Page<Curso> findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(String name, String category, Pageable pageable);
    Page<Curso> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<Curso> findByCategoryContainingIgnoreCase(String category, Pageable pageable);
}