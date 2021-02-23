package es.joaquin.ecommerce.controller.response;

import java.util.List;

public class ShoppingCartResponse {
	
	private Long id;
	
	private String description;
	
	private Boolean closed;
	
	private List<CartItemResponse> items;

	public ShoppingCartResponse(String description, Boolean closed, List<CartItemResponse> items) {
		this.description = description;
		this.closed = closed;
		this.items = items;
	}
	
	public ShoppingCartResponse(Long id, String description, Boolean closed, List<CartItemResponse> items) {
		this(description,closed,items);
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

	public List<CartItemResponse> getItems() {
		return items;
	}

	public void setItems(List<CartItemResponse> items) {
		this.items = items;
	}

	public Boolean getClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

}
