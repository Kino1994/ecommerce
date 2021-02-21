package es.joaquin.planes.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.joaquin.planes.ecommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	

}