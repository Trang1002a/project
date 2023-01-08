package com.example.project.service.Impl;

import com.example.project.model.dto.*;
import com.example.project.model.entity.*;
import com.example.project.repository.*;
import com.example.project.service.UserHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserHomeServiceImpl implements UserHomeService {
    @Autowired
    private ShowtimesRepository showtimesRepository;

    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private FormatRepository formatRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private HoursRepository hoursRepository;

    @Override
    public List<MoviesShowDTO> getHomeMovie() {
        List<MoviesShowDTO> list = new ArrayList<>();
        List<MoviesIDAndDay> showtimes = showtimesRepository.findAllByStatus(true);
        List<String> listIds = showtimes.stream().map((MoviesIDAndDay::getMovies_id)).collect(Collectors.toList());
        List<Integer> intList = new ArrayList<>();
        for (String s : listIds) intList.add(Integer.valueOf(s));
        List<Movies> movies = moviesRepository.findAllByIdIn(intList);

        showtimes.forEach(moviesIDAndDay -> {
            MoviesShowDTO moviesShowDTO = new MoviesShowDTO();
            Movies moviesName = movies.stream().filter(m -> String.valueOf(m.getId()).equals(moviesIDAndDay.getMovies_id()))
                    .findFirst().orElse(null);
            moviesShowDTO.setId(moviesName.getId());
            moviesShowDTO.setName(moviesName.getName());
            moviesShowDTO.setImage(moviesName.getImage());
            moviesShowDTO.setType(getType(moviesName.getType_id()));
            moviesShowDTO.setFormat(getFormat(moviesName.getFormat_id()));
            moviesShowDTO.setMovie_day(moviesIDAndDay.getMovie_day());
            moviesShowDTO.setTime(moviesName.getTime());
            list.add(moviesShowDTO);
        });
        return list;
    }

    @Override
    public MoviesDetailDTO getDetail(Integer id) {
        MoviesDetailDTO moviesDetailDTO = new MoviesDetailDTO();
        Movies movies = moviesRepository.findById(id).get();

        Movies moviesDetail = new Movies();
        moviesDetail.setId(movies.getId());
        moviesDetail.setName(movies.getName());
        moviesDetail.setType_id(getType(movies.getType_id()));
        moviesDetail.setFormat_id(getFormat(movies.getFormat_id()));
        moviesDetail.setCountry_id(getCountry(movies.getCountry_id()));
        moviesDetail.setPrice(movies.getPrice());
        moviesDetail.setImage(movies.getImage());
        moviesDetail.setPerformer(movies.getPerformer());
        moviesDetail.setTime(movies.getTime());
        moviesDetail.setDescription(movies.getDescription());
        moviesDetail.setStatus(movies.isStatus());

        moviesDetailDTO.setMovies(moviesDetail);

        List<Showtimes> list = showtimesRepository.findAllByIdAndStatusOrderByMovie_dayAsc(String.valueOf(id), true);
        Set<String> branch_id = list.stream().map(Showtimes::getBranch_id).collect(Collectors.toSet());
        List<Integer> intList = new ArrayList<>();
        for (String s : branch_id) intList.add(Integer.valueOf(s));
        List<Branch> branchList = branchRepository.findByIdIn(intList);
        List <BranchShowtimesDTO> branchShowtimesDTOS = new ArrayList<>();
        branchList.stream().peek(branch -> {
            BranchShowtimesDTO branchShowtimesDTO = new BranchShowtimesDTO();
            List<Showtimes> listS = list.stream().filter(l -> l.getBranch_id().equals(String.valueOf(branch.getId()))).collect(Collectors.toList());

            branchShowtimesDTO.setBranch_id(branch.getId());

            List<DayHoursDTO> dayHoursDTOList = new ArrayList<>();
            listS.forEach(showtimes -> {
                DayHoursDTO dto = new DayHoursDTO();
                List<String> hours = Arrays.asList(getHours(showtimes.getHours_id()).split(","));
                dto.setMovie_day(showtimes.getMovie_day());
                dto.setHours(hours);
                dayHoursDTOList.add(dto);
            });
            branchShowtimesDTO.setDay_hours(dayHoursDTOList);
            branchShowtimesDTOS.add(branchShowtimesDTO);
        });

        moviesDetailDTO.setBranch(branchShowtimesDTOS);
        return moviesDetailDTO;
    }

    private String getType(String type_id) {
        List<String> typeId = Arrays.asList(type_id.split(","));
        List<Type> types = typeRepository.findAll();
        StringBuilder rt = new StringBuilder();
        types.forEach(type -> {
            if(typeId.contains(String.valueOf(type.getId()))){
                rt.append(type.getName() + ", ");
            }
        });
        String str = rt.toString();
        return str.substring(0, str.length() - 2);
    }

    private String getFormat(String format_id) {
        List<String> formatId = Arrays.asList(format_id.split(","));
        List<Format> formats = formatRepository.findAll();
        StringBuilder rt = new StringBuilder(", ");
        formats.forEach(format -> {
            if(formatId.contains(String.valueOf(format.getId()))){
                rt.append(format.getName() + ", ");
            }
        });
        String str = rt.toString();
        return str.substring(0, str.length() - 2);
    }

    private String getCountry(String country_id) {
        List<String> countryId = Arrays.asList(country_id.split(","));
        List<Country> countries = countryRepository.findAll();
        StringBuilder rt = new StringBuilder(", ");
        countries.forEach(country -> {
            if(countryId.contains(String.valueOf(country.getId()))){
                rt.append(country.getName() + ", ");
            }
        });
        String str = rt.toString();
        return str.substring(0, str.length() - 2);
    }

    private String getHours(String hours_id) {
        List<String> hoursId = Arrays.asList(hours_id.split(","));
        List<Hours> hours = hoursRepository.findAll();
        StringBuilder rt = new StringBuilder(", ");
        hours.forEach(hour -> {
            if(hoursId.contains(String.valueOf(hour.getId()))){
                rt.append(hour.getName() + ", ");
            }
        });
        String str = rt.toString();
        return str.substring(0, str.length() - 2);
    }
}
