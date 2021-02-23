package es.joaquin.ecommerce.controller.request;

import java.util.List;

import es.joaquin.ecommerce.domain.CartItem;

public class ShoppingCartRequest {
	
	private String description;
	
	public ShoppingCartRequest(String description, Boolean closed, List<CartItem> items) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}