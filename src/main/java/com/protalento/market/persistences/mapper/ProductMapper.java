package com.protalento.market.persistences.mapper;

import com.protalento.market.domain.Product;
import com.protalento.market.persistences.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;

@Component //esta anotación simplemente registra un bean dentro del framework sin mayor efecto .
@Mapper(componentModel ="spring", uses ={CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping( source = "idProducto",target = "productId"),
            @Mapping( source = "nombre",target = "name"),
            @Mapping( source = "idCategoria",target = "categoryId"),
            @Mapping( source = "precioVenta",target = "valor"),
            @Mapping( source = "cantidadStock",target = "stock"),
            @Mapping( source = "estado",target = "active"),
            @Mapping( source = "categoria",target = "category")
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras",ignore = true)
    Producto toProducto(Product product);

}
