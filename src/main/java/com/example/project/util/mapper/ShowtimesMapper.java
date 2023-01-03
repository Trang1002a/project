package com.example.project.util.mapper;

import com.example.project.model.dto.*;
import com.example.project.model.entity.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ShowtimesMapper {
    public List<ShowtimesDTO> mapShowtimesDTO(List<Showtimes> listShowtimes, List<Movies> listMovies,
                                              List<Branch> listBranch,
                                              List<Room> listRoom,
                                              List<Hours> listHours){
        List<ShowtimesDTO> showtimesDTOS = new ArrayList<>();
        listShowtimes.forEach(list ->{
            ShowtimesDTO showtimesDTO = new ShowtimesDTO();
            showtimesDTO.setId(list.getId());
            showtimesDTO.setName(list.getName());
            showtimesDTO.setMovie_day(list.getMovie_day());
            showtimesDTO.setCreated_at(list.getCreated_at());
            showtimesDTO.setStatus(list.isStatus());


            List<MoviesDTO> dtoList = new ArrayList<>();
            if (!StringUtils.isEmpty(list.getMovies_id())){
                List<String> id = Arrays.asList(list.getMovies_id().split(","));
                if (id.size() > 0){
                    listMovies.forEach(l ->{
                        if (id.contains(String.valueOf(l.getId()))){
                            MoviesDTO dto = new MoviesDTO();
                            dto.setId(l.getId());
                            dto.setName(l.getName());
                            dto.setImage(l.getImage());
                            dtoList.add(dto);
                        }
                    });
                }
            }

            List<BranchDTO> dtoListF = new ArrayList<>();
            if (!StringUtils.isEmpty(list.getBranch_id())){
                List<String> id = Arrays.asList(list.getBranch_id().split(","));
                if (id.size() > 0){
                    listBranch.forEach(l ->{
                        if (id.contains(String.valueOf(l.getId()))){
                            BranchDTO dto = new BranchDTO();
                            dto.setId(l.getId());
                            dto.setName(l.getName());
                            dto.setShort_name(l.getShort_name());
                            dtoListF.add(dto);
                        }
                    });
                }
            }

            List<RoomDTO> dtoListC = new ArrayList<>();
            if (!StringUtils.isEmpty(list.getRoom_id())){
                List<String> id = Arrays.asList(list.getRoom_id().split(","));
                if (id.size() > 0){
                    listRoom.forEach(l ->{
                        if (id.contains(String.valueOf(l.getId()))){
                            RoomDTO dto = new RoomDTO();
                            dto.setId(l.getId());
                            dto.setName(l.getName());
                            dtoListC.add(dto);
                        }
                    });
                }
            }

            List<HoursDTO> dtoListH = new ArrayList<>();
            if (!StringUtils.isEmpty(list.getHours_id())){
                List<String> id = Arrays.asList(list.getHours_id().split(","));
                if (id.size() > 0){
                    listHours.forEach(l ->{
                        if (id.contains(String.valueOf(l.getId()))){
                            HoursDTO dto = new HoursDTO();
                            dto.setId(l.getId());
                            dto.setName(l.getName());
                            dtoListH.add(dto);
                        }
                    });
                }
            }

            showtimesDTO.setMovies_id(dtoList);
            showtimesDTO.setBranch_id(dtoListF);
            showtimesDTO.setRoom_id(dtoListC);
            showtimesDTO.setHours_id(dtoListH);
            showtimesDTOS.add(showtimesDTO);
        });
        return showtimesDTOS;
    }
}
