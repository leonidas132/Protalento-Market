package com.protalento.market.persistences.mapper;

import com.protalento.market.domain.PurchaseItem;
import com.protalento.market.persistences.entity.ComprasProductos;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",uses={ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProducto",target = "productId"),
            @Mapping(source = "cantidad",target = "quantity"),
            @Mapping(source = "total",target = "total"),
            @Mapping(source = "estado",target = "active")
    })
    PurchaseItem toPurchaseItem(ComprasProductos comprasProductos);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra",ignore = true),
            @Mapping(target = "producto",ignore = true ),
            @Mapping(target = "id.idCompra",ignore = true)
    })
    ComprasProductos toComprasProductos(PurchaseItem purchaseItem);

}
