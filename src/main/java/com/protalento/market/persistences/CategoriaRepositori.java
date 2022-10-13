package com.protalento.market.persistences;

import com.protalento.market.domain.Category;
import com.protalento.market.domain.repository.CategoryRepository;
import com.protalento.market.persistences.crud.CategoryCrudRepository;
import com.protalento.market.persistences.entity.Categoria;
import com.protalento.market.persistences.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository// CON ESTO LE ESTAMOS INDICANDO A SPRING QUE ESTO ES UN COMPONENTE DE UN BEAN Y QUE ESTA CLASE SE ENCARGA DE INTERECTUAR CON LA BASE DE DATOS
public class CategoriaRepositori implements CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAll() {
        List<Categoria> categorias  = (List<Categoria>) categoryCrudRepository.findAll();
        return categoryMapper.toCategories(categorias) ;
    }

    @Override
    public Category getSave(Category category) {
        Categoria categoria = categoryMapper.toCategoria(category);
        return categoryMapper.toCategory(categoryCrudRepository.save(categoria));
    }
}
