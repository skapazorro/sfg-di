package guru.springframework.sfgdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import guru.springframework.sfgdi.services.SaludoService;

@Controller//Anotacion para identificar esta clase como un componente de tipo controlador
public class PropiedadInyectadaControlador {

	@Autowired//Se anota con Autowired, esto para que se realize la inyeccion de dependencias a travez de spring
	@Qualifier("propiedadSaludoService")
	public SaludoService saludoService;

	public String getSaludo() {
		return saludoService.diSaludos();
	}
}
