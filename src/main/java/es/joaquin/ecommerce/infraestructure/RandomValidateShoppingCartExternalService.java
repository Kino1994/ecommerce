package es.joaquin.ecommerce.infraestructure;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomValidateShoppingCartExternalService {
	
	public RandomValidateShoppingCartExternalService() {
		
	}
	
	public Boolean validate() {
		return new Random().nextBoolean();	// Simulates external call
	}

}
