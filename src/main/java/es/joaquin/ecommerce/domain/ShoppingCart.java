package es.joaquin.ecommerce.domain;

import java.util.List;

public class ShoppingCart {
	
	private Long id;
	
	private String description;
	
	private List<CartItem> items;

	public ShoppingCart(String description, List<CartItem> items) {
		this.description = description;
		this.items = items;
	}

	public ShoppingCart(Long id, String description, List<CartItem> items) {
		this(description,items);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

}
