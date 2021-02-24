package es.joaquin.ecommerce.infraestructure;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import es.joaquin.ecommerce.domain.CartItemRepository;
import es.joaquin.ecommerce.dto.CartItemDto;
import es.joaquin.ecommerce.infraestructure.model.CartItemEntity;
import es.joaquin.ecommerce.infraestructure.model.ProductEntity;
import es.joaquin.ecommerce.infraestructure.model.ShoppingCartEntity;
import es.joaquin.ecommerce.infraestructure.repository.CartItemJpaRepository;
import es.joaquin.ecommerce.infraestructure.repository.ProductJpaRepository;
import es.joaquin.ecommerce.infraestructure.repository.ShoppingCartJpaRepository;

@Component
public class CartItemRepositoryAdapter implements CartItemRepository{
	
	ShoppingCartJpaRepository shoppingCartJpaRepository;
	
	CartItemJpaRepository cartItemJpaRepository;
	
	ProductJpaRepository productJpaRepository;

	
	public CartItemRepositoryAdapter(ShoppingCartJpaRepository shoppingCartJpaRepository, CartItemJpaRepository cartItemJpaRepository, 	ProductJpaRepository productJpaRepository) {
		this.shoppingCartJpaRepository = shoppingCartJpaRepository;
		this.cartItemJpaRepository = cartItemJpaRepository;		
		this.productJpaRepository = productJpaRepository;
	}

	@Override
	public Optional<CartItemDto> addCartItem(Long cartId, Long prodId, Integer prodQuantity) {
		Optional<ShoppingCartEntity> shoppingCartEntityOptional = shoppingCartJpaRepository.findById(cartId);
		if (shoppingCartEntityOptional.isPresent()) {
			if (!shoppingCartEntityOptional.get().getClosed()) {	
				Optional<ProductEntity> productEntityOptional = productJpaRepository.findById(prodId);
				if (productEntityOptional.isPresent()) {
					CartItemEntity cartItemEntity = new CartItemEntity(shoppingCartEntityOptional.get(), productEntityOptional.get(),prodQuantity);
					cartItemJpaRepository.save(cartItemEntity);
					return Optional.of(new CartItemDto(cartItemEntity.getId(), ProductRepositoryAdapter.toProductDto(cartItemEntity.getProduct()), cartItemEntity.getQuantity()));
				}
			}
			else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Closed Shopping Carts can not be modified or deleted");
		}
		return Optional.empty();
	}

	@Override
	public Boolean deleteItem(Long cartId, Long prodId) {
		Optional<ShoppingCartEntity> shoppingCartEntityOptional = shoppingCartJpaRepository.findById(cartId);
		if (shoppingCartEntityOptional.isPresent()) {
			if (!shoppingCartEntityOptional.get().getClosed()) {
				Optional<CartItemEntity> cartItemEntityOptional = cartItemJpaRepository.findById(prodId);
				if (cartItemEntityOptional.isPresent()) {
					cartItemJpaRepository.deleteById(prodId);
					return true;
				}
			}
			else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Closed Shopping Carts can not be modified or deleted");
		}
		return false;
	}

}
