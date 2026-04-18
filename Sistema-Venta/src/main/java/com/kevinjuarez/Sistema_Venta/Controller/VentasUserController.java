package com.kevinjuarez.Sistema_Venta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kevinjuarez.Sistema_Venta.Entity.Venta;
import com.kevinjuarez.Sistema_Venta.Service.VentaService;

@Controller
public class VentasUserController {
    @Autowired
    private VentaService service;

    @GetMapping("/ventasUser")
    public String mostrarVentas(Model model){
        List<Venta> lista = service.getAll();
        model.addAttribute("ventas",lista);
        return "ventasUser";
    }

    @GetMapping("/editarVentasUser/{id}")
    public String formularioEditar(@PathVariable Integer id, Model model) {
        Venta venta = service.getByIdVenta(id);
        model.addAttribute("venta", venta);
        return "editarVentas";
    }

    @PostMapping("/actualizarVentaUser")
    public String guardarVenta(@ModelAttribute Venta venta) {

        System.out.println("ENTRO A ACTUALIZAR");
        System.out.println(venta.getCodigoVenta());

        service.updateVenta(venta.getCodigoVenta(), venta);

        return "redirect:/ventas";
    }
}
