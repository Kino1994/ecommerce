package es.joaquin.ecommerce.infraestructure.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ShoppingCartEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String description;
	
	@OneToMany(mappedBy="shoppingCart")
	private List<CartItemEntity> items;

	public ShoppingCartEntity(String description, List<CartItemEntity> items) {
		this.description = description;
		this.items = items;
	}

	public ShoppingCartEntity(Long id, String description, List<CartItemEntity> items) {
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

	public List<CartItemEntity> getItems() {
		return items;
	}

	public void setItems(List<CartItemEntity> items) {
		this.items = items;
	}

}
