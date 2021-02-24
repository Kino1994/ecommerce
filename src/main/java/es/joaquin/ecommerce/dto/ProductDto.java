package es.joaquin.ecommerce.dto;

public class ProductDto {
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private Double value;

	public ProductDto() {

	}
	
	public ProductDto(String name, String description, Double value) {
		this.name = name;
		this.description = description;
		this.value = value;
	}

	public ProductDto(Long id, String name, String description, Double value) {
		this(name,description,value);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
