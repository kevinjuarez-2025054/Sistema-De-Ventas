package com.kevinjuarez.Sistema_Venta.Controller;

import com.kevinjuarez.Sistema_Venta.Entity.Venta;
import com.kevinjuarez.Sistema_Venta.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/eliminar-cliente/{id}")
    public String eliminarCliente(@PathVariable int id) {
        service.deleteVenta(id);
        return "redirect:/ventas";
    }
}
