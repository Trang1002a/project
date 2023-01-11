package com.example.project.model.dto;

import com.example.project.model.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

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
    private List<Map<String, String>> slot;
    private Integer row;
    private Integer col;
    private Integer total;
}
