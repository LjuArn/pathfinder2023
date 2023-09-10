package com.example.pathfinder2023.repository;

import com.example.pathfinder2023.domain.entity.PicturesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<PicturesEntity, Long> {

    @Query("SELECT p.url FROM PicturesEntity p")
    List<String> findAllByUrl();
}
