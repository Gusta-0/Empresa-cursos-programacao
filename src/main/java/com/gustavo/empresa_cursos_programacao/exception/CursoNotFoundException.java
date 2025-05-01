package com.gustavo.empresa_cursos_programacao.exception;

public class CursoNotFoundException extends RuntimeException {
    public CursoNotFoundException(Long id) {
        super("Curso com ID " + id + " não encontrado.");
    }
}
