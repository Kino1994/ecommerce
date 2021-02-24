package es.joaquin.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDto {
	
	private Long id;
	
	private String description;
	
	private Boolean closed;
	
	private List<CartItemDto> items;
	
	public ShoppingCartDto(String description) {
		this.description = description;
		this.closed = false;
		this.items = new ArrayList<CartItemDto>();
	}

	public ShoppingCartDto(String description, Boolean closed, List<CartItemDto> items) {
		this(description);
		this.closed = closed;
		this.items = items;
	}
	
	public ShoppingCartDto(Long id, String description, Boolean closed, List<CartItemDto> items) {
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

	public List<CartItemDto> getItems() {
		return items;
	}

	public void setItems(List<CartItemDto> items) {
		this.items = items;
	}

	public Boolean getClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

}
