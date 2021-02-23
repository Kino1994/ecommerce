package es.joaquin.ecommerce.infraestructure;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import es.joaquin.ecommerce.domain.Product;
import es.joaquin.ecommerce.domain.ProductDto;
import es.joaquin.ecommerce.domain.ProductRepository;
import es.joaquin.ecommerce.infraestructure.model.ProductEntity;
import es.joaquin.ecommerce.infraestructure.repository.ProductJpaRepository;

@Component
public class ProductRepositoryAdapter implements ProductRepository {
	
	ProductJpaRepository productJpaRepository;
	
	public ProductRepositoryAdapter(ProductJpaRepository productJpaRepository) {
		this.productJpaRepository = productJpaRepository;
	}

	@Override
	public ProductDto save(Product product) {
		ProductEntity productEntity = new ProductEntity(product.getName(), product.getDescription(), product.getValue());

		return toProductDto(productJpaRepository.save(productEntity));
	}
	
	public List<ProductDto> getProducts() {
		return productJpaRepository.findAll()
				.stream().map(ProductRepositoryAdapter::toProductDto).collect(Collectors.toList());		
	}	
	
	@Override
	public Optional<ProductDto> getProduct(Long id) {
		Optional<ProductEntity> value = productJpaRepository.findById(id);
		if (value.isPresent()) {
			return Optional.of(toProductDto(value.get()));
		}
		return Optional.empty();
	}
	
	@Override
	public Boolean deleteProduct(Long id) {
		Optional<ProductEntity> value = productJpaRepository.findById(id);
		if (value.isPresent()) {
			productJpaRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	private static ProductDto toProductDto(ProductEntity productEntity) {		
		return new ProductDto(productEntity.getId(), productEntity.getName(), productEntity.getDescription(), productEntity.getValue());
	}

}
