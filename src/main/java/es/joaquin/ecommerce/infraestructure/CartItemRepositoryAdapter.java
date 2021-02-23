package es.joaquin.ecommerce.infraestructure;

import java.util.Optional;

import org.springframework.stereotype.Component;

import es.joaquin.ecommerce.domain.CartItemDto;
import es.joaquin.ecommerce.domain.CartItemRepository;
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
			Optional<ProductEntity> productEntityOptional = productJpaRepository.findById(prodId);
			if (productEntityOptional.isPresent()) {
				CartItemEntity cartItemEntity = new CartItemEntity(shoppingCartEntityOptional.get(), productEntityOptional.get(),prodQuantity);
				cartItemJpaRepository.save(cartItemEntity);
				return Optional.of(new CartItemDto(cartItemEntity.getId(), ProductRepositoryAdapter.toProductDto(cartItemEntity.getProduct()), cartItemEntity.getQuantity()));
			}
		}
		return Optional.empty();
			
		
	}

}
