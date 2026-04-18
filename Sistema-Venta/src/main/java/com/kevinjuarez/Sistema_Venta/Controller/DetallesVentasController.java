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
public class DetallesVentasController {
    @Autowired
    private DetalleVentaServiceImplements service;

    @GetMapping("/detalleventas")
    public String mostrarDetalleVentas(Model model){
        List<DetalleVentas> lista = service.getAll();
        model.addAttribute("detalleventas",lista);
        return "detalleventas";
    }

    @GetMapping("/eliminar-detalleventas/{id}")
    public String eliminarDetalleVentas(@PathVariable int id) {
        service.deleteDetalleVenta(id);
        return "redirect:/detalleventas";
    }

    @GetMapping("/editarDetalleVenta/{id}")
    public String formularioEditar(@PathVariable Integer id, Model model) {
        model.addAttribute("detalleVenta", service.getById(id));
        return "editarDetalleVenta";
    }

    @PostMapping("/actualizarDetalleVenta")
    public String actualizar(@ModelAttribute DetalleVentas detalleVenta) {
        DetalleVentas original = service.getById(detalleVenta.getCodigoDetalleVenta());
        original.setCantidad(detalleVenta.getCantidad());
        original.setPrecioUnitario(detalleVenta.getPrecioUnitario());
        original.setSubtotal(detalleVenta.getSubtotal());
        service.updateDetalleVenta(original.getCodigoDetalleVenta(), original);
        return "redirect:/detalleventas";
    }
}
