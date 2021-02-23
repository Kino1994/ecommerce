package es.joaquin.ecommerce.infraestructure.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import es.joaquin.ecommerce.controller.request.ProductRequest;
import es.joaquin.ecommerce.domain.ProductDto;
import es.joaquin.ecommerce.domain.ProductUseCase;

@Service
public class ProductService {
	
	private ProductUseCase productUseCase;
	
	public ProductService(ProductUseCase productUseCase) {
		this.productUseCase = productUseCase;
	}

	@GetMapping("/api/products")
	public ProductDto createProduct(ProductRequest productRequest) {
		ProductDto productDto = new ProductDto(productRequest.getName(), productRequest.getDescription(), productRequest.getValue());
		return productUseCase.createProduct(productDto);		
	}

}