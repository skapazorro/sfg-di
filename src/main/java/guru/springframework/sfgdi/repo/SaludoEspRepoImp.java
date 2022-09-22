package guru.springframework.sfgdi.repo;

public class SaludoEspRepoImp implements SaludoEspRepo {

	@Override
	public String getSaludo() {
		return "Hola mundo imperfecto - ES -Repo";
	}

}
