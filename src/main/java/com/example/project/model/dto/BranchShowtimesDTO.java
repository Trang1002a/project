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
public class BranchShowtimesDTO {
    private Integer id;
    private Integer branch_id;
    private List<DayHoursDTO> day_hours;
}
