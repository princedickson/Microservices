package com.explicit.microservice.productservice.service;

import com.explicit.microservice.productservice.dto.ProductRequest;
import com.explicit.microservice.productservice.dto.ProductResponse;
import com.explicit.microservice.productservice.model.Product;
import com.explicit.microservice.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .price(productRequest.price())
                .description(productRequest.description())
                .build();
        productRepository.save(product);
        log.info("product created successfuly");
        return new ProductResponse(product.getId(), product.getName(),product.getDescription(),product.getPrice());

    }

    public List<ProductResponse> getAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(),product.getDescription(),product.getPrice()))
                .toList();
    }
}
