package es.joaquin.ecommerce.infraestructure.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import es.joaquin.ecommerce.controller.request.ShoppingCartRequest;
import es.joaquin.ecommerce.domain.CartItemDto;
import es.joaquin.ecommerce.domain.ShoppingCartDto;
import es.joaquin.ecommerce.domain.ShoppingCartUseCase;

@Service
public class ShoppingCartService {
	
	private ShoppingCartUseCase shoppingCartUseCase;
	
	public ShoppingCartService(ShoppingCartUseCase shoppingCartUseCase) {
		this.shoppingCartUseCase = shoppingCartUseCase;
	}
	
	public ShoppingCartDto createShoppingCart(ShoppingCartRequest shoppingCartRequest) {		
		ShoppingCartDto shoppingCartDto = new ShoppingCartDto(shoppingCartRequest.getDescription());
		return shoppingCartUseCase.createShoppingCart(shoppingCartDto);
	}
	
	public Optional<Boolean> closeShoppingCart(Long id) {		
		return shoppingCartUseCase.closeShoppingCart(id);
	}
	
	public Optional<ShoppingCartDto> getShoppingCart(Long id) {
		return shoppingCartUseCase.getShoppingCart(id);
	}
	
	public Boolean deleteShoppingCart(Long id) {
		return shoppingCartUseCase.deleteShoppingCart(id);
	}
	
	public Optional<CartItemDto> addCartItem(Long cartId, Long prodId, Integer prodQuantity) {
		return shoppingCartUseCase.addCartItem(cartId, prodId, prodQuantity);		
	}

}
