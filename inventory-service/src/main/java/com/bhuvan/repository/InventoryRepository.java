package com.bhuvan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhuvan.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

	Optional<Inventory> findByProductId(int productId);

}
