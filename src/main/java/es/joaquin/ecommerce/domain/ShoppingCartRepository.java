package es.joaquin.ecommerce.domain;

import java.util.Optional;

import es.joaquin.ecommerce.dto.ShoppingCartDto;

public interface ShoppingCartRepository {

	ShoppingCartDto createShoppingCart(ShoppingCart shoppingCart);

	Optional<Boolean> closeShoppingCart(Long id, Boolean Close);

	Optional<ShoppingCartDto> getShoppingCart(Long id);

	Boolean deleteShoppingCart(Long id);
	
}
