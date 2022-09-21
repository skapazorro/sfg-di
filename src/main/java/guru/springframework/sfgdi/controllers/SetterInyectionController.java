package guru.springframework.sfgdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import guru.springframework.sfgdi.services.SaludoService;

@Controller
public class SetterInyectionController {

	@Autowired//Se anota con Autowired, esto para que se realize la inyeccion de dependencias a travez de spring
	@Qualifier("setterSaludoService")//se anota con el servicio que se requiere utilizar
	private SaludoService saludoServise;

	public void setSaludoService(SaludoService saludoService) {
		this.saludoServise = saludoService;
	}

	public String getSaludo() {
		return saludoServise.diSaludos();
	}
}
