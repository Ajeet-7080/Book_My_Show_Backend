package com.example.BookMyShowBackend.Models;

import com.example.BookMyShowBackend.Enum.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="theater_seats")
public class TheaterSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="seat_number",nullable = false)
    private String seatNumber;

    @Column(name="rate",nullable = false)
    private int rate;

    @Enumerated(EnumType.STRING)
    @Column(name="seat_type",nullable = false)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private TheaterEntity theater;
}
