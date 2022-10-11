package com.protalento.market.persistences;

import com.protalento.market.domain.Product;
import com.protalento.market.domain.repository.ProductRepository;
import com.protalento.market.domain.service.ProductService;
import com.protalento.market.persistences.crud.ProductoCrudRepository;
import com.protalento.market.persistences.entity.Producto;
import com.protalento.market.persistences.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // CON ESTO LE ESTAMOS INDICANDO A SPRING QUE ESTA CLASE SE ENCARGA DE INTERECTUAR CON LA BASE DE DATOS
public class ProductoRepository implements ProductRepository {
    @Autowired // atravez de esta anotacio hacmemos la inyeccion de dependeia
    private ProductoCrudRepository productoCrudRepository;


    @Qualifier("productMapperImpl")
    @Autowired // se sede el control a spring para que crea las instancia de estos objetos
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();//debuelve todos los productos
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getBycategoria(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId); // consultar productos por categorias
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getProductScasos(int quentity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quentity,true); // consultar todos los productos en sto
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProducto(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));//onsulta un producto por Id
    }

    @Override
    public Product getSave(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void getEliminar(int productId){
        productoCrudRepository.deleteById(productId);
    }

    @Override
    public Optional<Product> getIdProductoAndIdCategoria(int diproducto, int idCategoria) {
        return productoCrudRepository.findByIdProductoAndAndIdCategoria(diproducto,idCategoria).map(producto -> mapper.toProduct(producto));
    }
}
