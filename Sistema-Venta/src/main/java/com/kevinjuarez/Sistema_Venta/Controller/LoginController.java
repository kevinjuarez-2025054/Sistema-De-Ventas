package com.kevinjuarez.Sistema_Venta.Controller;

import com.kevinjuarez.Sistema_Venta.Entity.Usuario;
import com.kevinjuarez.Sistema_Venta.Service.UsuarioService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


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

    @PostMapping("/logear")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {

        Usuario u = service.login(username, password);

        if (u != null) {
            session.setAttribute("usuario", u);

            if ("ADMIN".equals(u.getRol())) {
                return "redirect:/home";
            } else {
                return "redirect:/homeUser";
            }

        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "login";
        }
    }

    @GetMapping("/home-login")
    public String mostrarHomeAdmin(HttpSession session) {
        Usuario u = (Usuario) session.getAttribute("usuario");
        if (u == null || !"ADMIN".equals(u.getRol())) {
            return "redirect:/login";
        }
        return "home";
    }

    @GetMapping("/homeUser")
    public String mostrarHomeUser(HttpSession session) {
        Usuario u = (Usuario) session.getAttribute("usuario");
        if (u == null || !"USER".equals(u.getRol())) {
            return "redirect:/login";
        }
        return "homeUser";
    }
}
