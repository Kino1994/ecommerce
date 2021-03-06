package es.joaquin.ecommerce.domain;

import java.util.List;
import java.util.Optional;

import es.joaquin.ecommerce.domain.dto.ProductDto;

public interface ProductRepository {
	
	ProductDto createProduct(Product product);

	List<ProductDto> getProducts();

	Optional<ProductDto> getProduct(Long id);

	Boolean deleteProduct(Long id);

}
