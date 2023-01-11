package com.example.BookMyShowBackend.Models;

import com.example.BookMyShowBackend.Enum.TheaterType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "theaters")
public class TheaterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="city",nullable = false)
    private String city;

    @Column(name="address",nullable = false)
    private String address;

    @OneToMany(mappedBy ="theater",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowEntity>shows;

    TheaterType type;

    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TheaterSeatEntity> seats=new ArrayList<>();

}
