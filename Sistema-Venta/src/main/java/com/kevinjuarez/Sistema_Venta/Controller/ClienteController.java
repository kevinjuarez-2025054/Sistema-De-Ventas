package com.kevinjuarez.Sistema_Venta.Controller;

import com.kevinjuarez.Sistema_Venta.Entity.Cliente;
import com.kevinjuarez.Sistema_Venta.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping("/cliente")
    public String mostrarcliente(Model model){
        List<Cliente> lista = service.getAllCliente();
        model.addAttribute("clientes",lista);
        return "cliente";
    }

    @GetMapping("/eliminar-cliente/{id}")
    public String eliminarCliente(@PathVariable int id) {
        service.deleteCliente(id);
        return "redirect:/cliente";
    }

    @GetMapping("/editarcliente/{id}")
    public String formularioEditar(@PathVariable Integer id, Model model) {
        Cliente cliente = service.getByIdCliente(id);
        model.addAttribute("cliente", cliente);
        return "EditarCliente";
    }

    @PostMapping("/cliente/guardarcliente")
    public String guardarCliente(@ModelAttribute Cliente cliente) {

        System.out.println("ENTRO A ACTUALIZAR");
        System.out.println(cliente.getDpiCliente());

        service.updateCliente(cliente.getDpiCliente(), cliente);

        return "redirect:/cliente";
    }
}