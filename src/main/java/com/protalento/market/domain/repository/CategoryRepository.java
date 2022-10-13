package com.protalento.market.domain.repository;

import com.protalento.market.domain.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> getAll();
    Category getSave(Category category);
}
