package es.joaquin.ecommerce.domain;

import java.util.Optional;

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
		// TODO Auto-generated method stub
		return null;
	}
	
	/*private Product toProduct(ProductDto productDto){
		return new Product(productDto.getId(), productDto.getName(), productDto.getDescription(), productDto.getValue());		
	}
	
	private CartItem toCartItem (CartItemDto cartItemDto){
		return new CartItem(cartItemDto.getId(), toProduct(cartItemDto.getProductDto()), cartItemDto.getQuantity());
		
	}*/


}