package cleanupV5;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private final List<Seat> seats;

    public BookingManager() {
        seats = new ArrayList<>();
        seats.add(new Seat("A1", SeatStatus.AVAILABLE));
        seats.add(new Seat("A2", SeatStatus.AVAILABLE));
        seats.add(new Seat("A3", SeatStatus.AVAILABLE));
    }

    public String bookSeat(String bookSeatNum) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(bookSeatNum)) {
                try {
                    return seat.book();
                } catch (IllegalStateException e) {
                    return e.getMessage();
                }
            }
        }

        return "Seat " + bookSeatNum + " does not exist.";
    }

    public int countBookedSeats() {
        int count = 0;
        for (Seat seat : seats) {
            if (seat.getStatus().equals(SeatStatus.BOOKED)) {
                ++count;
            }
        }

        return count;
    }
}
