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
public class MoviesDTO {
    private Integer id;
    private String name;
    private List<TypeDTO> type;
    private List<FormatDTO> format;
    private List<CountryDTO> country;
    private String price;
    private String image;
    private String performer;
    private String time;
    private String description;
    private Date created_at;
    private boolean status;
}
