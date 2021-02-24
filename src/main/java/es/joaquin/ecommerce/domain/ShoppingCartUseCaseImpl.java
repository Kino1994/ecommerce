package es.joaquin.ecommerce.domain;

import java.util.Optional;

import es.joaquin.ecommerce.dto.CartItemDto;
import es.joaquin.ecommerce.dto.ShoppingCartDto;
import es.joaquin.ecommerce.infraestructure.service.RandomValidateShoppingCartService;

public class ShoppingCartUseCaseImpl implements ShoppingCartUseCase {
	
	private ShoppingCartRepository shoppingCartRepository;	
	
	private CartItemRepository cartItemRepository;
		
	private RandomValidateShoppingCartService randomValidateShoppingCartService;

	public ShoppingCartUseCaseImpl(ShoppingCartRepository shoppingCartRepository, CartItemRepository cartItemRepository, RandomValidateShoppingCartService randomValidateShoppingCartService) {
		this.shoppingCartRepository = shoppingCartRepository;
		this.cartItemRepository = cartItemRepository;
		this.randomValidateShoppingCartService = randomValidateShoppingCartService;
	}

	@Override
	public ShoppingCartDto createShoppingCart(ShoppingCartDto shoppingCartDto) {
		ShoppingCart shoppingCart = new ShoppingCart(shoppingCartDto.getDescription());
		return shoppingCartRepository.createShoppingCart(shoppingCart);
	}

	@Override
	public Optional<Boolean> closeShoppingCart(Long id) {
		Boolean close = randomValidateShoppingCartService.validate();
		return shoppingCartRepository.closeShoppingCart(id, close);
	}

	@Override
	public Optional<ShoppingCartDto> getShoppingCart(Long id) {
		return shoppingCartRepository.getShoppingCart(id);
	}

	@Override
	public Boolean deleteShoppingCart(Long id) {
		return shoppingCartRepository.deleteShoppingCart(id);
	}

	@Override
	public Optional<CartItemDto> addCartItem(Long cartId, Long prodId, Integer prodQuantity) {
		return cartItemRepository.addCartItem(cartId, prodId, prodQuantity);
	}

	@Override
	public Boolean deleteItem(Long cartId, Long prodId) {
		return cartItemRepository.deleteItem(cartId, prodId);

	}
	
}