package cleanupV4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookingManager bookingManager = new BookingManager();

        List<String> bookSeats = List.of("A2", "A3", "A1", "A4");

        for (String bookSeat : bookSeats) {
            System.out.println(bookingManager.bookSeat(bookSeat));
        }

        System.out.println("Total booked seats: " + bookingManager.countBookedSeats());
    }
}
