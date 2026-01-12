package br.com.knowledgesoutionstecnology.pennywise.exception;

public class DespesaDuplicadaException extends RuntimeException {
    public DespesaDuplicadaException(String message) {
        super(message);
    }

    public DespesaDuplicadaException(String message, Throwable cause) {
        super(message, cause);
    }
}
