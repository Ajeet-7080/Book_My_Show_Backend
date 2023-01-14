package com.example.BookMyShowBackend.Models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter //this is used for accessing private value
@Setter // this is used for setting the value
@Builder //for building lightweight object
@Table(name="users") // this annotation used for giving the table name. It can be optional.
@Entity // this annotation is used for creating new table for this table
public class UserEntity {
    @Id //this annotation is used for making a column primary key or making primary key for this table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this annotation is used for generating value this is two type IDENTITY and AUTO. identity used to  generate unique for the table in which its mention whereas auto for generate unique value for all table
    private int id;

    @Column(name="name",nullable = false) // this annotation give the column name in the table and some properties.
    private String name;

    @Column(name="mobile",nullable = false)
    private String mobile;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL) // this annotation is used for bidirectional mapping this is for parent class.
    private List<TicketEntity> ticketEntities;
}
