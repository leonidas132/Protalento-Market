package com.protalento.market.domain.service;

import com.protalento.market.domain.Category;
import com.protalento.market.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component// es un servicio de nuestra logica de negosio
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getListAll(){
        return categoryRepository.getAll();
    }
    public Category getsave(Category category){
        return categoryRepository.getSave(category);
    }
}
