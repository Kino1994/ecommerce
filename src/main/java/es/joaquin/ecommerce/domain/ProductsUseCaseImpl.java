package es.joaquin.ecommerce.domain;

public class ProductsUseCaseImpl implements ProductUseCase {
	
	private ProductRepository productRepository;	

	public ProductsUseCaseImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public ProductDto createProduct(ProductDto productDto) {
		Product product = new Product(productDto.getName(), productDto.getDescription(), productDto.getValue());
		return productRepository.save(product);
	}

}
