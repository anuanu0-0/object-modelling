package com.anuanu00.moviebooking.repository;

import com.anuanu00.moviebooking.entity.Seat;
import com.anuanu00.moviebooking.entity.Show;
import com.anuanu00.moviebooking.entity.ShowSeat;

import java.util.List;

public interface IShowSeatRepository {
    List<ShowSeat> getShowSeatsByShowId(String id);
    ShowSeat getShowSeat(String showId, String seatId);
    void addShowSeats(Show show, List<Seat> seatList);
    void updateShowSeat(ShowSeat showSeat);
}
