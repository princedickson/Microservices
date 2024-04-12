package com.explicit.microservice.productservice.controller;

import com.explicit.microservice.productservice.dto.ProductRequest;
import com.explicit.microservice.productservice.dto.ProductResponse;
import com.explicit.microservice.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vi/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
        return productService.createProduct(productRequest);
    }

    public List<ProductResponse> getAllProduct(){
        return productService.getAllProduct();
    }
}
