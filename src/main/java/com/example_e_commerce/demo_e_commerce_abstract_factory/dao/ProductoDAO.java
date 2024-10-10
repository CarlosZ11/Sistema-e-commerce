package com.example_e_commerce.demo_e_commerce_abstract_factory.dao;

import com.example_e_commerce.demo_e_commerce_abstract_factory.domain.IProductoDB;
import com.example_e_commerce.demo_e_commerce_abstract_factory.domain.factory.DBFactory;
import com.example_e_commerce.demo_e_commerce_abstract_factory.modelo.Producto;

import java.util.List;

public class ProductoDAO {

    private IProductoDB db;

    public ProductoDAO(DBFactory factory) {
        this.db = factory.createDB();
    }

    public void createProducto(Producto producto) {
        db.create(producto);
    }

    public Producto getProducto(int id) {
        return db.read(id);
    }

    public void updateProducto(Producto producto) {
        db.update(producto);
    }

    public void deleteProducto(int id) {
        db.delete(id);
    }

    public List<Producto> getAllProductos() {
        return db.getAllProductos(); // Devuelve la lista de productos obtenida desde el repositorio
    }

}
