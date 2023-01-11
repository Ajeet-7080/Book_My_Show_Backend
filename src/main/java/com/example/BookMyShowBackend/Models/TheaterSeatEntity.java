package com.example.BookMyShowBackend.Models;

import com.example.BookMyShowBackend.Enum.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="theaters_seats")
@Entity
public class TheaterSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="seat_number",nullable = false)
    private String seatNumber;

    @Column(name="rate",nullable = false)
    private double rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type",nullable = false)
    private SeatType seatType;


    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private TheaterEntity theater;
}
