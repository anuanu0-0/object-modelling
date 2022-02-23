package com.anuanu00.moviebooking.repositories;

import com.anuanu00.moviebooking.entites.Seat;
import com.anuanu00.moviebooking.entites.Show;
import com.anuanu00.moviebooking.entites.ShowSeat;

import java.util.List;

public interface IShowSeatRepository {
    List<ShowSeat> getShowSeatsByShowId(String id);
    ShowSeat getShowSeat(String showId, String seatId);
    void addShowSeats(Show show, List<Seat> seatList);
    void updateShowSeat(ShowSeat showSeat);
}
