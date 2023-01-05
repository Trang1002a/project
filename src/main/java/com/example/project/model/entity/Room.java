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
@Table(name = "tbl_room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "branch_id")
    private Integer branch_id;
    @Column(name = "name")
    private String name;
    @Column(name = "row")
    private String row;
    @Column(name = "col")
    private String col;
    @Column(name = "total")
    private String total;
    @Column(name = "created_at")
    private Date created_at;
    @Column(name = "status")
    private boolean status;
}
