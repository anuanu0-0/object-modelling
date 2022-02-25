package com.anuanu00.moviebooking.commands;

import com.anuanu00.moviebooking.entites.ShowSeat;
import com.anuanu00.moviebooking.services.IShowService;

import java.util.List;

public class DisplayShowSeatCommand implements ICommand {

    private final IShowService iShowService;

    public DisplayShowSeatCommand(IShowService iShowService) {
        this.iShowService = iShowService;
    }

    @Override
    public void execute(List<String> tokens) {
        String showId = tokens.get(1);
        List<ShowSeat> showSeatList = iShowService.getAllShowSeats(showId);
        showSeatList.stream()
                .forEach(showSeat -> {
                    System.out.println("SeatRow - " + showSeat.getSeatRow());
                    System.out.println("SeatColumn - " + showSeat.getSeatColumn());
                    System.out.println("Status - " + showSeat.getShowSeatStatus());
                    System.out.println();
                });
    }
}
