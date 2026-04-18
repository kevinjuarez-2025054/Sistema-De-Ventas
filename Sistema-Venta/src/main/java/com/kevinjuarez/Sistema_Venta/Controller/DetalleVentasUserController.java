package com.kevinjuarez.Sistema_Venta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kevinjuarez.Sistema_Venta.Entity.DetalleVentas;
import com.kevinjuarez.Sistema_Venta.Service.DetalleVentaServiceImplements;

@Controller
public class DetalleVentasUserController {
    @Autowired
    private DetalleVentaServiceImplements service;

    @GetMapping("/detalleventasUser")
    public String mostrarDetalleVentas(Model model){
        List<DetalleVentas> lista = service.getAll();
        model.addAttribute("detalleventas",lista);
        return "detalleventasUser";
    }

    @GetMapping("/editarDetalleVentaUser/{id}")
    public String formularioEditar(@PathVariable Integer id, Model model) {
        model.addAttribute("detalleVenta", service.getById(id));
        return "editarDetalleVentaUser";
    }

    @PostMapping("/actualizarDetalleVentaUser")
    public String actualizar(@ModelAttribute DetalleVentas detalleVenta) {
        DetalleVentas original = service.getById(detalleVenta.getCodigoDetalleVenta());
        original.setCantidad(detalleVenta.getCantidad());
        original.setPrecioUnitario(detalleVenta.getPrecioUnitario());
        original.setSubtotal(detalleVenta.getSubtotal());
        service.updateDetalleVenta(original.getCodigoDetalleVenta(), original);
        return "redirect:/detalleventasUser";
    }
}
