package es.joaquin.ecommerce.domain;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
	
	ProductDto save(Product product);

	List<ProductDto> getProducts();

	Optional<ProductDto> getProduct(Long id);

	Boolean deleteProduct(Long id);

}
