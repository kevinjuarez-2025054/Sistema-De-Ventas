package com.kevinjuarez.Sistema_Venta.Controller;

import com.kevinjuarez.Sistema_Venta.Entity.Usuario;
import com.kevinjuarez.Sistema_Venta.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UsuarioService service;

    //inicio de login
    @GetMapping("/")
    public String inicio(){
        return "redirect:/login";
    }

    //Mostrar Login
    @GetMapping("/login")
    public String mostrarLogin(){
        return "login";
    }

    //Procesar Login
    @PostMapping("/logear")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        Usuario u = service.login(username, password);

        if (u != null) {
            return "redirect:/home-login";
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "login";
        }
    }

    @GetMapping("/home-login")
    public String mostrarHome(){
        return "home";
    }
}
