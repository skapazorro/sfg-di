package guru.springframework.sfgdi.services;

//import org.springframework.stereotype.Service;

//@Service//Se anota como service para hacerle saber a spring que es un componente de tipo servicio
public class PropiedadSaludoService implements SaludoService {

		@Override
		public String diSaludos() {
			return "hola mundillo imperfecto - Propiedad";
		}

}
