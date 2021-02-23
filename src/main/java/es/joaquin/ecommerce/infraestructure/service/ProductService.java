package es.joaquin.ecommerce.infraestructure.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.joaquin.ecommerce.controller.request.ProductRequest;
import es.joaquin.ecommerce.domain.ProductDto;
import es.joaquin.ecommerce.domain.ProductUseCase;

@Service
public class ProductService {
	
	private ProductUseCase productUseCase;
	
	public ProductService(ProductUseCase productUseCase) {
		this.productUseCase = productUseCase;
	}

	public ProductDto createProduct(ProductRequest productRequest) {
		ProductDto productDto = new ProductDto(productRequest.getName(), productRequest.getDescription(), productRequest.getValue());
		return productUseCase.createProduct(productDto);		
	}
	
	public List<ProductDto> getProducts() {
		return productUseCase.getProducts();		
	}
	
	public Optional<ProductDto> getProduct(Long id) {
		return productUseCase.getProduct(id);		
	}

	public Boolean deleteProduct(Long id) {
		return productUseCase.deleteProduct(id);
	}
	
	

}