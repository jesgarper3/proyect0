package com.midominio.proyecto0.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MiPrimerControlador {

	@GetMapping({"/mi-primer-weblink", "/miprimerweblink"})
	public String miPrimerMetodoHandler() {

		return "mi-primera-vista";
	}
	@GetMapping({"/", "/home", "/home/"})
	public String miSegundoMetodoHandler() {

		return "index";
	}

}
