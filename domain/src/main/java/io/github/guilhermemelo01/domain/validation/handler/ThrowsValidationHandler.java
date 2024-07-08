package io.github.guilhermemelo01.domain.validation.handler;

import io.github.guilhermemelo01.domain.exceptions.DomainException;
import io.github.guilhermemelo01.domain.validation.Error;
import io.github.guilhermemelo01.domain.validation.ValidationHandler;

import java.security.DomainLoadStoreParameter;
import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {
    @Override
    public ValidationHandler append(final Error anError) {
        throw DomainException.with(List.of(anError));
    }

    @Override
    public ValidationHandler append(final ValidationHandler anHandler) {
        throw DomainException.with(anHandler.getErrors());
    }

    @Override
    public ValidationHandler validate(final Validation aValidation) {
        try {
            aValidation.validate();
        }catch (final Exception exception){
            throw DomainException.with(new Error(exception.getMessage()));
        }

        return this;
    }

    @Override
    public List<Error> getErrors() {
        return List.of();
    }
}
