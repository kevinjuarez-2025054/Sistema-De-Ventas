package com.kevinjuarez.Sistema_Venta.Controller;

import com.kevinjuarez.Sistema_Venta.Entity.Usuario;
import com.kevinjuarez.Sistema_Venta.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    @Autowired
    private UsuarioService service;

    @GetMapping("/register")
    public String mostrarRegister(){
        return "register";
    }

    @PostMapping("/registrar")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        @RequestParam String email,
                        Model model) {

        Usuario u = service.registrar(username, password,email);

        if (u != null) {
            return "redirect:/register-login";
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "login";
        }
    }

    @PostMapping("register-login")
    public String registrarUsuario(){
        return "login";
    }
}
