package com.kevinjuarez.Sistema_Venta.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kevinjuarez.Sistema_Venta.Entity.DetalleVentas;
import com.kevinjuarez.Sistema_Venta.Service.DetalleVentaService;
import com.kevinjuarez.Sistema_Venta.Service.ProductoService;
import com.kevinjuarez.Sistema_Venta.Service.VentaService;

@Controller
public class agregarDetallesVentaUserController {
    @Autowired
    private DetalleVentaService service;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private VentaService ventaService;

    @GetMapping("/agregarDetalleVentaUser")
public String agregarDetalleVenta(Model model){

    model.addAttribute("detalleventa", new DetalleVentas());
    model.addAttribute("productos", productoService.getAllProducto());
    model.addAttribute("ventas", ventaService.getAll());

    return "agregarDetalleVentaUser";
}

    @PostMapping("/guardarDetalleVentaUser")
    public String guardarDetalleVenta(@ModelAttribute DetalleVentas detalleVenta) {
        service.saveDetalleVenta(detalleVenta);
        return "redirect:/detalleventasUser";
    }
}
