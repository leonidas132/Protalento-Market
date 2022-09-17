package com.protalento.market.web.controller;


import com.protalento.market.domain.Product;
import com.protalento.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController // le indica a spring que esto va hacer un controlador de una api rest
@RequestMapping("/products") // indica en que path va accetar las peticiones que le hagamos
public class ProductController {

    @Autowired //inyectamos dependencia
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll(); //retorna todos los productos
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId); //retorna producto por id
    }

    public Optional<List<Product>>getByCategoria(int categoryId){
        return productService.getBYCategory(categoryId); //retorna producto por categoria
    }

    public Product getSave(Product product){
        return productService.getSave(product); //garda los produtos
    }

    public boolean getEliminar(int productId){
        return productService.getEliminar(productId); //elimina los productos
    }

}
