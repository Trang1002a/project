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
    @Column(name = "type_id")
    private String type_id;
    @Column(name = "format_id")
    private String format_id;
    @Column(name = "country_id")
    private String country_id;
    @Column(name = "price")
    private String price;
    @Column(name = "image")
    private String image;
    @Column(name = "performer")
    private String performer;
    @Column(name = "time")
    private String time;
    @Column(name = "description")
    private String description;
    @Column(name = "created_at")
    private Date created_at;
    @Column(name = "status")
    private boolean status;
}
