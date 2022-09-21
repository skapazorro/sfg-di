package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Service;

@Service//Se anota como service para hacerle saber a spring que es un componente de tipo servicio
public class SetterSaludoService implements SaludoService {

	@Override
	public String diSaludos() {
		// TODO Auto-generated method stub
		return "hola mundillo imperfecto - Setter";
	}

}
