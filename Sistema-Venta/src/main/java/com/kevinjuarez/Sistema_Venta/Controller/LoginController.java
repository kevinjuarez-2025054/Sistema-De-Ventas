package com.kevinjuarez.Sistema_Venta.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    //inicio de login
    @GetMapping("/")
    public String inicio(){
        return "redirect:/index";
    }

    //Mostrar Login
    @GetMapping("/index")
    public String mostrarLogin(){
        return "index";
    }

    //Procesar Login
    @PostMapping("/login")
    public String login(@RequestParam String usuario,
                        @RequestParam String password,
                        HttpSession session,
                        Model model){
        String userCorrecto = "admin";
        String passwordCorrecto = "1234";

        if (usuario.equals(userCorrecto) && password.equals(passwordCorrecto)){
            //Guardar Sesion
            session.setAttribute("usuarioLogeado", usuario);
            return "redirect:/home";
        }else {
            model.addAttribute("error","usuario y contrasena incorrectos");
            return "index";
        }
    }

    //proteger ruta sin SpringSecurity
    @GetMapping("/home-login")
    public String mostrarHome(HttpSession session){

        //validar la sesion
        if (session.getAttribute("usuarioLogeado") ==null){
            return "redirect:/index";
        }
        return "home";
    }
}
