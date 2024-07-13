package io.github.guilhermemelo01.application.category.create;

import io.github.guilhermemelo01.domain.category.Category;
import io.github.guilhermemelo01.domain.category.CategoryID;

public record CreateCategoryOutput(CategoryID id) {

    public static CreateCategoryOutput from(final Category category){
        return new CreateCategoryOutput(category.getId());
    }
}
