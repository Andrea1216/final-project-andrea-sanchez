package com.techlab.finalproject.controller;

import com.techlab.finalproject.model.Producto;
import com.techlab.finalproject.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return this.service.crear(producto);
    }

    @PutMapping("/{id}")
    public Producto editar(@PathVariable Long id, @RequestBody Producto producto) {
        //return this.service.crearProducto(producto);
        return null;
    }

    @GetMapping
    public List<Producto> listar() {
        //return this.service.crearProducto(producto);
        return null;
    }

    @GetMapping("/{id}")
    public Producto obtener() {
        //return this.service.crearProducto(producto);
        return null;
    }

    @DeleteMapping("/{id}")
    public Producto eliminar() {
        //return this.service.crearProducto(producto);
        return null;
    }

}
