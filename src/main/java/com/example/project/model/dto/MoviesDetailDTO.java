package com.example.project.model.dto;

import com.example.project.model.entity.Branch;
import com.example.project.model.entity.Movies;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoviesDetailDTO {
    private Movies movies;
    private List<BranchShowtimesDTO> branch;
}
