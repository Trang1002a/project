package com.example.project.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchDTO {
    private Integer id;
    private String name;
    private String short_name;
    private String phone_number;
    private String address;
    private List<RoomDTO> room;
    private String total;
    private Date created_at;
    private boolean status;
}
