package com.example.project.model.dto;

import com.example.project.model.entity.Hours;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DayHoursDTO {
    private Integer id;
    private String movie_day;
    private List<Hours> hours;
}
