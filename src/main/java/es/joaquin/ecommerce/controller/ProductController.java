package es.joaquin.ecommerce.controller;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import es.joaquin.ecommerce.controller.request.ProductRequest;
import es.joaquin.ecommerce.controller.response.ProductResponse;
import es.joaquin.ecommerce.domain.ProductDto;
import es.joaquin.ecommerce.infraestructure.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	/*@GetMapping("/api/products")
	public List<ProductEntity> getProducts() {
		return productService.getProducts();		
	}*/
	
	@PostMapping("/api/products")
	public ResponseEntity<ProductResponse> createProduct(ProductRequest productRequest) {
		
		ProductDto productDto = productService.createProduct(productRequest);
		
		ProductResponse productResponse = new ProductResponse(productDto.getId(), productDto.getName(), productDto.getDescription(), productDto.getValue());
		
		 URI location = fromCurrentRequest().path("/{id}")
			.buildAndExpand(productDto.getId()).toUri();
			
        return ResponseEntity.created(location).body(productResponse);
		
		
	}
	
	/*@GetMapping("/api/products/{id}")
	public ProductEntity getProduct(Long id) {
		return productService.getProduct(id).get();		
	}
	
	@DeleteMapping("/api/products/{id}")
	public void deleteProduct(Long id) {
		productService.deleteProduct(id);		
	}*/

}
