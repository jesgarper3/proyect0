package com.midominio.proyecto0.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.midominio.proyecto0.app.mode.Animal;

@RequestMapping("/animales")
@Controller
public class Nivel02Controller {
	
	//model.addAttribute("tituloHeader", "animales");
	@Value("Animales")
	private String tituloHeader;
	
	@ModelAttribute("animales")
	public List<Animal> listaAnimales2(){
		List<Animal> animales = new ArrayList<>();
		animales.add(new Animal(150, 2_350, "gato"));
		animales.add(new Animal(25, 7_220, "perro"));
		animales.add(new Animal(100, 350, "salamanquesa"));
		animales.add(new Animal(125, 5_000, "gato"));
		return animales;

	}

	@GetMapping({ "/un-gato", "/ungato" })
	public String unGato(Model model) {
		Animal gato = new Animal();
		gato.setTipo("gato");
		gato.setPesoGramos(3_120);
		gato.setPrecioEuros(77.5);
		

		model.addAttribute("titulo", tituloHeader);
		model.addAttribute("cabecera", "Mostrando un gato");
		model.addAttribute("texto", "Estos son los datos de mi gato:");
		model.addAttribute("animal", gato);

		return "animales/un-gato";

	}
	@GetMapping({"/ningun-gato", "/ningungato"})
	public String ningunGato(Model model) {
		Animal gato = null;
		
		model.addAttribute("titulo", tituloHeader);

		model.addAttribute("cabecera", "Mostrando un gato");
		model.addAttribute("cabeceraSinGato", "Mostrando ningún gato");
		model.addAttribute("texto", "Estos son los datos de mi gato:");
		model.addAttribute("textoSinGato", "No hay ningún gato para mostrar su información.");
		model.addAttribute("animal", gato);

		return "animales/un-gato";

	}
	
	@GetMapping({"/lista", "/lista-animales"})
	public String m2(Model model) {
		
		/*List<Animal> animales = new ArrayList<>();
		animales.add(new Animal(150, 2_350, "gato"));
		animales.add(new Animal(25, 7_220, "perro"));
		animales.add(new Animal(100, 350, "salamanquesa"));
		animales.add(new Animal(125, 5_000, "gato"));
		//animales.clear();*/
		
		model.addAttribute("tituloHeader", this.tituloHeader);
		model.addAttribute("titulo", "Mostrando lista de animales");
		model.addAttribute("texto", "Estos son los datos de mi gato:");
		model.addAttribute("textoListaVacia", "No hay ningún animal que mostrar.");
		//model.addAttribute("animales", animales);
		
		return "animales/lista-animales";
	}
}
