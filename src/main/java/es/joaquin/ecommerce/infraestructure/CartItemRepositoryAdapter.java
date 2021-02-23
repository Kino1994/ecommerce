package es.joaquin.ecommerce.infraestructure;

import org.springframework.stereotype.Component;

import es.joaquin.ecommerce.domain.CartItemRepository;
import es.joaquin.ecommerce.infraestructure.repository.CartItemJpaRepository;

@Component
public class CartItemRepositoryAdapter implements CartItemRepository{
	
	CartItemJpaRepository cartItemJpaRepository;
	
	public CartItemRepositoryAdapter(CartItemJpaRepository cartItemJpaRepository) {
		this.cartItemJpaRepository = cartItemJpaRepository;		
	}

}
