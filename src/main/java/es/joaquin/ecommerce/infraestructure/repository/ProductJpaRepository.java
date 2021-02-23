package es.joaquin.ecommerce.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.joaquin.ecommerce.infraestructure.model.ProductEntity;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
	

}