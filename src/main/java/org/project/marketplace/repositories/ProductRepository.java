package org.project.marketplace.repositories;

import org.project.marketplace.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>
{
    List<ProductEntity> findByTitle(String title);
}
