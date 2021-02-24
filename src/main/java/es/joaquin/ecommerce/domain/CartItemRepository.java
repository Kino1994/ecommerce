package es.joaquin.ecommerce.domain;

import java.util.Optional;

public interface CartItemRepository {

	Optional<CartItemDto> addCartItem(Long cartId, Long prodId, Integer prodQuantity);

	Boolean deleteItem(Long cartId, Long prodId);

}
