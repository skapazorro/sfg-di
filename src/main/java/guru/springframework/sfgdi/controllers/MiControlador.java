package guru.springframework.sfgdi.controllers;

import org.springframework.stereotype.Controller;

import guru.springframework.sfgdi.services.SaludoService;

@Controller//Se anota como controlador para que spring lo identifique como un componente de la aplicacion de tipo controlador
public class MiControlador {
//utilizara la implementacion de servicio marcada como primaria
	private final SaludoService saludoService;

	public MiControlador(SaludoService saludoService) {
		this.saludoService = saludoService;
	}

	public String diHola() {
		return saludoService.diSaludos();
	}

}
