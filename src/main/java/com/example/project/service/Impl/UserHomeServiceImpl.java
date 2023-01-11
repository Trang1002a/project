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

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RequestRepository requestRepository;

    private final static String[] alpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
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
        branchList.forEach(branch -> {
            BranchShowtimesDTO branchShowtimesDTO = new BranchShowtimesDTO();
            List<Showtimes> listS = list.stream().filter(l -> l.getBranch_id().equals(String.valueOf(branch.getId()))).collect(Collectors.toList());

            branchShowtimesDTO.setBranch_id(branch.getId());
            branchShowtimesDTO.setBranch_name(branch.getName());

            List<DayHoursDTO> dayHoursDTOList = new ArrayList<>();
            listS.forEach(showtimes -> {
                DayHoursDTO dto = new DayHoursDTO();
//                List<String> hours = Arrays.asList(getHours(showtimes.getHours_id()).split(","));
                List<Integer> intList2 = new ArrayList<>();
                List<String> hours = Arrays.asList(showtimes.getHours_id().split(","));
                for (String s : hours) intList2.add(Integer.valueOf(s));
                List<Hours> hoursList = hoursRepository.findAllById(intList2);
                dto.setId(showtimes.getId());
                dto.setMovie_day(showtimes.getMovie_day());
                dto.setHours(hoursList);
                dayHoursDTOList.add(dto);
            });
            branchShowtimesDTO.setDay_hours(dayHoursDTOList);
            branchShowtimesDTOS.add(branchShowtimesDTO);
        });

        moviesDetailDTO.setBranch(branchShowtimesDTOS);
        return moviesDetailDTO;
    }

    @Override
    public BookTicketDTO getBookTicket(Integer id, String hour) {
        BookTicketDTO bookTicketDTO = new BookTicketDTO();
        Showtimes showtimes = showtimesRepository.findById(id).get();
        Map<String, String> priceMovie = getMovies(showtimes.getMovies_id());
        bookTicketDTO.setId(String.valueOf(id));
        bookTicketDTO.setName_movie(priceMovie.get("movie"));
        bookTicketDTO.setBranch_name(getBranch(showtimes.getBranch_id()));
        Map<String, String> hourss = getHours(hour);
        bookTicketDTO.setHour(hourss.get("hour"));
        bookTicketDTO.setHour_id(hour);
        bookTicketDTO.setMovie_day(showtimes.getMovie_day());
        bookTicketDTO.setPrice(priceMovie.get("price"));
        Room room = roomRepository.findByIdAndStatus(Integer.parseInt(showtimes.getRoom_id()), true);
        bookTicketDTO.setRooms_name(room.getName());
        List<Map<String, String>> listSlot = new ArrayList<>();

        String ticket_id = "#"+id+"-"+hour;
        List<Request> list =  requestRepository.findAllByTicket_id(ticket_id, true);
        List<String> slotAll = new ArrayList<>();
        list.forEach(request -> {
            List<String> slotA = Arrays.asList(request.getSlot().split(","));
            slotAll.addAll(slotA);
        });

        for(int i = 0; i<Integer.parseInt(room.getRow()); i++){
            for(int j = 0; j<Integer.parseInt(room.getCol()); j++){
                Map<String, String> stringMap = new HashMap<>();
                String slot = alpha[i]+String.valueOf(j);
                stringMap.put(slot, slotAll.contains(slot) ? "1" : "0");
                listSlot.add(stringMap);
            }
        }
        bookTicketDTO.setRow(Integer.parseInt(room.getRow()));
        bookTicketDTO.setCol(Integer.parseInt(room.getCol()));
        bookTicketDTO.setSlot(listSlot);
        bookTicketDTO.setTotal(Integer.parseInt(room.getTotal()));
        return bookTicketDTO;
    }

    @Override
    public Request saveRequest(Request request) {
        List<String> slot = Arrays.asList(request.getSlot().split(","));
        Integer total_price = Integer.parseInt(request.getPrice()) * slot.size();
        request.setTotal_price(String.valueOf(total_price));
        request.setStatus(true);
        return requestRepository.save(request);
    }

    @Override
    public List<String> getSlot(String ticket_id) {

        return null;
    }

    private String getType(String type_id) {
        if (type_id != null){
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
        return type_id;
    }

    private Map<String, String> getMovies(String movies_id) {
        if (movies_id != null){
            List<String> moviesId = Arrays.asList(movies_id.split(","));
            List<Movies> movies = moviesRepository.findAll();
            StringBuilder rt = new StringBuilder();
            List<String> prices = new ArrayList<>();
            movies.forEach(movie -> {
                if(moviesId.contains(String.valueOf(movie.getId()))){
                    rt.append(movie.getName() + ", ");
                    String price = movie.getPrice();
                    prices.add(price);
                }
            });

            String str = rt.toString();
            Map<String, String> stringMap = new HashMap<>();
            stringMap.put("price", prices.get(0));
            stringMap.put("movie", str.substring(0, str.length() - 2));
            return stringMap;
        }
        return new HashMap<>();
    }

    private String getFormat(String format_id) {
        if (format_id != null){
            List<String> formatId = Arrays.asList(format_id.split(","));
            List<Format> formats = formatRepository.findAll();
            StringBuilder rt = new StringBuilder();
            formats.forEach(format -> {
                if(formatId.contains(String.valueOf(format.getId()))){
                    rt.append(format.getName() + ", ");
                }
            });
            String str = rt.toString();
            return str.substring(0, str.length() - 2);
        }
        return format_id;
    }

    private String getBranch(String branch_id) {
        if (branch_id != null){
            List<String> branchId = Arrays.asList(branch_id.split(","));
            List<Branch> branches = branchRepository.findAll();
            StringBuilder rt = new StringBuilder();
            branches.forEach(branch -> {
                if(branchId.contains(String.valueOf(branch.getId()))){
                    rt.append(branch.getName() + ", ");
                }
            });
            String str = rt.toString();
            return str.substring(0, str.length() - 2);
        }
        return branch_id;
    }

    private String getCountry(String country_id) {
        if (country_id != null){
            List<String> countryId = Arrays.asList(country_id.split(","));
            List<Country> countries = countryRepository.findAll();
            StringBuilder rt = new StringBuilder();
            countries.forEach(country -> {
                if(countryId.contains(String.valueOf(country.getId()))){
                    rt.append(country.getName() + ", ");
                }
            });
            String str = rt.toString();
            return str.substring(0, str.length() - 2);
        }
        return country_id;
    }

    private Map<String, String> getHours(String hours_id) {
        if (hours_id != null) {
            List<String> hoursId = Arrays.asList(hours_id.split(","));
            List<Hours> hours = hoursRepository.findAll();
            StringBuilder rt = new StringBuilder();
            hours.forEach(hour -> {
                if(hoursId.contains(String.valueOf(hour.getId()))){
                    rt.append(hour.getName() + ",");
                }
            });
            String hourId = String.valueOf(hours.get(0).getId());
            String str = rt.toString();
            Map<String, String> stringMap = new HashMap<>();
            stringMap.put("hour_id", hourId);
            stringMap.put("hour", str.substring(0, str.length() - 2));
            return stringMap;
        }
        return new HashMap<>();
    }
}
