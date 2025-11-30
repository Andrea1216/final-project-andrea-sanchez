package com.techlab.finalproject.service;

import com.techlab.finalproject.model.Producto;
import com.techlab.finalproject.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceJpa implements ProductService {

    private ProductRepository repository;

    public ProductServiceJpa(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Producto crear(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public Producto editar(Producto producto) {
        return null;
    }

    @Override
    public Producto obtener(Long id) {
        return null;
    }

    @Override
    public List<Producto> listar() {
        return List.of();
    }

    @Override
    public Producto eliminar(Long id) {
        return null;
    }
}
