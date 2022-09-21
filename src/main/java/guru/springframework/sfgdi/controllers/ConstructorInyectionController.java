package guru.springframework.sfgdi.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import guru.springframework.sfgdi.services.SaludoService;

@Controller//Anotacion para identificar esta clase como un componente de tipo controlador
public class ConstructorInyectionController {
	private final SaludoService saludoServise;

	//Se inyecta la dependencia por medio del controlador, no hay necesidad de anotarlo con @Autowired,
    //sin embargo, la propiedad se anota como @Qualifier para que pueda diferenciar que implementacion de servicio tiene que realizar
	public ConstructorInyectionController(@Qualifier("constructorSaludoService") SaludoService saludoServise) {
		this.saludoServise = saludoServise;
	}

	public String getSaludo() {
		return saludoServise.diSaludos();
	}
}
