/**
 * 
 */
package guru.springframework.sfgdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgdi.services.ConstructorSaludoService;

/**
 * @author Win10
 *
 */
class ConstructorInyectionControllerTest {

	ConstructorInyectionController controllador;
	
	@BeforeEach
	void setUp() {
		controllador = new ConstructorInyectionController(new ConstructorSaludoService());
	}


	@Test
	void GetSaludo() {
		System.out.println(controllador.getSaludo());
	}

}
