package com.example.BookMyShowBackend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tickets")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="allotted_seat",nullable = false)
    private String allottedSeats;

    @Column(name="amount",nullable = false)
    private double amount;

    @Column(name="booked_at",nullable = false)
    private Date bookedAt;


    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private UserEntity user;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private ShowEntity show;

    @OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeatEntity> seats;



}
