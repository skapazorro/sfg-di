package guru.springframework.sfgdi.services;

import guru.springframework.sfgdi.repo.SaludoEspRepo;

//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Service;

//@Profile({"ES", "default"})//propiedad para determinar en que perfil de la aplicacion se va a usar esta implementacion de servicio
//@Service("I18nService")//el servicio se llamara de la siguiente manera
public class I18nSaludoService implements SaludoService {

	private final SaludoEspRepo saludoEspRepo;
	
	public I18nSaludoService(SaludoEspRepo saludoEspRepo) {
		this.saludoEspRepo = saludoEspRepo;
	}



	@Override
	public String diSaludos() {
		return saludoEspRepo.getSaludo();
	}

}
