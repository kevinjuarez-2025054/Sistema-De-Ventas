package com.kevinjuarez.Sistema_Venta.Controller;

import com.kevinjuarez.Sistema_Venta.Entity.Producto;
import com.kevinjuarez.Sistema_Venta.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AgregarProductosController {

    @Autowired
    private ProductoService service;

    @GetMapping("/agregarProducto")
    public String agregarProducto(Model model){
        model.addAttribute("producto", new Producto());
        return "agregarProducto";
    }

    @PostMapping("/guardarProducto")
    public String guardarProducto(@ModelAttribute Producto producto){

        producto.setEstado(1);

        service.saveProducto(producto);

        return "redirect:/productos";
    }
}