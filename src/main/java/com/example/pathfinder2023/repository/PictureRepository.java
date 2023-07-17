package com.example.pathfinder2023.repository;

import com.example.pathfinder2023.domain.entity.PicturesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends JpaRepository<PicturesEntity, Long> {
}
