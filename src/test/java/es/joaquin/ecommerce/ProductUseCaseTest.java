package es.joaquin.ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import es.joaquin.ecommerce.domain.Product;
import es.joaquin.ecommerce.domain.ProductRepository;
import es.joaquin.ecommerce.domain.ProductsUseCaseImpl;
import es.joaquin.ecommerce.domain.dto.ProductDto;

public class ProductUseCaseTest {
	
	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductsUseCaseImpl productsUseCaseImpl;

	@BeforeEach
	public void before() {
		initMocks(this);
	}
	
	@Test
	public void testgivenProductwhencreateProductThenOk() {
		String name = "platano";
		String description = "Platano de Canarias";
		Double value = 0.3;
		ProductDto productDto = new ProductDto(name,description,value);
		
		when(productRepository.createProduct(any(Product.class))).thenReturn(productDto);
		
		assertEquals(productDto, productsUseCaseImpl.createProduct(productDto));
	}
	
	@Test
	public void testgivenProductwhenDeletecreatedProductThenOk() {
		Long id = 1L;
		
		when(productRepository.deleteProduct(id)).thenReturn(true);
		
		assertTrue(productsUseCaseImpl.deleteProduct(id));
	}
	
	@Test
	public void testgivenProductwhenDeleteNoncreatedProductThenOk() {
		Long id = -1L;
		
		when(productRepository.deleteProduct(id)).thenReturn(false);
		
		assertFalse(productsUseCaseImpl.deleteProduct(id));
	}


}
