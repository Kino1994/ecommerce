package es.joaquin.ecommerce.domain;

import es.joaquin.ecommerce.infraestructure.RandomValidateShoppingCartExternalService;

public class RandomValidateShoppingCartUseCaseImpl implements RandomValidateShoppingCartUseCase {
	
	RandomValidateShoppingCartExternalService randomValidateShoppingCartExternalService;
	
	public RandomValidateShoppingCartUseCaseImpl(RandomValidateShoppingCartExternalService randomValidateShoppingCartExternalService) {
		this.randomValidateShoppingCartExternalService = randomValidateShoppingCartExternalService;
	}
	
	@Override
	public Boolean validate() {
		return randomValidateShoppingCartExternalService.validate();
	}

}
