package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("EN")
@Service("I18nService")
public class I18nEnglishService implements SaludoService {

	@Override
	public String diSaludos() {
		// TODO Auto-generated method stub
		return "Hello imperfect world - EN";
	}

}
