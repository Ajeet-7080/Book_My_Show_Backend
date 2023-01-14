package com.example.BookMyShowBackend.Models;


import com.example.BookMyShowBackend.Enum.TheaterType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="theaters") //
@Entity
public class TheaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name",nullable = false)
    private String name;

    TheaterType type;

    @Column(name="address", nullable = false)
    private String address;

    @Column(name = "city",nullable = false)
    private String city;


    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TheaterSeatEntity> seats = new ArrayList<>();


    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowEntity> shows;
}
