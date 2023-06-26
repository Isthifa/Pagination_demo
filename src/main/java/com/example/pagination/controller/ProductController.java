package com.example.pagination.controller;

import com.example.pagination.dto.ApiResponse;
import com.example.pagination.entity.Products;
import com.example.pagination.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    public Products save(@RequestBody Products products){
        return productService.save(products);
    }

    @GetMapping("/list/{offset}/{limit}")
    public ApiResponse<Iterable<Products>> listAllProducts(@PathVariable int offset, @PathVariable int limit){
        Iterable<Products> products= productService.listAllProducts(offset,limit);
        return new ApiResponse<>(products.spliterator().getExactSizeIfKnown(),products);
    }

    @GetMapping("/list/{field}")
    public Iterable<Products> listAllProducts(@PathVariable("field") String field){
        return productService.findProductsWithSort(field);
    }


}
