package com.midominio.proyecto0.app.mode;

public class Animal {
	private double precioEuros;
	private int pesoGramos;
	private String tipo;
	
	public Animal(double precioEuros, int pesoGramos, String tipo) {
		super();
		this.precioEuros = precioEuros;
		this.pesoGramos = pesoGramos;
		this.tipo = tipo;
	}
	public Animal() {
		
	}
	public double getPrecioEuros() {
		return precioEuros;
	}
	public void setPrecioEuros(double precioEuros) {
		this.precioEuros = precioEuros;
	}
	public int getPesoGramos() {
		return pesoGramos;
	}
	public void setPesoGramos(int pesoGramos) {
		this.pesoGramos = pesoGramos;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
