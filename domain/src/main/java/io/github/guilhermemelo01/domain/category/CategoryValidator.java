package io.github.guilhermemelo01.domain.category;

import io.github.guilhermemelo01.domain.validation.Error;
import io.github.guilhermemelo01.domain.validation.ValidationHandler;
import io.github.guilhermemelo01.domain.validation.Validator;

public class CategoryValidator extends Validator {

    private final Category category;
    public CategoryValidator(final Category category, ValidationHandler aHandler) {
        super(aHandler);
        this.category = category;
    }

    @Override
    public void validate() {
        if (this.category.getName() == null){
            this.validationHandler().append(new Error("'name' should not be null"));
        }
    }
}