package com.example.BookMyShowBackend.Models;

import com.example.BookMyShowBackend.Enum.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="show_seats")
@Entity
public class ShowSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="rate",nullable = false)
    private double rate;

    @Column(name = "seat_number",nullable = false)
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type",nullable = false)
    private SeatType seattype;

    @Column(name = "is_booked",columnDefinition = "bit(1) default 0",nullable = false)
    private boolean booked;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "booked_at")
    private Date bookAt;


    @ManyToOne
    @JsonIgnore
    private TicketEntity tickets;

    @ManyToOne
    @JsonIgnore
    private ShowEntity show;



}
