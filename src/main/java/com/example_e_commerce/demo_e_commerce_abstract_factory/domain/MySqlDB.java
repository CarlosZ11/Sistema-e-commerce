package com.example_e_commerce.demo_e_commerce_abstract_factory.domain;

import com.example_e_commerce.demo_e_commerce_abstract_factory.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class MySqlDB implements IProductoDB{

    private static MySqlDB instance;
    private List<Producto> productos;

    private MySqlDB() {
        this.productos = new ArrayList<>();
        // Agregando algunos productos por defecto
        productos.add(new Producto(1, "Air Force 1", 10.0));
        productos.add(new Producto(2, "Jordan Retro 4", 20.0));
    }

    // Método para obtener la única instancia de MySqlDB
    public static MySqlDB getInstance() {
        if (instance == null) {
            instance = new MySqlDB();
        }
        return instance;
    }

    @Override
    public void create(Producto producto) {
        productos.add(producto);
    }

    @Override
    public Producto read(int id) {
        return productos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void update(Producto producto) {
        Producto existing = read(producto.getId());
        if (existing != null) {
            existing.setDescripcion(producto.getDescripcion());
            existing.setPrecio(producto.getPrecio());
        }
    }

    @Override
    public void delete(int id) {
        productos.removeIf(p -> p.getId() == id);
    }

    @Override
    public List<Producto> getAllProductos() {
        return productos;
    }
}
