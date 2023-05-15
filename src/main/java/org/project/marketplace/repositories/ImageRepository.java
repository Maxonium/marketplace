package org.project.marketplace.repositories;

import org.project.marketplace.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long>
{

}
