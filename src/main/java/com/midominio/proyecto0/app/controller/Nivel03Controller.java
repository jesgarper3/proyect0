package com.midominio.proyecto0.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.midominio.proyecto0.app.mode.Animal;

@RequestMapping("/animales")
@Controller
public class Nivel03Controller {
	
	/*@Value("Animales variados")
	private String tituloNavegador;*/
	
	@ModelAttribute("tituloNavegador")
	public String devuelveTitulo() {
		return "Animales variados";		
	}
	
	//@ModelAttribute("listadoCompletoAnimales")
	public List<Animal> listadoCompletoAnimales() {
		List<Animal> animales = new ArrayList<>();
		animales.add(new Animal(50, 2_350, "gato"));
		animales.add(new Animal(1250, 17_220, "perro"));
		animales.add(new Animal(75, 3_500, "perro"));
		animales.add(new Animal(235, 5_400, "gato"));
		animales.add(new Animal(172, 50_300, "perro"));
		animales.add(new Animal(350, 75_300, "perro"));
		animales.add(new Animal(140, 9_044, "gato"));
		animales.add(new Animal(800, 18_333, "perro"));
		animales.add(new Animal(1500, 9_430, "gato"));
		animales.add(new Animal(13800, 18_050, "mono"));
		animales.add(new Animal(100, 190, "pájaro"));
		animales.add(new Animal(19500, 25_800, "perro"));
		animales.add(new Animal(17200, 18_600, "mono"));
		animales.add(new Animal(4000, 9_300, "gato"));
		animales.add(new Animal(230, 200, "pájaro"));
		animales.add(new Animal(8700, 6_500, "gato"));
		animales.add(new Animal(16900, 17_500, "mono"));
		animales.add(new Animal(14700, 11_500, "perro"));
		animales.add(new Animal(6000, 220, "pájaro"));
		animales.add(new Animal(9200, 70, "camaleón"));
		animales.add(new Animal(6600, 200, "pájaro"));
		animales.add(new Animal(4300, 9_300, "gato"));
		animales.add(new Animal(8100, 20_300, "mono"));
		animales.add(new Animal(9800, 160, "pájaro"));
		animales.add(new Animal(7700, 19_200, "perro"));
		return animales;
	}
	
	@GetMapping({"/listado-flexible", "/listadoflexible"})
	public String listadoFlexible(Model model) {
		
	
		model.addAttribute("titulo", "Mostrando lista completa de " + this.listadoCompletoAnimales().size() + " animales");
		model.addAttribute("texto", "Esta es la lista de animales");
		model.addAttribute("textoListaVacia", "No hay ningún animal que mostrar.");
		model.addAttribute("animales", listadoCompletoAnimales());
		
		return "animales/lista-animales";
	}
	
	@GetMapping({"/listado-flexible2", "/listadoflexible2"})
	public String listadoFlexible2(Model model) {
		
		List<Animal> listaCompleta = listadoCompletoAnimales();
		List<Animal> listaFiltrada = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			listaFiltrada.add(listaCompleta.get(i));
		}
	
		model.addAttribute("titulo", "Mostrando lista completa de " + listaFiltrada.size() + " animales");
		model.addAttribute("texto", "Esta es la lista de animales");
		model.addAttribute("textoListaVacia", "No hay ningún animal que mostrar.");
		model.addAttribute("animales", listaFiltrada);
		
		return "animales/lista-animales";
	}
	
	@GetMapping({"/listado-flexible3", "/listadoflexible3"})
	public String listadoFlexible3(@RequestParam("cantidadEnRuta") int cantidadEnMetodo, Model model) {
		
		List<Animal> listaCompleta = listadoCompletoAnimales();
		cantidadEnMetodo = cantidadEnMetodo < 0 ? 0 : cantidadEnMetodo > listaCompleta.size() ? listaCompleta.size() : cantidadEnMetodo;
		List<Animal> listaFiltrada = new ArrayList<>();
		for (int i = 0; i < cantidadEnMetodo; i++) {
			listaFiltrada.add(listaCompleta.get(i));
		}
	
		model.addAttribute("titulo", "Mostrando lista completa de " + listaFiltrada.size() + " animales");
		model.addAttribute("texto", "Esta es la lista de animales");
		model.addAttribute("textoListaVacia", "No hay ningún animal que mostrar.");
		model.addAttribute("animales", listaFiltrada);
		
		return "animales/lista-animales";
	}
	
	@GetMapping({"/listado-flexible4", "/listadoflexible4"})
	public String listadoFlexible4(@RequestParam int cantidad,@RequestParam(value="tipo", required = false, defaultValue = "gato") String tipo, Model model) {
		
		List<Animal> listaCompleta = listadoCompletoAnimales();
		cantidad = cantidad < 0 ? 0 : cantidad > listaCompleta.size() ? listaCompleta.size() : cantidad;
		List<Animal> listaFiltrada = new ArrayList<>();
		
		int contadorAnimales = 0;
		
		for (int i = 0; i < cantidad; i++) {
			if (tipo == null) break; 
			if (tipo.equals(listaCompleta.get(i).getTipo()) && contadorAnimales < cantidad) {
				listaFiltrada.add(listaCompleta.get(i));
				contadorAnimales++;
			}
			if (contadorAnimales > cantidad) break;
		}
		
		
	
		model.addAttribute("titulo", "Mostrando lista completa de " + listaFiltrada.size() + " animales");
		model.addAttribute("texto", "Esta es la lista de animales");
		model.addAttribute("textoListaVacia", "No hay ningún animal que mostrar.");
		model.addAttribute("animales", listaFiltrada);
		
		return "animales/lista-animales";
	}
}
