package com.kevinjuarez.Sistema_Venta.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kevinjuarez.Sistema_Venta.Entity.Producto;
import com.kevinjuarez.Sistema_Venta.Service.ProductoService;

@Controller
public class AgregarProductosUserController {
    @Autowired
    private ProductoService service;

    @GetMapping("/agregarProductoUser")
    public String agregarProducto(Model model){
        model.addAttribute("producto", new Producto());
        return "agregarProductosUser";
    }

    @PostMapping("/guardarProductoUser")
    public String guardarProducto(@ModelAttribute Producto producto){

        producto.setEstado(1);

        service.saveProducto(producto);

        return "redirect:/productosUser";
    }
}
