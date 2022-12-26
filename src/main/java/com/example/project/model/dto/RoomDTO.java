package com.example.project.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    private Integer id;
    private String name;
    private String row;
    private String col;
    private String total;
    private Date created_at;
    private boolean status;
}
