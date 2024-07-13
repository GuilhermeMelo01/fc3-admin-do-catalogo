package io.github.guilhermemelo01.application.category.create;

import io.github.guilhermemelo01.domain.category.Category;
import io.github.guilhermemelo01.domain.category.CategoryGateway;
import io.github.guilhermemelo01.domain.validation.handler.Notification;
import io.github.guilhermemelo01.domain.validation.handler.ThrowsValidationHandler;

import java.util.Objects;

public class DefaultCreateCategoryUseCase extends CreateCategoryUseCase {

    private final CategoryGateway categoryGateway;

    public DefaultCreateCategoryUseCase(final CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public CreateCategoryOutput execute(final CreateCategoryCommand aCommand) {

        Notification notification = Notification.create();
        final var category = Category.newCategory(aCommand.name(), aCommand.description(), aCommand.isActive());
        category.validate(notification);

        if (notification.hasErrors()){

        }

        return CreateCategoryOutput.from(this.categoryGateway.create(category));
    }
}
