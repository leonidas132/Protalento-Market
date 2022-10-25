package com.protalento.market.domain.repository;

import com.protalento.market.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    List<Category> getAll();
    Category getSave(Category category);
    Optional<Category> getCategory(int id);
    void getDelete (int idCategory);
}
