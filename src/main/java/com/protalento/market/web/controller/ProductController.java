package com.protalento.market.web.controller;


import com.protalento.market.domain.Product;
import com.protalento.market.domain.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // le indica a spring que esto va hacer un controlador de una api rest
@RequestMapping("/products") // indica en que path va accetar las peticiones que le hagamos
public class ProductController {

    @Autowired //inyectamos dependencia
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>( productService.getAll(), HttpStatus.OK); //retorna todos los productos
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId)
                .map( product -> new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND)); //retorna producto por id
    }

    @GetMapping("/{idP}/{idC}")
    public ResponseEntity<Optional<Product>> getPAncC(@PathVariable("idP")int idP ,@PathVariable("idC") int idC){
        return productService.getIdProductAndIdC(idP,idC)
                .map(product -> new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/prodCat/{id}")
    public ResponseEntity<List<Product>> getByCategoria(@PathVariable("id") int categoryId){
        return productService.getBYCategory(categoryId)
                .map(products -> new ResponseEntity<>(products,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); //retorna todos los productos que comparten la misma categoria
    }

    @PostMapping("/guardar")
    public ResponseEntity<Product> getSave(@RequestBody Product product){
        return new ResponseEntity<>(productService.getSave(product),HttpStatus.CREATED) ; //garda los produtos
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity getEliminar(@PathVariable("id") int productId){
        if(productService.getEliminar(productId)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

}
