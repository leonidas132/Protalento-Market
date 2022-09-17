package com.protalento.market.persistences.mapper;


import com.protalento.market.domain.Category;
import com.protalento.market.persistences.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // de esta manera estamos convirtiendo categoria dentro de category
    @Mappings({
            @Mapping(source = "idCategoria", target= "categoriryId"),// a source le indicamos la ubicasion de los atributos a convertir
            @Mapping(source = "descripcion", target= "category"), // y  a travez de target le indicamos los atrivutos que los estan esperando
            @Mapping(source = "estado", target= "active")
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration // le indica a map Struc que la converision que vamos a realizar es la inverza a la que hacemos arriba
    @Mapping(target ="producto", ignore =true) // de esta manera indicamos que ese atributo sera ignorado
    Categoria  toCategoria(Category category);

}
