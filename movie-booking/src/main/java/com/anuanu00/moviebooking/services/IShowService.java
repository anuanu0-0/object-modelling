package com.anuanu00.moviebooking.services;

import com.anuanu00.moviebooking.dto.ShowResponse;
import com.anuanu00.moviebooking.entites.ShowSeat;

import java.util.List;

public interface IShowService {
    List<ShowResponse> getAllShowsByMovieTitle(String movieTitle);
    List<ShowSeat> getAllShowSeats(String showId);
}
