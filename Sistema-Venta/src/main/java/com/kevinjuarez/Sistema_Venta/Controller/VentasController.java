package com.kevinjuarez.Sistema_Venta.Controller;

import com.kevinjuarez.Sistema_Venta.Entity.Venta;
import com.kevinjuarez.Sistema_Venta.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class VentasController {
    @Autowired
    private VentaService service;

    @GetMapping("/ventas")
    public String mostrarVentas(Model model){
        List<Venta> lista = service.getAll();
        model.addAttribute("ventas",lista);
        return "ventas";
    }

    @GetMapping("/eliminar-ventas/{id}")
    public String eliminarVentas(@PathVariable int id) {
        service.deleteVenta(id);
        return "redirect:/ventas";
    }

    @GetMapping("/editarVentas/{id}")
    public String formularioEditar(@PathVariable Integer id, Model model) {
        Venta venta = service.getByIdVenta(id);
        model.addAttribute("venta", venta);
        return "editarVentas";
    }

    @PostMapping("/actualizarVenta")
    public String guardarVenta(@ModelAttribute Venta venta) {

        System.out.println("ENTRO A ACTUALIZAR");
        System.out.println(venta.getCodigoVenta());

        service.updateVenta(venta.getCodigoVenta(), venta);

        return "redirect:/ventas";
    }
}
