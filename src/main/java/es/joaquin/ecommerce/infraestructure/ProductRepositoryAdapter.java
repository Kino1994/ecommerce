package es.joaquin.ecommerce.infraestructure;

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
	
	private static ProductDto toProductDto(ProductEntity productEntity) {
		
		return new ProductDto(productEntity.getId(), productEntity.getName(), productEntity.getDescription(), productEntity.getValue());
	}

}
