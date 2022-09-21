package guru.springframework.sfgdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import guru.springframework.sfgdi.controllers.ConstructorInyectionController;
import guru.springframework.sfgdi.controllers.I18nControler;
import guru.springframework.sfgdi.controllers.MiControlador;
import guru.springframework.sfgdi.controllers.PropiedadInyectadaControlador;
import guru.springframework.sfgdi.controllers.SetterInyectionController;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

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
	}

}
