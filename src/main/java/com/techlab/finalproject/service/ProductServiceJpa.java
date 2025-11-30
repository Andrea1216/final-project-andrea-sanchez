package com.techlab.finalproject.service;

import com.techlab.finalproject.model.Producto;
import com.techlab.finalproject.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceJpa implements ProductService {

    private ProductRepository repository;

    public ProductServiceJpa(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Producto crear(Producto producto) {
        // Agregar validaciones
        return repository.save(producto);
    }

    @Override
    public Producto editar(Long id, Producto producto) {
        // Agregar validaciones

        Optional<Producto> productoOptional = repository.findById(id);
        if (productoOptional.isEmpty()) {
            throw new EntityNotFoundException("El producto no existe");
        }

        Producto productoDb = productoOptional.get();
        productoDb.setNombre(producto.getNombre());
        productoDb.setDescripcion(producto.getDescripcion());
        productoDb.setPrecio(producto.getPrecio());
        productoDb.setStock(producto.getStock());

        return repository.save(productoDb);
    }

    @Override
    public Optional<Producto> obtener(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Producto> listar() {
        return repository.findAll();
    }

    @Override
    public Producto eliminar(Long id) {
        Optional<Producto> productOptional = this.repository.findById(id);
        if (productOptional.isEmpty()) {
            return null;
        }
        Producto producto = productOptional.get();
        repository.delete(producto);
        return producto;
    }
}
