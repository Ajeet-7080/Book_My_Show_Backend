package com.example.BookMyShowBackend.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.core.SpringVersion;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // auto generated

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="release_date",columnDefinition = "DATE",nullable = false)
    private LocalDate releaseDate;

// Connecting the other table
    // since this is the parent (how did we come to know : its having mapped by and cascade)
    // child table having @join Annotation
    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowEntity> shows;


}
