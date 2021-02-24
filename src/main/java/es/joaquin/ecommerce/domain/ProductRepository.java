package es.joaquin.ecommerce.domain;

import java.util.List;
import java.util.Optional;

import es.joaquin.ecommerce.dto.ProductDto;

public interface ProductRepository {
	
	ProductDto save(Product product);

	List<ProductDto> getProducts();

	Optional<ProductDto> getProduct(Long id);

	Boolean deleteProduct(Long id);

}
