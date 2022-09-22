package guru.springframework.sfgdi.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import guru.springframework.sfgdi.services.SaludoService;

@Controller
public class I18nControler {

	private final SaludoService saludoService;

	public I18nControler(@Qualifier("i18nService") SaludoService saludoService) {
		this.saludoService = saludoService;
	}
	
	public String diHola() {
		return saludoService.diSaludos();
	}
}
