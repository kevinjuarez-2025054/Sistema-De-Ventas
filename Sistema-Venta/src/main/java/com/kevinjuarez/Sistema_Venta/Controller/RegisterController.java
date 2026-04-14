package com.kevinjuarez.Sistema_Venta.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    @GetMapping("/register")
    public String mostrarRegister(){
        return "register";
    }

    @PostMapping("register-login")
    public String registrarUsuario(){
        return "redirect:/index";
    }
}
