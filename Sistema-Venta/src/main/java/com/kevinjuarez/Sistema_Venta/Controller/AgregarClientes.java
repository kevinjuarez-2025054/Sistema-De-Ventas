package com.kevinjuarez.Sistema_Venta.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kevinjuarez.Sistema_Venta.Entity.Cliente;
import com.kevinjuarez.Sistema_Venta.Service.ClienteService;

@Controller
public class AgregarClientes {
    @Autowired
    private ClienteService service;

    @GetMapping("/agregarCliente")
    public String agregarCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "agregarCliente";
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(@ModelAttribute Cliente cliente) {
        service.saveCliente(cliente);
        return "redirect:/cliente";
    }
}
