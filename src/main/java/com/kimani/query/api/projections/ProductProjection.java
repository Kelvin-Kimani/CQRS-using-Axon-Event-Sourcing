package com.kimani.query.api.projections;

import com.kimani.command.api.model.ProductModel;
import com.kimani.command.api.repositories.ProductRepository;
import com.kimani.query.api.queries.GetProductQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductProjection {
    private final ProductRepository productRepository;

    @QueryHandler
    public List<ProductModel> handle(GetProductQuery getProductQuery) {
        return productRepository.findAll()
                .stream()
                .map(product -> ProductModel
                        .builder()
                        .name(product.getName())
                        .price(product.getPrice())
                        .quantity(product.getQuantity())
                        .build())
                .collect(Collectors.toList());
    }
}
