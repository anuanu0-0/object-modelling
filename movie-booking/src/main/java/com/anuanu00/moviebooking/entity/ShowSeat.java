package com.anuanu00.moviebooking.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class ShowSeat {
    private final String id;
    private final Seat seat;
    private final Show show;
    private ShowSeatStatus showSeatStatus;

    public int getSeatRow() {
        return seat.getSeatRow();
    }

    public int getSeatColumn() {
        return seat.getSeatColumn();
    }

    public void lock() {
        showSeatStatus = ShowSeatStatus.RESERVED;
    }

    public void unlock() {
        showSeatStatus = ShowSeatStatus.UNRESERVED;
    }

    public boolean isLocked() {
        return showSeatStatus == ShowSeatStatus.RESERVED;
    }
}
