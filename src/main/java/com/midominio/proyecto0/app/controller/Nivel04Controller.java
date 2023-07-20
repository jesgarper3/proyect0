package com.midominio.proyecto0.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/varios")
@Controller
public class Nivel04Controller {

	//Incorporación de estilos e imagen externa
	@GetMapping("/ejemplo1")
	public String m1(Model model) {
		model.addAttribute("titulo", "Estilos e imágenes static");
		model.addAttribute("cabecera", "Prueba estilos e imágenes desde static");
		model.addAttribute("texto", "Esta es una imagen de ejemplo");
		model.addAttribute("valor", "Estilos sacados desde un style.css externo al html");
		
		return "nivel04/ejemplo01";
	}
	
	@GetMapping("ejemplo2/{texto1}")
	public String m2a(@PathVariable (name = "texto1")  String miTexto1,
			@PathVariable String texto2,
			Model model) {
		model.addAttribute("titulo", "@PathVariable");
		model.addAttribute("cabecera", "Probando @PathVariable");
		model.addAttribute("texto", "Para recoger la información que se introduce por parámetros en la ruta");
		model.addAttribute("valor", "Recogido de la ruta " + miTexto1 + " - " + texto2);
		
		return "nivel04/ejemplo03";			
	}

	
	@GetMapping("ejemplo2/{texto1}/{texto2}")
	public String m2(@PathVariable (name = "texto1")  String miTexto1,
			@PathVariable String texto2,
			Model model) {
		model.addAttribute("titulo", "@PathVariable");
		model.addAttribute("cabecera", "Probando @PathVariable");
		model.addAttribute("texto", "Para recoger la información que se introduce por parámetros en la ruta");
		model.addAttribute("valor", "Recogido de la ruta " + miTexto1 + " - " + texto2);
		
		return "nivel04/ejemplo02";			
	}

	@GetMapping("ejemplo3/listado-enlaces")
	public String m3(Model model) {
		model.addAttribute("titulo", "Listado de enlaces");
		model.addAttribute("cabecera", "Poner varios enlaces en una página");
		model.addAttribute("texto", "Los enlaces son:");

		return "nivel04/ejemplo03";			
	}
}
