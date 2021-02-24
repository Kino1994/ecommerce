package es.joaquin.ecommerce.domain;

import java.util.List;
import java.util.Optional;

import es.joaquin.ecommerce.domain.dto.ProductDto;

public class ProductsUseCaseImpl implements ProductUseCase {
	
	private ProductRepository productRepository;	

	public ProductsUseCaseImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public ProductDto createProduct(ProductDto productDto) {
		Product product = new Product(productDto.getName(), productDto.getDescription(), productDto.getValue());
		return productRepository.createProduct(product);
	}
	
	public List<ProductDto> getProducts() {
		return productRepository.getProducts();		
	}

	@Override
	public Optional<ProductDto> getProduct(Long id) {
		return productRepository.getProduct(id);		
	}

	@Override
	public Boolean deleteProduct(Long id) {
		return productRepository.deleteProduct(id);		
	}

}
