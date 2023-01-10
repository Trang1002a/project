package com.example.project.model.dto;

import com.example.project.model.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookTicketDTO {
    private String id;
    private String name_movie;
    private String branch_name;
    private String hour;
    private String hour_id;
    private String movie_day;
    private String price;
    private String rooms_name;
    private List<String> row;
    private List<Integer> col;
    private Integer total;
}
