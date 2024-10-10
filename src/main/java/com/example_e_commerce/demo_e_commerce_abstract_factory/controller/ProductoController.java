package com.example_e_commerce.demo_e_commerce_abstract_factory.controller;

import com.example_e_commerce.demo_e_commerce_abstract_factory.config.Configuracion;
import com.example_e_commerce.demo_e_commerce_abstract_factory.dao.ProductoDAO;
import com.example_e_commerce.demo_e_commerce_abstract_factory.modelo.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private ProductoDAO productoDAO;

    //Método para configurar la base de datos basado en el tipo
    private void setProductoDAO(String dbType) {
        productoDAO = new ProductoDAO(Configuracion.configureAdapterDB(dbType));
    }

    @PostMapping
    public ResponseEntity<String> createProducto(@RequestBody Producto producto, @RequestParam String dbType) {
        try {
            setProductoDAO(dbType);
            productoDAO.createProducto(producto);
            return new ResponseEntity<>("Producto creado con éxito.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el producto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProducto(@PathVariable int id, @RequestParam String dbType) {
        try {
            setProductoDAO(dbType);
            Producto producto = productoDAO.getProducto(id);
            if (producto != null) {
                return new ResponseEntity<>(producto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Producto no encontrado.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener el producto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProducto(@PathVariable int id, @RequestBody Producto producto, @RequestParam String dbType) {
        try {
            setProductoDAO(dbType);
            producto.setId(id);
            productoDAO.updateProducto(producto);
            return new ResponseEntity<>("Producto actualizado con éxito.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el producto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable int id, @RequestParam String dbType) {
        try {
            setProductoDAO(dbType);
            productoDAO.deleteProducto(id);
            return new ResponseEntity<>("Producto eliminado con éxito.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el producto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllProductos(@RequestParam String dbType) {
        try {
            setProductoDAO(dbType);
            List<Producto> productos = productoDAO.getAllProductos();
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener la lista de productos: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
