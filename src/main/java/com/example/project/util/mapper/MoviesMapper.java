package com.example.project.util.mapper;

import com.example.project.model.dto.*;
import com.example.project.model.entity.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class MoviesMapper {
    public List<MoviesDTO> mapListMoviesDTO(List<Movies> listMovies, List<Type> listType, List<Format> listFormat, List<Country> listCountry){
        List<MoviesDTO> moviesDTOS = new ArrayList<>();
        listMovies.forEach(list ->{
            MoviesDTO moviesDTO = new MoviesDTO();
            moviesDTO.setId(list.getId());
            moviesDTO.setName(list.getName());
            moviesDTO.setImage(list.getImage());
            moviesDTO.setPrice(list.getPrice());
            moviesDTO.setTime(list.getTime());
            moviesDTO.setPerformer(list.getPerformer());
            moviesDTO.setDescription(list.getDescription());
            moviesDTO.setCreated_at(list.getCreated_at());
            moviesDTO.setStatus(list.isStatus());


            List<TypeDTO> dtoList = new ArrayList<>();
            if (!StringUtils.isEmpty(list.getType_id())){
                List<String> id = Arrays.asList(list.getType_id().split(","));
                if (id.size() > 0){
                    listType.forEach(l ->{
                        if (id.contains(String.valueOf(l.getId()))){
                            TypeDTO dto = new TypeDTO();
                            dto.setId(l.getId());
                            dto.setName(l.getName());
                            dto.setShort_name(l.getShort_name());
                            dtoList.add(dto);
                        }
                    });
                }
            }

            List<FormatDTO> dtoListF = new ArrayList<>();
            if (!StringUtils.isEmpty(list.getFormat_id())){
                List<String> id = Arrays.asList(list.getFormat_id().split(","));
                if (id.size() > 0){
                    listFormat.forEach(l ->{
                        if (id.contains(String.valueOf(l.getId()))){
                            FormatDTO dto = new FormatDTO();
                            dto.setId(l.getId());
                            dto.setName(l.getName());
                            dto.setShort_name(l.getShort_name());
                            dtoListF.add(dto);
                        }
                    });
                }
            }

            List<CountryDTO> dtoListC = new ArrayList<>();
            if (!StringUtils.isEmpty(list.getCountry_id())){
                List<String> id = Arrays.asList(list.getCountry_id().split(","));
                if (id.size() > 0){
                    listCountry.forEach(l ->{
                        if (id.contains(String.valueOf(l.getId()))){
                            CountryDTO dto = new CountryDTO();
                            dto.setId(l.getId());
                            dto.setName(l.getName());
                            dto.setShort_name(l.getShort_name());
                            dtoListC.add(dto);
                        }
                    });
                }
            }

            moviesDTO.setType(dtoList);
            moviesDTO.setFormat(dtoListF);
            moviesDTO.setCountry(dtoListC);
            moviesDTOS.add(moviesDTO);
        });
        return moviesDTOS;
    }
}
