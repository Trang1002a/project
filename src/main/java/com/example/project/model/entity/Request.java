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
    @Column(name = "movie")
    private String movie;
    @Column(name = "branch")
    private String branch;
    @Column(name = "room")
    private String room;
    @Column(name = "hour_id")
    private String hour_id;
    @Column(name = "price")
    private String price;
    @Column(name = "movie_day")
    private String movie_day;
    @Column(name = "slot")
    private String slot;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "ticket_id")
    private String ticket_id;
    @Column(name = "created_at")
    private Date created_at;
    @Column(name = "status")
    private boolean status;
}
