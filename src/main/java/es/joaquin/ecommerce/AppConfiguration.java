package es.joaquin.ecommerce;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.joaquin.ecommerce.domain.ProductRepository;
import es.joaquin.ecommerce.domain.ProductUseCase;
import es.joaquin.ecommerce.domain.ProductsUseCaseImpl;

@Configuration
public class AppConfiguration {

	@Bean
	public ProductUseCase productUseCase(ProductRepository productRepository) {
		return new ProductsUseCaseImpl(productRepository);
	}
	
}
