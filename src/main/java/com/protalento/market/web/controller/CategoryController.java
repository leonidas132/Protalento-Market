package com.protalento.market.web.controller;

import com.protalento.market.domain.Category;
import com.protalento.market.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAll(){
        return new ResponseEntity<>(categoryService.getListAll(), HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Category> guardar(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.getsave(category),HttpStatus.CREATED);
    }
    @GetMapping("/cunslCategoria/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") int id){
        return categoryService.getCategory(id)
                .map(category -> new ResponseEntity<>(category,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity getEliminar(@PathVariable("id") int id){
        if(categoryService.getEliminar(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
