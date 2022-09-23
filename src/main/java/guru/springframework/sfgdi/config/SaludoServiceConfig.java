package guru.springframework.sfgdi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.springframework.mascotas.MascotaServiceFactory;
import com.springframework.mascotas.PetService;

import guru.springframework.sfgdi.datasource.FalsaDataSource;
import guru.springframework.sfgdi.repo.SaludoEspRepo;
import guru.springframework.sfgdi.repo.SaludoEspRepoImp;
import guru.springframework.sfgdi.services.ConstructorSaludoService;
import guru.springframework.sfgdi.services.I18nSaludoService;
import guru.springframework.sfgdi.services.PrimaryGreetingService;
import guru.springframework.sfgdi.services.PropiedadSaludoService;
import guru.springframework.sfgdi.services.SaludoService;
import guru.springframework.sfgdi.services.SetterSaludoService;
import guru.springframework.sfgdi.services.I18nEnglishService;

//se utiliza cuando no somo dueños del codigo, y queremos traer ese codigo a
@Configuration // nuestra aplicacion//@PropertySource("classpath:datasource.properties")//acoplar otro property source
public class SaludoServiceConfig {

	@Bean
	FalsaDataSource falsaDataSource(@Value("${guru.username}") String username, @Value("${guru.password}") String password,
			@Value("${guru.jdbcurl}") String jdbcurl) {
		FalsaDataSource falsaDataSource = new FalsaDataSource();
		falsaDataSource.setUsername(username);
		falsaDataSource.setPassword(password);
		falsaDataSource.setJdbcurl(jdbcurl);
		return falsaDataSource;
	}

	@Bean
	MascotaServiceFactory mascotaServiceFactory() {
		return new MascotaServiceFactory();
	}

	@Bean
	@Profile({ "dog", "default" })
	PetService dogPetService(MascotaServiceFactory mascotaServiceFactory) {
		return mascotaServiceFactory.getPetService("dog");
	}

	@Bean
	@Profile({ "cat" })
	PetService catPetService(MascotaServiceFactory mascotaServiceFactory) {
		return mascotaServiceFactory.getPetService("cat");
	}

	@Bean
	SaludoService constructorSaludoService() {
		return new ConstructorSaludoService();
	}

	@Bean
	SaludoService propiedadSaludoService() {
		return new PropiedadSaludoService();
	}

	@Bean
	SaludoService setterSaludoService() {
		return new SetterSaludoService();
	}

	@Primary
	@Bean
	SaludoService primaryGreetingService() {
		return new PrimaryGreetingService();
	}

	@Bean
	SaludoEspRepo saludoEspRepo() {
		return new SaludoEspRepoImp();
	}

	@Profile({ "ES", "default" })
	@Bean
	SaludoService i18nService(SaludoEspRepo saludoInglesRepo) {
		return new I18nSaludoService(saludoInglesRepo);
	}

	@Profile({ "EN" })
	@Bean("i18nService")
	SaludoService i18nEnglishService() {
		return new I18nEnglishService();
	}
}
