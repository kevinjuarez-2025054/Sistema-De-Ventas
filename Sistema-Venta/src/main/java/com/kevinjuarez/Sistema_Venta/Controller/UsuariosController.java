package com.kevinjuarez.Sistema_Venta.Controller;

import com.kevinjuarez.Sistema_Venta.Entity.Usuario;
import com.kevinjuarez.Sistema_Venta.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UsuariosController {
    @Autowired
    private UsuarioService service;

    @GetMapping("/usuarios")
    public String mostrarUsuarios(){
        return "usuarios";
    }

    // LISTA
    @GetMapping("/lista")
    public String listar(Model model) {
        List<Usuario> lista = service.getAllUsuario();
        model.addAttribute("usuarios", lista);
        return "lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        service.deleteUsuario(id);
        return "redirect:/lista";
    }
}
