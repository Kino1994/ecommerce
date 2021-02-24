package es.joaquin.ecommerce.domain;

import java.util.Optional;

import es.joaquin.ecommerce.domain.dto.CartItemDto;

public interface CartItemRepository {

	Optional<CartItemDto> addCartItem(Long cartId, Long prodId, Integer prodQuantity);

	Boolean deleteItem(Long cartId, Long prodId);

}
