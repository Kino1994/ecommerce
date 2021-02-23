package es.joaquin.ecommerce;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.joaquin.ecommerce.domain.CartItemRepository;
import es.joaquin.ecommerce.domain.ProductRepository;
import es.joaquin.ecommerce.domain.ProductUseCase;
import es.joaquin.ecommerce.domain.ProductsUseCaseImpl;
import es.joaquin.ecommerce.domain.RandomValidateShoppingCartUseCaseImpl;
import es.joaquin.ecommerce.domain.RandomValidateShoppingCartUseCase;
import es.joaquin.ecommerce.domain.ShoppingCartRepository;
import es.joaquin.ecommerce.domain.ShoppingCartUseCase;
import es.joaquin.ecommerce.domain.ShoppingCartUseCaseImpl;
import es.joaquin.ecommerce.infraestructure.RandomValidateShoppingCartExternalService;
import es.joaquin.ecommerce.infraestructure.service.RandomValidateShoppingCartService;

@Configuration
public class AppConfiguration {

	@Bean
	public ProductUseCase productUseCase(ProductRepository productRepository) {
		return new ProductsUseCaseImpl(productRepository);
	}
	
	@Bean
	public RandomValidateShoppingCartUseCase randomValidateShoppingCartUseCase(RandomValidateShoppingCartExternalService randomValidateShoppingCartExternalService) {
		return new RandomValidateShoppingCartUseCaseImpl(randomValidateShoppingCartExternalService);
	}
	
	@Bean
	public ShoppingCartUseCase shoppingCartUseCase(ShoppingCartRepository shoppingCartRepository, CartItemRepository cartItemRepository, RandomValidateShoppingCartService randomValidateShoppingCartService) {
		return new ShoppingCartUseCaseImpl(shoppingCartRepository, cartItemRepository,randomValidateShoppingCartService);
	}
	
}
