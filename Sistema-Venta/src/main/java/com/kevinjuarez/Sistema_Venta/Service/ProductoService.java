package com.kevinjuarez.Sistema_Venta.Service;

import com.kevinjuarez.Sistema_Venta.Entity.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> getAllProducto();
    Producto getById(Integer id);
    Producto saveProducto(Producto producto) throws RuntimeException;
    Producto updateProducto(Integer id,Producto producto);
    void deleteProducto(Integer id);
}
