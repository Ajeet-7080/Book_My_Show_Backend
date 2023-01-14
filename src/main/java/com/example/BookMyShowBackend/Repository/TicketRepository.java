package com.example.BookMyShowBackend.Repository;

import com.example.BookMyShowBackend.Models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {
}
