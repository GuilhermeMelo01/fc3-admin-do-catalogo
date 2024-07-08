package io.github.guilhermemelo01.domain.category;

import io.github.guilhermemelo01.domain.validation.Error;
import io.github.guilhermemelo01.domain.validation.ValidationHandler;
import io.github.guilhermemelo01.domain.validation.Validator;

public class CategoryValidator extends Validator {

    private final Category category;
    private final int NAME_MIN_LENGTH = 3;
    private final int NAME_MAX_LENGTH = 255;

    public CategoryValidator(final Category category, ValidationHandler aHandler) {
        super(aHandler);
        this.category = category;
    }

    @Override
    public void validate() {
        checkNameConstraints();
    }

    private void checkNameConstraints() {
        final var name = this.category.getName();
        if (name == null){
            this.validationHandler().append(new Error("'name' should not be null"));
            return;
        }

        if (name.isBlank()){
            this.validationHandler().append(new Error("'name' should not be empty"));
            return;
        }

        var length = name.trim().length();
        if (length < NAME_MIN_LENGTH || length > NAME_MAX_LENGTH){
            this.validationHandler().append(new Error("'name' must be between 3 and 255 characters"));
            return;
        }
    }
}