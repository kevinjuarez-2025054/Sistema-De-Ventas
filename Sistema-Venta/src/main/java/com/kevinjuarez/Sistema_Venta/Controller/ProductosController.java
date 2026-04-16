package com.kevinjuarez.Sistema_Venta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kevinjuarez.Sistema_Venta.Entity.Producto;
import com.kevinjuarez.Sistema_Venta.Service.ProductoServiceImplements;

@Controller
public class ProductosController {
    @Autowired
    private ProductoServiceImplements service;

    @GetMapping("/productos")
    public String mostrarProductos(Model model){
        List<Producto> lista = service.getAllProducto();
        model.addAttribute("productos", lista);
        return "productos";
    }

    @GetMapping("/eliminar-producto/{id}")
    public String eliminarProducto(@PathVariable int id) {
        service.deleteProducto(id);
        return "redirect:/productos";
    }
}
