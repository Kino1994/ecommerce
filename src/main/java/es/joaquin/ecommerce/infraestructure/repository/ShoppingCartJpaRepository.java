package es.joaquin.ecommerce.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.joaquin.ecommerce.infraestructure.model.ShoppingCartEntity;

public interface ShoppingCartJpaRepository extends JpaRepository<ShoppingCartEntity, Long> {
	

}