package es.joaquin.ecommerce.domain;

import java.util.Optional;

public interface ShoppingCartUseCase {
	
	ShoppingCartDto createShoppingCart(ShoppingCartDto shoppingCartDto);

	Optional<Boolean> closeShoppingCart(Long id);

	Optional<ShoppingCartDto> getShoppingCart(Long id);

	Boolean deleteShoppingCart(Long id);
	
	
}
