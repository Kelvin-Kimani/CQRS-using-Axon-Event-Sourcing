package com.kimani.command.api.events;

import com.kimani.command.api.mappers.ProductMapper;
import com.kimani.command.api.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductsEventHandler {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @EventHandler
    public void onProductCreatedEvent(ProductCreatedEvent productCreatedEvent) {
        var product = productMapper.toProduct(productCreatedEvent);
        productRepository.save(product);
    }

}
