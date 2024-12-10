package cleanupV2;

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
                if (seat.getStatus().equals("BOOKED")) {
                    return "Seat " + bookSeatNum + " is already booked.";
                } else {
                    seat.setStatus("BOOKED");
                    return "Seat " + bookSeatNum + " has been successfully booked.";
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
