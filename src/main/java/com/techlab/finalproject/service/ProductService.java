package com.techlab.finalproject.service;

import com.techlab.finalproject.model.Producto;

import java.util.List;

public interface ProductService {
    Producto crear(Producto producto);
    Producto editar(Producto producto);
    Producto obtener(Long id);
    List<Producto> listar();
    Producto eliminar(Long id);
}
