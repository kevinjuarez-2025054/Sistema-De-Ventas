package com.kevinjuarez.Sistema_Venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaVentaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SistemaVentaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("test API");
	}
}
