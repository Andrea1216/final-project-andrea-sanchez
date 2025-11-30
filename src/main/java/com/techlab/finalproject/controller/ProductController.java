package com.techlab.finalproject.controller;

import com.techlab.finalproject.model.Producto;
import com.techlab.finalproject.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
        return ResponseEntity.ok(this.service.crear(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> editar(@PathVariable Long id, @RequestBody Producto producto) {
        try {
            return ResponseEntity.ok(this.service.editar(id, producto));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Producto> listar() {
        return this.service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtener(@PathVariable Long id) {
        Optional<Producto> productoOptional = this.service.obtener(id);
        if (productoOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Producto producto = productoOptional.get();
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/{id}")
    public Producto eliminar(@PathVariable Long id) {
        return this.service.eliminar(id);
    }

}
