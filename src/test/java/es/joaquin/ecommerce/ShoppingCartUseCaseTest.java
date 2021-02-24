package es.joaquin.ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import es.joaquin.ecommerce.domain.CartItemRepository;
import es.joaquin.ecommerce.domain.ShoppingCart;
import es.joaquin.ecommerce.domain.ShoppingCartRepository;
import es.joaquin.ecommerce.domain.ShoppingCartUseCaseImpl;
import es.joaquin.ecommerce.domain.dto.CartItemDto;
import es.joaquin.ecommerce.domain.dto.ProductDto;
import es.joaquin.ecommerce.domain.dto.ShoppingCartDto;

public class ShoppingCartUseCaseTest {

	@Mock
	private ShoppingCartRepository shoppingCartRepository;

	@Mock
	private CartItemRepository cartItemRepository;

	@InjectMocks
	private ShoppingCartUseCaseImpl shoppingCartUseCaseImpl;

	@BeforeEach
	public void before() {
		initMocks(this);
	}
	
	@Test
	public void testgivenCartwithDesriptionwhencreateShoppingCartThenOk() {
		String description = "Primer carrito";
		ShoppingCartDto shoppingCartDto = new ShoppingCartDto(description);
				
		when(shoppingCartRepository.createShoppingCart(any(ShoppingCart.class))).thenReturn(shoppingCartDto);
			
		assertEquals(shoppingCartDto,shoppingCartUseCaseImpl.createShoppingCart(shoppingCartDto));
		assertTrue(shoppingCartDto.getItems().isEmpty());
		assertFalse(shoppingCartDto.getClosed());
	}
	
	@Test
	public void testgivenCartIdProductIdAndQuantitywhenaddItemThenOk() {
		Long cartId = 1L;
		Long proudctId = 2L;
		Integer quantity = 10;
		String name = "platano";
		String description = "Platano de Canarias";
		Double value = 0.3;
		
		ProductDto productDto = new ProductDto(proudctId,name, description, value);		
		CartItemDto cartItemDto = new CartItemDto(cartId, productDto, quantity);
		Optional<CartItemDto> cartItemDtoOptional = Optional.of(cartItemDto);
		
		when(cartItemRepository.addCartItem(cartId, proudctId, quantity)).thenReturn(cartItemDtoOptional);
		
		CartItemDto result = shoppingCartUseCaseImpl.addCartItem(cartId, proudctId, quantity).get();
		
		assertEquals(result.getProductDto(), productDto);
		assertEquals(result, cartItemDto);		
	}
	
}
