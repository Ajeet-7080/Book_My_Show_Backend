package com.example.BookMyShowBackend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@EntityListeners(value = { AuditingEntityListener.class })
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="tickets")
@Entity
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "alloted_Seat",nullable = false)
    private String allotedSeats;

    @Column(name="rate",nullable = false)
    private double amount;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date",nullable = false)
    private Date bookAt;

    @ManyToOne // this is used for connecting two table
    @JsonIgnore // used to ignore the value
    @JoinColumn // join the column
    private UserEntity user; // we can say its denote foreignKey its ignore at the input time becouse we have mention above JsonIgnore.

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private ShowEntity show;

    @OneToMany(mappedBy ="tickets",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeatEntity> seats;

}
