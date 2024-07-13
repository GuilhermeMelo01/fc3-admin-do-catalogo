package io.github.guilhermemelo01.application.category.create;

import io.github.guilhermemelo01.domain.category.Category;
import io.github.guilhermemelo01.domain.category.CategoryGateway;
import io.github.guilhermemelo01.domain.validation.handler.Notification;
import io.github.guilhermemelo01.domain.validation.handler.ThrowsValidationHandler;
import io.vavr.API;
import io.vavr.control.Either;

import java.util.Objects;

import static io.vavr.API.Left;
import static io.vavr.API.Try;

public class DefaultCreateCategoryUseCase extends CreateCategoryUseCase {

    private final CategoryGateway categoryGateway;

    public DefaultCreateCategoryUseCase(final CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public Either<Notification, CreateCategoryOutput> execute(final CreateCategoryCommand aCommand) {

        Notification notification = Notification.create();
        final var category = Category.newCategory(aCommand.name(), aCommand.description(), aCommand.isActive());
        category.validate(notification);

        return notification.hasErrors() ? Left(notification) : create(category);
    }

    private Either<Notification, CreateCategoryOutput> create(Category category){
        return Try(() -> this.categoryGateway.create(category))
                .toEither()
                .bimap(Notification::create, CreateCategoryOutput::from);
    }
}

