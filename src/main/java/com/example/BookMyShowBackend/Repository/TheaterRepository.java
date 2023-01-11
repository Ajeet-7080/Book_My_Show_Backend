package com.example.BookMyShowBackend.Repository;

import com.example.BookMyShowBackend.Models.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<TheaterEntity,Integer> {
}
