package io.github.guilhermemelo01.domain.validation.handler;

import io.github.guilhermemelo01.domain.exceptions.DomainException;
import io.github.guilhermemelo01.domain.validation.Error;
import io.github.guilhermemelo01.domain.validation.ValidationHandler;

import javax.naming.NoInitialContextException;
import java.util.ArrayList;
import java.util.List;

public class Notification implements ValidationHandler {

    private final List<Error> errros;

    private Notification(List<Error> errros) {
        this.errros = errros;
    }

    public static Notification create(){
        return new Notification(new ArrayList<>());
    }

    public static Notification create(final Error anError){
        return new Notification(new ArrayList<>()).append(anError);
    }

    @Override
    public Notification append(Error anError) {
        this.errros.add(anError);
        return this;
    }

    @Override
    public Notification append(final ValidationHandler anHandler) {
        this.errros.addAll(anHandler.getErrors());
        return this;
    }

    @Override
    public Notification validate(final Validation aValidation) {
        try {
            aValidation.validate();
        }catch (final DomainException ex){
            this.errros.addAll(ex.getErrors());
        }catch (final Throwable t){
            this.errros.add(new Error(t.getMessage()));
        }

        return this;
    }

    @Override
    public List<Error> getErrors() {
        return this.errros;
    }
}
