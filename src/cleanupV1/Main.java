package cleanupV1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> seats = new ArrayList<>();
        seats.add("A1:AVAILABLE");
        seats.add("A2:AVAILABLE");
        seats.add("A3:AVAILABLE");

        List<String> bookSeats = List.of("A2", "A3", "A1", "A4");

        for (String bookSeat : bookSeats) {
            System.out.println(bookSeat(seats, bookSeat));
        }

        System.out.println("Total booked seats: " + countBookedSeats(seats));
    }

    private static String bookSeat(List<String> seats, String bookSeatNum) {
        for (int i = 0; i < seats.size(); i++) {
            String seat = seats.get(i);
            if (seat.startsWith(bookSeatNum)) {
                if (seat.endsWith("BOOKED")) {
                    return "Seat " + bookSeatNum + " is already booked.";
                } else {
                    seats.set(i, bookSeatNum + ":BOOKED");
                    return "Seat " + bookSeatNum + " has been successfully booked.";
                }
            }
        }

        return "Seat " + bookSeatNum + " does not exist.";
    }

    private static int countBookedSeats(List<String> seats) {
        int count = 0;
        for (String seat : seats) {
            if (seat.endsWith("BOOKED")) {
                ++count;
            }
        }

        return count;
    }
}
