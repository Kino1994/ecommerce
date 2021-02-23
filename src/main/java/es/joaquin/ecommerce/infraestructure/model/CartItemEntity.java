package es.joaquin.ecommerce.infraestructure.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CartItemEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @ManyToOne
	private ShoppingCartEntity shoppingCart;
	
    @OneToOne
	private ProductEntity product;
	
	private Integer quantity;

	public CartItemEntity() {

	}

	public CartItemEntity(ShoppingCartEntity shoppingCart, ProductEntity product, Integer quantity) {
		this.shoppingCart = shoppingCart;
		this.product = product;
		this.quantity = quantity;
	}
	
	public CartItemEntity(Long id, ShoppingCartEntity shoppingCart, ProductEntity product, Integer quantity) {
		this(shoppingCart,product,quantity);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ShoppingCartEntity getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCartEntity shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
