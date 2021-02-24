package es.joaquin.ecommerce.domain;

import java.util.Optional;

import es.joaquin.ecommerce.dto.CartItemDto;
import es.joaquin.ecommerce.dto.ShoppingCartDto;

public interface ShoppingCartUseCase {
	
	ShoppingCartDto createShoppingCart(ShoppingCartDto shoppingCartDto);

	Optional<Boolean> closeShoppingCart(Long id);

	Optional<ShoppingCartDto> getShoppingCart(Long id);

	Boolean deleteShoppingCart(Long id);

	Optional<CartItemDto> addCartItem(Long cartId, Long prodId, Integer prodQuantity);

	Boolean deleteItem(Long cartId, Long prodId);	
	
}
