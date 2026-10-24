package com.supermarket.inventory.repository;

import com.supermarket.inventory.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
