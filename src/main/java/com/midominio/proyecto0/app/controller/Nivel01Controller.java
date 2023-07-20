package com.midominio.proyecto0.app.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/dados")
@Controller
public class Nivel01Controller {
	
	@GetMapping("/lanzar-dado")
	public String lanzarDado(Model model) {
		Random random = new Random();
		model.addAttribute("tituloHeader", "Lanzamiento de un dado al azar");
		model.addAttribute("titulo", "Lanzamiento de un dado al azar");
		model.addAttribute("parrafo", "Valor del dado lanzado");
		model.addAttribute("valor", random.nextInt(1,7));
		return "nivel01/lanzar-dado";

	}
	@GetMapping({"/lanzar-dos-dados", "/lanzardosdados"})
	public String lanzarDosDados(Model model) {
		Random random = new Random();
		model.addAttribute("tituloHeader", "Lanzamiento de dos dados al azar");
		model.addAttribute("titulo", "Lanzamiento de dos dados al azar");
		model.addAttribute("parrafo", "El valor de los dos dados lanzados es");
		model.addAttribute("valor1", random.nextInt(1,7));
		model.addAttribute("valor2", random.nextInt(1,7));
		return "nivel01/lanzar-dos-dados";

	}
}
