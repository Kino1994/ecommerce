package es.joaquin.ecommerce.controller.request;

public class ProductRequest {
	
	private String name;
	
	private String description;
	
	private Double value;	

	public ProductRequest() {

	}
	
	public ProductRequest(String name, String description, Double value) {
		this.name = name;
		this.description = description;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
