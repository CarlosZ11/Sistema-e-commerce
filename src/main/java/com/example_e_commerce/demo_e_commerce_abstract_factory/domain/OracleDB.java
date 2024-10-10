package com.example_e_commerce.demo_e_commerce_abstract_factory.domain;

import com.example_e_commerce.demo_e_commerce_abstract_factory.modelo.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OracleDB implements IProductoDB{

    private static OracleDB instance;
    private Map<String, Producto> productos;

    private OracleDB() {
        this.productos = new HashMap<>();
        // Agregando algunos productos por defecto
        productos.put("1", new Producto(1, "Camisa Sambarlot", 100.0));
        productos.put("2", new Producto(2, "Camisa Arturo Calle", 200.0));
    }

    // Método para obtener la única instancia de OracleDB
    public static OracleDB getInstance() {
        if (instance == null) {
            instance = new OracleDB();
        }
        return instance;
    }

    @Override
    public void create(Producto producto) {
        productos.put(String.valueOf(producto.getId()), producto);
    }

    @Override
    public Producto read(int id) {
        return productos.get(String.valueOf(id));
    }

    @Override
    public void update(Producto producto) {
        productos.put(String.valueOf(producto.getId()), producto);
    }

    @Override
    public void delete(int id) {
        productos.remove(String.valueOf(id));
    }

    @Override
    public List<Producto> getAllProductos() {
        return new ArrayList<>(productos.values());
    }
}
