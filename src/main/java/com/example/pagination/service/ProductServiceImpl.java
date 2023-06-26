package com.example.pagination.service;

import com.example.pagination.entity.Products;
import com.example.pagination.repository.ProductsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductsRepo productsRepo;
    @Override
    public Iterable<Products> listAllProducts(int offset, int limit) {
        //PageRequest is a static method that returns a PageRequest object, offset and limit are passed as parameters
        Page<Products> productsPage=productsRepo.findAll(PageRequest.of(offset,limit));
        //getContent() returns a list of products
        return productsPage.getContent();
    }

    @Override
    public Products save(Products products) {
        return productsRepo.save(products);
    }

    @Override
    public List<Products> findProductsWithSort(String field) {
        //sort by field in descending order
        //Sort.by is a static method that returns a Sort object, sort direction is passed as a parameter
        return productsRepo.findAll(Sort.by(Sort.Direction.DESC,field));
    }
}
