package es.joaquin.ecommerce.controller;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentContextPath;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.joaquin.ecommerce.controller.request.ShoppingCartRequest;
import es.joaquin.ecommerce.controller.response.CartItemResponse;
import es.joaquin.ecommerce.controller.response.ProductResponse;
import es.joaquin.ecommerce.controller.response.ShoppingCartResponse;
import es.joaquin.ecommerce.domain.CartItemDto;
import es.joaquin.ecommerce.domain.ProductDto;
import es.joaquin.ecommerce.domain.ShoppingCartDto;
import es.joaquin.ecommerce.infraestructure.service.ShoppingCartService;

@RestController
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@PostMapping("/api/shoppingcarts")
	public ResponseEntity<ShoppingCartResponse> createShoppingCart(@RequestBody ShoppingCartRequest shoppingCartRequest) {
				
		ShoppingCartDto shoppingCartDto = shoppingCartService.createShoppingCart(shoppingCartRequest);
		
		List<CartItemResponse> items = new ArrayList<>();
		
		if (shoppingCartDto.getItems()!= null && shoppingCartDto.getItems().isEmpty()){
			items  = shoppingCartDto.getItems().stream().map(i -> toCartItemResponse(i)).collect(Collectors.toList());
		}
		
		ShoppingCartResponse shoppingCartResponse = new ShoppingCartResponse(shoppingCartDto.getId(), shoppingCartDto.getDescription(), shoppingCartDto.getClosed(), items);
		
		URI location = fromCurrentRequest().path("/{id}")
				.buildAndExpand(shoppingCartResponse.getId()).toUri();
			
        return ResponseEntity.created(location).body(shoppingCartResponse);	
	}
	
	@PatchMapping("/api/shoppingcarts/{id}")
	public ResponseEntity<Void> closeShoppingCart(@PathVariable Long id) {
				
		Optional<Boolean> value = shoppingCartService.closeShoppingCart(id);
		
		if (value.isPresent()) {
			if (value.get()) {
				return ResponseEntity.ok().build();
			}
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/api/shoppingcarts/{id}")
	public ResponseEntity<ShoppingCartResponse> getShoppingCart(@PathVariable Long id) {
				
		Optional<ShoppingCartDto> value = shoppingCartService.getShoppingCart(id);
		
		if (value.isPresent()) {
			List<CartItemResponse> items = new ArrayList<>();			
			ShoppingCartDto shoppingCartDto = value.get();
			
			if (shoppingCartDto.getItems()!= null && !shoppingCartDto.getItems().isEmpty()){
				items  = shoppingCartDto.getItems().stream().map(i -> toCartItemResponse(i)).collect(Collectors.toList());
			}			
			ShoppingCartResponse shoppingCartResponse = new ShoppingCartResponse(shoppingCartDto.getId(), shoppingCartDto.getDescription(), shoppingCartDto.getClosed(), items);
	        return ResponseEntity.ok(shoppingCartResponse);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/api/shoppingcarts/{id}")
	public ResponseEntity<ShoppingCartResponse> deleteShoppingCart(@PathVariable Long id) {
				
		if (shoppingCartService.deleteShoppingCart(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/api/shoppingcarts/{cart_id}/product/{prod_id}/quantity/{prod_quantity}")
	public ResponseEntity<CartItemResponse> addCartItem(@PathVariable(name = "cart_id") Long cartId, @PathVariable(name = "prod_id") Long prodId, @PathVariable(name = "prod_quantity") Integer prodQuantity) {
				
		Optional<CartItemDto> value = shoppingCartService.addCartItem(cartId, prodId, prodQuantity);
		
		if (value.isPresent()) {
			CartItemDto cartItemDto = value.get();
			CartItemResponse cartItemResponse = new CartItemResponse(cartItemDto.getId(), toProductResponse(cartItemDto.getProductDto()), cartItemDto.getQuantity());		
			
			URI location = fromCurrentContextPath().pathSegment("api").pathSegment("shoppingcarts")
				.pathSegment("{cart_id}").pathSegment("item").pathSegment("{item_id}").build(cartId,cartItemResponse.getId());
			
			return ResponseEntity.created(location).body(cartItemResponse);
		}
		return ResponseEntity.notFound().build();
		
	}
	
	
	private static CartItemResponse toCartItemResponse(CartItemDto cartItemDto) {
		return new CartItemResponse(cartItemDto.getId(), toProductResponse(cartItemDto.getProductDto()), cartItemDto.getQuantity());
	}
	
	private static ProductResponse toProductResponse(ProductDto productDto) {
		return new ProductResponse(productDto.getId(), productDto.getName(), productDto.getDescription(), productDto.getValue());
	}
	

}
