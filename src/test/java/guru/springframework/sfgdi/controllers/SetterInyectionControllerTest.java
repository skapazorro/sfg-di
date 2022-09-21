package guru.springframework.sfgdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgdi.services.ConstructorSaludoService;

class SetterInyectionControllerTest {

	SetterInyectionController controlador;

	@BeforeEach
	void setUp() {
		controlador = new SetterInyectionController();
		controlador.setSaludoService(new ConstructorSaludoService());
	}

	@Test
	void getSaludo() {
		System.out.println(controlador.getSaludo());
	}
}
