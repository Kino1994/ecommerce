package es.joaquin.ecommerce.controller;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.joaquin.ecommerce.controller.request.ProductRequest;
import es.joaquin.ecommerce.controller.response.ProductResponse;
import es.joaquin.ecommerce.domain.ProductDto;
import es.joaquin.ecommerce.infraestructure.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/api/products")
	public ResponseEntity<List<ProductResponse>> getProducts() {
		List<ProductResponse> productResponse = productService.getProducts().stream().map(p -> new ProductResponse(p.getId(), p.getName(), p.getDescription(), p.getValue()))
				.collect(Collectors.toList());	
		
        return ResponseEntity.ok(productResponse);
	}
	
	@PostMapping("/api/products")
	public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
		
		ProductDto productDto = productService.createProduct(productRequest);
		
		ProductResponse productResponse = new ProductResponse(productDto.getId(), productDto.getName(), productDto.getDescription(), productDto.getValue());
		
		 URI location = fromCurrentRequest().path("/{id}")
			.buildAndExpand(productDto.getId()).toUri();
			
        return ResponseEntity.created(location).body(productResponse);		
	}
	
	@GetMapping("/api/products/{id}")
	public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id) {
		Optional<ProductDto> value = productService.getProduct(id);
		if (value.isPresent()) {
			ProductDto productDto = value.get();
			ProductResponse productResponse = new ProductResponse(productDto.getId(), productDto.getName(), productDto.getDescription(), productDto.getValue());
	        return ResponseEntity.ok(productResponse);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/api/products/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		if (productService.deleteProduct(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
