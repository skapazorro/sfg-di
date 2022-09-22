package com.springframework.mascotas;

public class MascotaServiceFactory {

	public PetService getPetService(String TipoMascota) {
		switch(TipoMascota) {
		case "dog":
			return new DogPetService();
		case "cat":
			return new CatPetService();
			default : 
				return new DogPetService();
		}
	}
}
