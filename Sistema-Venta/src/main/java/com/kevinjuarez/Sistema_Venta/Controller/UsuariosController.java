package com.kevinjuarez.Sistema_Venta.Controller;

import com.kevinjuarez.Sistema_Venta.Entity.Usuario;
import com.kevinjuarez.Sistema_Venta.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuariosController {
    @Autowired
    private UsuarioService service;

    // LISTA
    @GetMapping("/usuarios")
    public String listar(Model model) {
        List<Usuario> lista = service.getAllUsuario();
        model.addAttribute("usuarios", lista);
        return "usuarios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        service.deleteUsuario(id);
        return "redirect:/usuarios";
    }

    @GetMapping("/editarUsuario/{id}")
    public String formularioEditar(@PathVariable Integer id, Model model) {
        model.addAttribute("usuario", service.getById(id));
        return "editarUsuario";
    }

    @PostMapping("/actualizarUsuario")
    public String actualizar(@ModelAttribute Usuario usuario) {
        service.updateUsuario(usuario.getCodigoUsuario(), usuario);
        return "redirect:/usuarios";
    }
}
