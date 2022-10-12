package com.protalento.market.web.controller;


import com.protalento.market.domain.Product;
import com.protalento.market.domain.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation("obtiene todos los productos de la tienda") //que hace el metodo
    @ApiResponse(code = 200, message = "OK") //esto indicara el codigo de estado y el mensaje esperado
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>( productService.getAll(), HttpStatus.OK); //retorna todos los productos
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtiere un producto indicando el un id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Not_Found" )
    })
    public ResponseEntity<Product> getProduct(@ApiParam(value ="Resibe un idProdcuto que sera de tipo int",required = true,example = "7") @PathVariable("id") int productId){
        return productService.getProduct(productId)
                .map( product -> new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND)); //retorna producto por id
    }

    @GetMapping("/{idP}/{idC}")
    @ApiOperation("Optiene un producto indicando el idproducto y el idCategoria")
    @ApiResponses({
            @ApiResponse(code =200,message = "Ok"),
            @ApiResponse(code = 404, message = "Not_Found")
    })
    public ResponseEntity<Product> getPAncC(@ApiParam(value ="Recibe un idProducto tipo int",required = true,example = "1")@PathVariable("idP")int idP
            ,@ApiParam(value = "Recibe un idCategoria de tipo int",required = true,example = "1")@PathVariable("idC") int idC){
        return productService.getIdProductAndIdC(idP,idC)
                .map(product -> new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/prodCat/{id}")
    @ApiOperation("Recibe un idcategoria y retorna todos los productor relacionados a la misma ")
    @ApiResponses({
            @ApiResponse(code =200,message = "Ok"),
            @ApiResponse(code = 404, message = "Not_Found")
    })
    public ResponseEntity<List<Product>> getByCategoria(@ApiParam(value = "Recibe idcategoria de tipo int ",required = true,example = "5")@PathVariable("id") int categoryId){
        return productService.getBYCategory(categoryId)
                .map(products -> new ResponseEntity<>(products,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); //retorna todos los productos que comparten la misma categoria
    }

    @PostMapping("/guardar")
    @ApiOperation("Guarda un nuevo producto a la base de datos")
    @ApiResponse(code = 201 ,message = "Create")
    public ResponseEntity<Product> getSave(@ApiParam(value = "resibe un objeto de tipo Product a traves del body",required = true)@RequestBody Product product){
        return new ResponseEntity<>(productService.getSave(product),HttpStatus.CREATED) ; //garda los produtos
    }

    @DeleteMapping("/eliminar/{id}")
    @ApiOperation("Elimina un prodcuto indicando el id  ")
    @ApiResponses({
            @ApiResponse(code =200,message = "Ok"),
            @ApiResponse(code = 404, message = "Not_Found")
    })
    public ResponseEntity getEliminar(@ApiParam(value = "recibe un idProduct de tipo int",required = true,example = "57")@PathVariable("id") int productId){
        if(productService.getEliminar(productId)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

}
