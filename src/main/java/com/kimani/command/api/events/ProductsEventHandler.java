package com.kimani.command.api.events;

import com.kimani.command.api.data.Product;
import com.kimani.command.api.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductsEventHandler {

    private final ProductRepository productRepository;

    @EventHandler
    public void onProductCreatedEvent(ProductCreatedEvent productCreatedEvent) {
        Product product = new Product();
        BeanUtils.copyProperties(productCreatedEvent, product);

        productRepository.save(product);
    }

}
