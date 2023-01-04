package com.kimani.query.api.controllers;

import com.kimani.command.api.model.ProductModel;
import com.kimani.query.api.queries.GetProductQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductQueryController {
    private final QueryGateway queryGateway;

    @GetMapping
    public List<ProductModel> getAllProducts() {
        GetProductQuery getProductQuery = new GetProductQuery();
        return queryGateway.query(getProductQuery, ResponseTypes.multipleInstancesOf(ProductModel.class)).join();
    }
}
