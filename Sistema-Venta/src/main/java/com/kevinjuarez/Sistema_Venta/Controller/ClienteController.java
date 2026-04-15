package com.kevinjuarez.Sistema_Venta.Controller;

import com.kevinjuarez.Sistema_Venta.Entity.Cliente;
import com.kevinjuarez.Sistema_Venta.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping("/cliente")
    public String mostrarcliente(Model model){
        List<Cliente> lista = service.getAllCliente();
        model.addAttribute("cliente",lista);
        return "cliente";
    }

    @GetMapping("/eliminar-cliente/{id}")
    public String eliminarCliente(@PathVariable int id) {
        service.deleteCliente(id);
        return "redirect:/cliente";
    }
}
