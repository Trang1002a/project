package com.example.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "image")
    private String image;
    @Column(name = "country")
    private String country;
    @Column(name = "performer")
    private String performer;
    @Column(name = "description")
    private String description;
    @Column(name = "created_at")
    private Date created_at;
    @Column(name = "status")
    private boolean status;
}
