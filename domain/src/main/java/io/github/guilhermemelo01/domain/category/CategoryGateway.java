package io.github.guilhermemelo01.domain.category;

import io.github.guilhermemelo01.domain.pagination.Pagination;

import java.util.Optional;

public interface CategoryGateway {
    Category create(Category category);
    Category deleteById(CategoryID id);
    Optional<Category> findById(CategoryID id);
    Category update(Category category);
    Pagination<Category> findAll(CategorySearchQuery aQuery);
}
