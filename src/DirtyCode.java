import java.util.ArrayList;
import java.util.List;

public class DirtyCode {
    public static void main(String[] args) {
        List<String> seats = new ArrayList<>();
        seats.add("A1:AVAILABLE");
        seats.add("A2:AVAILABLE");
        seats.add("A3:AVAILABLE");

        List<String> seats2 = List.of("A2", "A3", "A1", "A4");

        for (String seat2 : seats2) {
            boolean book = false;

            for (int i = 0; i < seats.size(); i++) {
                String seat = seats.get(i);
                if (seat.startsWith(seat2)) {
                    if (seat.endsWith("BOOKED")) {
                        System.out.println("Seat " + seat2 + " is already booked.");
                        book = true;
                        break;
                    } else {
                        seats.set(i, seat2 + ":BOOKED");
                        System.out.println("Seat " + seat2 + " has been successfully booked.");
                        book = true;
                        break;
                    }
                }
            }

            if (!book) {
                System.out.println("Seat " + seat2 + " does not exist.");
            }
        }

        int count = 0;
        for (String seat : seats) {
            if (seat.endsWith("BOOKED")) {
                count++;
            }
        }
        System.out.println("Total booked seats: " + count);
    }
}
