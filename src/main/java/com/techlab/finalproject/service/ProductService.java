package com.techlab.finalproject.service;

import com.techlab.finalproject.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Producto crear(Producto producto);
    Producto editar(Long id, Producto producto);
    Optional<Producto> obtener(Long id);
    List<Producto> listar();
    Producto eliminar(Long id);
}
