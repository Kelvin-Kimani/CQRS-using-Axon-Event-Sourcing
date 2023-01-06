package com.kimani.command.api.mappers;

import com.kimani.command.api.data.Product;
import com.kimani.command.api.events.ProductCreatedEvent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductCreatedEvent productCreatedEvent);

}
