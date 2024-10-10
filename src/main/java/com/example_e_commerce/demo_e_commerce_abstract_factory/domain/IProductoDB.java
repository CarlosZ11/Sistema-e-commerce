package com.example_e_commerce.demo_e_commerce_abstract_factory.domain;

import com.example_e_commerce.demo_e_commerce_abstract_factory.modelo.Producto;

import java.util.List;

public interface IProductoDB {

    void create (Producto producto);
    Producto read (int id);
    void update (Producto producto);
    void delete (int id);
    List<Producto> getAllProductos();

}
