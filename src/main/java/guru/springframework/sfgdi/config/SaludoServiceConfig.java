package guru.springframework.sfgdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import guru.springframework.sfgdi.repo.SaludoEspRepo;
import guru.springframework.sfgdi.repo.SaludoEspRepoImp;
import guru.springframework.sfgdi.services.ConstructorSaludoService;
import guru.springframework.sfgdi.services.I18nSaludoService;
import guru.springframework.sfgdi.services.PrimaryGreetingService;
import guru.springframework.sfgdi.services.PropiedadSaludoService;
import guru.springframework.sfgdi.services.SetterSaludoService;
import guru.springframework.sfgdi.services.I18nEnglishService;

@Configuration // se utiliza cuando no somo dueños del codigo, y queremos traer ese codigo a nuestra aplicacion
public class SaludoServiceConfig {

	@Bean
	ConstructorSaludoService constructorSaludoService() {
		return new ConstructorSaludoService();
	}

	@Bean
	PropiedadSaludoService propiedadSaludoService() {
		return new PropiedadSaludoService();
	}

	@Bean
	SetterSaludoService setterSaludoService() {
		return new SetterSaludoService();
	}
	
	@Primary
	@Bean
	PrimaryGreetingService primaryGreetingService() {
		return new PrimaryGreetingService();
	}
	
	@Bean
	SaludoEspRepo saludoEspRepo() {
		return new SaludoEspRepoImp();
	}
	
	@Profile({"ES","default"})
	@Bean
	I18nSaludoService i18nService(SaludoEspRepo saludoInglesRepo) {
		return new I18nSaludoService(saludoInglesRepo);
	}
	
	@Profile({"EN"})
	@Bean("i18nService")
	I18nEnglishService i18nEnglishService() {
		return new I18nEnglishService();
	}
}
