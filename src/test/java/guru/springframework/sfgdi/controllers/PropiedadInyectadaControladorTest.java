package guru.springframework.sfgdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgdi.services.ConstructorSaludoService;

class PropiedadInyectadaControladorTest {
	PropiedadInyectadaControlador controllador;
	
	@BeforeEach
	void setUp() {
		controllador = new PropiedadInyectadaControlador();
		controllador.saludoService = new ConstructorSaludoService();
	}

	@Test
	void getSaludo() {
		System.out.println(controllador.getSaludo());
	}

}
