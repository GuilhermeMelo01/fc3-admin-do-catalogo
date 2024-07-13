package io.github.guilhermemelo01.application.category.create;


import io.github.guilhermemelo01.domain.category.Category;
import io.github.guilhermemelo01.domain.category.CategoryGateway;
import io.github.guilhermemelo01.domain.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

public class CreateCategoryUseCaseTest {

    @Test
    public void givenAValidCommand_whenCallsCreateCategory_shouldReturnCategoryId(){
        final var expectedName = "Filmes";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        final var aCommand = CreateCategoryCommand.with(expectedName, expectedDescription, false);

        final CategoryGateway categoryGateway = mock(CategoryGateway.class);

        when(categoryGateway.create(any())).thenAnswer(returnsFirstArg());

        final var useCase = new DefaultCreateCategoryUseCase(categoryGateway);

        final var actualOutput = useCase.execute(aCommand);

        Assertions.assertNotNull(actualOutput);
        Assertions.assertNotNull(actualOutput.id());

        Mockito.verify(categoryGateway, times(1))
                .create(argThat(aCategory -> {
                    return Objects.equals(expectedName, aCategory.getName())
                            && Objects.equals(expectedDescription, aCategory.getDescription())
                            && Objects.equals(expectedIsActive, aCategory.isActive())
                            && Objects.nonNull(aCategory.getId())
                            && Objects.nonNull(aCategory.getCreatedAt())
                            && Objects.nonNull(aCategory.getUpdatedAt())
                            && Objects.isNull(aCategory.getDeletedAt());
                }));
    }

}
