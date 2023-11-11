package com.example.pathfinder2023.repository;

import com.example.pathfinder2023.domain.entity.CommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<CommentsEntity, Long> {


}
