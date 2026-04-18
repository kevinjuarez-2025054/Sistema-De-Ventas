package com.kevinjuarez.Sistema_Venta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kevinjuarez.Sistema_Venta.Entity.Producto;
import com.kevinjuarez.Sistema_Venta.Service.ProductoServiceImplements;

@Controller
public class ProductosUserController {
    @Autowired
    private ProductoServiceImplements service;

    @GetMapping("/productosUser")
    public String mostrarProductos(Model model) {
        List<Producto> lista = service.getAllProducto();
        model.addAttribute("productos", lista);
        return "productosUser";
    }

    @GetMapping("/editarProductoUser/{id}")
    public String formularioEditar(@PathVariable Integer id, Model model) {
        Producto producto = service.getById(id);
        model.addAttribute("producto", producto);
        return "editarProductoUser";
    }

    @PostMapping("/actualizarProductoUser")
    public String guardar(@ModelAttribute Producto producto) {
        service.updateProducto(producto.getCodigoProducto(), producto);
        return "redirect:/productosUser";
    }
}
