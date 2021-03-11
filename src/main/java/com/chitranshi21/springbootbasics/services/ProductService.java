package com.chitranshi21.springbootbasics.services;

import com.chitranshi21.springbootbasics.models.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductService {

    public List<Product> getAllProducts() {
        return Arrays.asList(Product.builder().key("key1").name("Product 1").build());
    }
}
