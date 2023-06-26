package com.example.pagination.repository;

import com.example.pagination.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepo extends JpaRepository<Products, Integer>{
}
