package com.techlab.finalproject.repository;

import com.techlab.finalproject.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Producto, Long> {
}
