package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service//Se anota como service para hacerle saber a spring que es un componente de tipo servicio
@Primary//Se anota con primary para que esta sea la implementacion del servicio primaria (la que se usara por default)
public class PrimaryGreetingService implements SaludoService {

	@Override
	public String diSaludos() {
		// TODO Auto-generated method stub
		return "Hola mundillo imperfecto - Bean primario";
	}

}
