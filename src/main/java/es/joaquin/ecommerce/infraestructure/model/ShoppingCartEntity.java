package es.joaquin.ecommerce.infraestructure.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ShoppingCartEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String description;
	
	private Boolean closed;
	
	@OneToMany(mappedBy="shoppingCart")
	private List<CartItemEntity> items;
	
	public ShoppingCartEntity() {

	}

	public ShoppingCartEntity(String description) {
		this.description = description;
		this.closed = false;
		this.items = new ArrayList<CartItemEntity>();
	}
	
	public ShoppingCartEntity(String description, Boolean closed) {
		this.description = description;
		this.closed = closed;
	}

	public ShoppingCartEntity(String description, Boolean closed, List<CartItemEntity> items) {
		this(description,closed);
		this.items = items;
	}
	
	public ShoppingCartEntity(Long id, String description, Boolean closed, List<CartItemEntity> items) {
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

	public List<CartItemEntity> getItems() {
		return items;
	}

	public void setItems(List<CartItemEntity> items) {
		this.items = items;
	}

	public Boolean getClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

}
