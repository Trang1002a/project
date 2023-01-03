package com.example.project.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowtimesDTO {
    private int id;
    private String name;
    private List<MoviesDTO> movies_id;
    private List<BranchDTO> branch_id;
    private List<RoomDTO> room_id;
    private List<HoursDTO> hours_id;
    private String movie_day;
    private Date created_at;
    private boolean status;
}
