package cleanupV3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Seat> seats = new ArrayList<>();
        seats.add(new Seat("A1", "AVAILABLE"));
        seats.add(new Seat("A2", "AVAILABLE"));
        seats.add(new Seat("A3", "AVAILABLE"));

        List<String> bookSeats = List.of("A2", "A3", "A1", "A4");

        for (String bookSeat : bookSeats) {
            System.out.println(bookSeat(seats, bookSeat));
        }

        System.out.println("Total booked seats: " + countBookedSeats(seats));
    }

    private static String bookSeat(List<Seat> seats, String bookSeatNum) {
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

    private static int countBookedSeats(List<Seat> seats) {
        int count = 0;
        for (Seat seat : seats) {
            if (seat.getStatus().equals("BOOKED")) {
                ++count;
            }
        }

        return count;
    }
}
