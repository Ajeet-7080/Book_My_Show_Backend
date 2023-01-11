package com.example.BookMyShowBackend.Models;

import com.example.BookMyShowBackend.Enum.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="show_seats")
public class ShowSeatEntity {
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

    @Column(name="is_booked",columnDefinition = "bit(1) default 0",nullable = false)
    private boolean booked;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="booked_at")
    private Date bookedAt;


    @ManyToOne
    @JsonIgnore
    private TicketEntity ticket;

    @ManyToOne
    @JsonIgnore
    private ShowEntity show;



}
