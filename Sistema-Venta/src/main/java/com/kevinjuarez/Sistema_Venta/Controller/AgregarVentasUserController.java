package com.kevinjuarez.Sistema_Venta.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kevinjuarez.Sistema_Venta.Entity.Venta;
import com.kevinjuarez.Sistema_Venta.Service.ClienteService;
import com.kevinjuarez.Sistema_Venta.Service.UsuarioService;
import com.kevinjuarez.Sistema_Venta.Service.VentaService;

@Controller
public class AgregarVentasUserController {
    @Autowired
    private VentaService ventaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/agregarVentaUser")
    public String agregarVenta(Model model){

        model.addAttribute("venta", new Venta());
        model.addAttribute("clientes", clienteService.getAllCliente());
        model.addAttribute("usuarios", usuarioService.getAllUsuario());

        return "agregarVentaUser";
    }

    @PostMapping("/guardarVentaUser")
    public String guardarVenta(@ModelAttribute Venta venta){

        venta.setEstado(1);

        ventaService.saveVenta(venta);

        return "redirect:/ventasUser";
    }
}
