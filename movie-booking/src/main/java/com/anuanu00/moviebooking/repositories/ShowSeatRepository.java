package com.anuanu00.moviebooking.repositories;

import com.anuanu00.moviebooking.entites.Seat;
import com.anuanu00.moviebooking.entites.Show;
import com.anuanu00.moviebooking.entites.ShowSeat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShowSeatRepository implements IShowSeatRepository {

    private final Map<String, ShowSeat> showSeatMap;

    public ShowSeatRepository() {
        this.showSeatMap = new HashMap<>();
    }

    public ShowSeatRepository(Map<String, ShowSeat> showSeatMap) {
        this.showSeatMap = showSeatMap;
    }

    @Override
    public List<ShowSeat> getShowSeatsByShowId(String id) {
        return showSeatMap.values()
                .stream()
                .filter(showSeat -> {
                    String showId = showSeat.getId().split("#")[0];
                    return id.equals(showId);
                })
                .collect(Collectors.toList());
    }

    @Override
    public ShowSeat getShowSeat(String showId, String seatId) {
        String id = showId + "#" + seatId;
        return showSeatMap.get(id);
    }

    @Override
    public void addShowSeats(Show show, List<Seat> seatList) {
        seatList.stream()
                .forEach(seat -> {
                    String id = show.getId() + "#" + seat.getId();
                    showSeatMap.put(id, new ShowSeat(id, seat, show));
                });
    }

    @Override
    public void updateShowSeat(ShowSeat showSeat) {
        showSeatMap.put(showSeat.getId(), showSeat);
    }
}
