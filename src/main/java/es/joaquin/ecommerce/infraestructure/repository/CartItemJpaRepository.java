package es.joaquin.ecommerce.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.joaquin.ecommerce.infraestructure.model.CartItemEntity;

public interface CartItemJpaRepository extends JpaRepository<CartItemEntity, Long> {
	

}