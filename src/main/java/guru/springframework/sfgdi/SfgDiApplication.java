package guru.springframework.sfgdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import guru.springframework.sfgdi.controllers.ConstructorInyectionController;
import guru.springframework.sfgdi.controllers.I18nControler;
import guru.springframework.sfgdi.controllers.MiControlador;
import guru.springframework.sfgdi.controllers.PetController;
import guru.springframework.sfgdi.controllers.PropiedadInyectadaControlador;
import guru.springframework.sfgdi.controllers.SetterInyectionController;
import guru.springframework.sfgdi.datasource.FalsaDataSource;
import guru.springframework.sfgdi.services.PrototypeBean;
import guru.springframework.sfgdi.services.SingletonBean;

@ComponentScan(basePackages = { "guru.springframework.sfgdi", "com.springframework.mascotas" })
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("-- la mejor mascota es: ");
		System.out.println(petController.whichPetIsTheBest());

		I18nControler i18nControler = (I18nControler) ctx.getBean("i18nControler");
		System.out.println(i18nControler.diHola());

		MiControlador myController = (MiControlador) ctx.getBean("miControlador");
		System.out.println("------------ Primario");
		System.out.println(myController.diHola());

		System.out.println("------------ Propiedad");
		PropiedadInyectadaControlador propiedadInjectada = (PropiedadInyectadaControlador) ctx
				.getBean("propiedadInyectadaControlador");
		System.out.println(propiedadInjectada.getSaludo());

		System.out.println("------------ Setter");
		SetterInyectionController setterContr = (SetterInyectionController) ctx.getBean("setterInyectionController");
		System.out.println(setterContr.getSaludo());

		System.out.println("------------ Constructor");
		ConstructorInyectionController ConstructorContr = (ConstructorInyectionController) ctx
				.getBean("constructorInyectionController");
		System.out.println(ConstructorContr.getSaludo());

		System.out.println("--- Bean Scopes----");
		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());

		PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getMyScope());

		FalsaDataSource falsaDataSource = ctx.getBean(FalsaDataSource.class);
		System.out.println(falsaDataSource.getUsername());
		System.out.println(falsaDataSource.getPassword());
		System.out.println(falsaDataSource.getJdbcurl());
	}

}
