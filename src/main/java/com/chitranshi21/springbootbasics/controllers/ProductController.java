package com.chitranshi21.springbootbasics.controllers;

import com.chitranshi21.springbootbasics.dtos.ProductDto;
import com.chitranshi21.springbootbasics.models.Product;
import com.chitranshi21.springbootbasics.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products/v1")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private final ModelMapper mapper;

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> home() {
        log.info("GET all products");
        return new ResponseEntity<>(mapModelListToDtoList(productService.getAllProducts()), HttpStatus.OK);
    }

    @GetMapping("/error")
    public String error() throws Exception {
        throw new Exception("Error while processing ");
    }

    private List<ProductDto> mapModelListToDtoList(List<Product> products) {
        List<ProductDto> productDtos = new ArrayList<>();
        products.stream().forEach(p ->
            productDtos.add(mapper.map(p, ProductDto.class))
        );
        return productDtos;
    }
}
