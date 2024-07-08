package io.github.guilhermemelo01.domain.exceptions;

import io.github.guilhermemelo01.domain.validation.Error;

import java.util.List;

public class DomainException extends RuntimeException {

    private final List<Error> erros;
    private DomainException(final List<Error> anErrors) {
        super("", null, true, false);
        this.erros = anErrors;
    }

    public static DomainException with(final List<Error> anErrors){
        return new DomainException(anErrors);
    }

    public List<Error> getErrors() {
        return erros;
    }
}
