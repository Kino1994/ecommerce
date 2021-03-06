package es.joaquin.ecommerce.domain;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
	private Long id;
	
	private String description;
	
	private Boolean closed;
	
	private List<CartItem> items;
	
	public ShoppingCart(String description) {
		this.description = description;
		this.closed = false;
		this.items = new ArrayList<CartItem>();
	}
	
	public ShoppingCart(String description, Boolean closed, List<CartItem> items) {
		this.description = description;
		this.closed = closed;
		this.items = items;
	}
	
	public ShoppingCart(Long id, String description, Boolean closed, List<CartItem> items) {
		this(description,closed, items);
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

	public Boolean getClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}


}