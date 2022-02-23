package com.anuanu00.moviebooking.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ShowResponse {
    private String showId;
    private String movieTitle;
    private String cinemaName;
    private String screenName;
    private Date start;
    private Date end;

}
