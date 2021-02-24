package es.joaquin.ecommerce.infraestructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import es.joaquin.ecommerce.domain.ShoppingCart;
import es.joaquin.ecommerce.domain.ShoppingCartRepository;
import es.joaquin.ecommerce.domain.dto.CartItemDto;
import es.joaquin.ecommerce.domain.dto.ShoppingCartDto;
import es.joaquin.ecommerce.infraestructure.model.CartItemEntity;
import es.joaquin.ecommerce.infraestructure.model.ShoppingCartEntity;
import es.joaquin.ecommerce.infraestructure.repository.CartItemJpaRepository;
import es.joaquin.ecommerce.infraestructure.repository.ShoppingCartJpaRepository;

@Component
public class ShoppingCartRepositoryAdapter implements ShoppingCartRepository {
	
	ShoppingCartJpaRepository shoppingCartJpaRepository;
	
	CartItemJpaRepository cartItemJpaRepository;
	
	public ShoppingCartRepositoryAdapter(ShoppingCartJpaRepository shoppingCartJpaRepository, CartItemJpaRepository cartItemJpaRepository) {
		this.shoppingCartJpaRepository = shoppingCartJpaRepository;
		this.cartItemJpaRepository = cartItemJpaRepository;
	}

	@Override
	public ShoppingCartDto createShoppingCart(ShoppingCart shoppingCart) {
		ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity(shoppingCart.getDescription());
		return toShoppingCartDto(shoppingCartJpaRepository.save(shoppingCartEntity));
	}

	@Override
	public Optional<Boolean> closeShoppingCart(Long Id, Boolean close) {
		Optional<ShoppingCartEntity> value = shoppingCartJpaRepository.findById(Id);
		if (value.isPresent()) {
			ShoppingCartEntity shoppingCartEntity = value.get();
			if (!shoppingCartEntity.getClosed() && close && shoppingCartEntity.getItems()!=null
					&& !shoppingCartEntity.getItems().isEmpty()) { // Only existing and non empty Shopping Carts could be closed
				shoppingCartEntity.setClosed(close);
				shoppingCartJpaRepository.save(shoppingCartEntity);
			}
			return Optional.of(shoppingCartEntity.getClosed());
		}
		return Optional.empty();
	}

	@Override
	public Optional<ShoppingCartDto> getShoppingCart(Long id) {
		Optional<ShoppingCartEntity> value = shoppingCartJpaRepository.findById(id);
		if (value.isPresent()) {
			return Optional.of(toShoppingCartDto(value.get()));
		}
		return Optional.empty();
	}

	@Override
	public Boolean deleteShoppingCart(Long id) {
		Optional<ShoppingCartEntity> value = shoppingCartJpaRepository.findById(id);
		if (value.isPresent()) {
			if (!value.get().getClosed()) {
				shoppingCartJpaRepository.delete(value.get());
				return true;
			}
			else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Closed Shopping Carts can not be modified or deleted");
		}
		return false;
	}
	
	public static CartItemDto toCartItemDto(CartItemEntity cartItemEntity) {
		return new CartItemDto(cartItemEntity.getId(), ProductRepositoryAdapter.toProductDto(cartItemEntity.getProduct()), cartItemEntity.getQuantity());
	}

	private static ShoppingCartDto toShoppingCartDto(ShoppingCartEntity shoppingCartEntity) {
		List<CartItemDto> items = new ArrayList<>();
		if (shoppingCartEntity.getItems()!=null && !shoppingCartEntity.getItems().isEmpty()) {
			items = shoppingCartEntity.getItems().stream().map(i -> toCartItemDto(i)).collect(Collectors.toList());
		}
		return new ShoppingCartDto(shoppingCartEntity.getId(), shoppingCartEntity.getDescription(), shoppingCartEntity.getClosed(), items);
	}

}
