package com.demo.market.persistence.mapper;

import com.demo.market.domain.Category;
import com.demo.market.persistence.entity.Categoria;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source="idCategoria", target="categoryId"),
            @Mapping(source="descripcion", target="category"),
            @Mapping(source="estado", target="active"),
    }) /*Mapeamos cada campo de la entiedad indicand su equivalente*/
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration /*Esta anotación se encarga de indicar que es lo inverso a lo configurado lineas arriba*/
    @Mapping(target="productos", ignore = true)
    Categoria toCategoria(Category category);

}
