package es.joaquin.ecommerce.infraestructure.service;

import org.springframework.stereotype.Service;

import es.joaquin.ecommerce.domain.RandomValidateShoppingCartUseCase;

@Service
public class RandomValidateShoppingCartService {
	
	private RandomValidateShoppingCartUseCase randomValidateShoppingCartUseCase;
	
	public RandomValidateShoppingCartService(RandomValidateShoppingCartUseCase randomValidateShoppingCartUseCase){
		this.randomValidateShoppingCartUseCase = randomValidateShoppingCartUseCase;
	}
	
	public Boolean validate() {
		return randomValidateShoppingCartUseCase.validate();
	}

}
