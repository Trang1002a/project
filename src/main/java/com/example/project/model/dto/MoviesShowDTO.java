package com.example.project.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MoviesShowDTO {
    private Integer id;
    private String name;
    private String movie_day;
    private String type;
    private String format;
    private String time;
    private String image;
}
