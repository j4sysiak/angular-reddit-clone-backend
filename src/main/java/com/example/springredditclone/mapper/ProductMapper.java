package com.example.springredditclone.mapper;

import com.example.springredditclone.dto.ProductDto;
import com.example.springredditclone.model.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto mapProductToDto(Product product);

    @InheritInverseConfiguration
    Product mapDtoToProduct(ProductDto productDto);
}
