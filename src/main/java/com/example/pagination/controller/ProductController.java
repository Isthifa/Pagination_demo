package com.example.pagination.controller;

import com.example.pagination.dto.ApiRespons;
import com.example.pagination.entity.Products;
import com.example.pagination.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Save a product", description = "Save a product" , tags = {"product"} )
    @PostMapping("/save")
    @ApiResponse(responseCode = "200", description = "Product saved successfully")
    public Products save(@RequestBody Products products){
        return productService.save(products);
    }

    @Operation(summary = "List all products", description = "List all products" , tags = {"product"} )
    @ApiResponse(responseCode = "200", description = "Products listed successfully")
    @ApiResponse(responseCode = "404", description = "Products not found")
    @GetMapping("/list/{offset}/{limit}")
    public ApiRespons<Iterable<Products>> listAllProducts(@PathVariable int offset, @PathVariable int limit){
        Iterable<Products> products= productService.listAllProducts(offset,limit);
        return new ApiRespons<>(products.spliterator().getExactSizeIfKnown(),products);
    }

    @Operation(summary = "List all products with sort", description = "List all products with sort" , tags = {"product"} )
    @ApiResponse(responseCode = "200", description = "Products listed successfully")
    @ApiResponse(responseCode = "404", description = "Products not found")
    @GetMapping("/list/{field}")
    public Iterable<Products> listAllProducts(@PathVariable("field") String field){
        return productService.findProductsWithSort(field);
    }


}
