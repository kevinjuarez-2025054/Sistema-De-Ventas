package com.kevinjuarez.Sistema_Venta.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VentasController {
    @GetMapping("/ventas")
    public String mostrarVentas(){
        return "ventas";
    }
}
