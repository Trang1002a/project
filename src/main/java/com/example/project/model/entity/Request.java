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
@Table(name = "tbl_request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private Integer movie_id;
    private Integer format_id;
    private Integer type_id;
    private float price;
    private Date movie_day;
    private Integer branch_id;
    private Integer room_id;
    private Integer hours_id;
    private boolean status;
}
