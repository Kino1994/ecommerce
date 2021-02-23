package es.joaquin.ecommerce.domain;

import java.util.Optional;

public interface ShoppingCartRepository {

	ShoppingCartDto createShoppingCart(ShoppingCart shoppingCart);

	Optional<Boolean> closeShoppingCart(Long id, Boolean Close);

	Optional<ShoppingCartDto> getShoppingCart(Long id);

	Boolean deleteShoppingCart(Long id);
	
}