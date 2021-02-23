package es.joaquin.ecommerce.domain;

public class CartItem {
	
	private Long id;
	
	private ShoppingCart shoppingCart;
	
	private Product product;
	
	private Integer quantity;

	public CartItem(ShoppingCart shoppingCart, Product product, Integer quantity) {
		this.shoppingCart = shoppingCart;
		this.product = product;
		this.quantity = quantity;
	}
	
	public CartItem(Long id, ShoppingCart shoppingCart, Product product, Integer quantity) {
		this(shoppingCart,product,quantity);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
