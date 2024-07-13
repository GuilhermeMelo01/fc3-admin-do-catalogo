package io.github.guilhermemelo01.application.category.create;

import io.github.guilhermemelo01.application.UseCase;
import io.github.guilhermemelo01.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class CreateCategoryUseCase
        extends UseCase<CreateCategoryCommand, Either<Notification, CreateCategoryOutput>> {



}
