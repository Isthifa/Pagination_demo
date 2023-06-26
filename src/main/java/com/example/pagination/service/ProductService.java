package com.example.pagination.service;

import com.example.pagination.entity.Products;

import java.util.List;

public interface ProductService {

    Iterable<Products> listAllProducts(int offset, int limit);

    Products save(Products products);

    List<Products> findProductsWithSort(String field);

}
