package cleanupV3;

public class Seat {
    private final String seatNumber;
    private String status;

    public Seat(String seatNumber, String status) {
        this.seatNumber = seatNumber;
        this.status = status;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getStatus() {
        return status;
    }

    public String book() {
        if(status.equals("BOOKED"))
            throw new IllegalStateException("Seat " + seatNumber + " is already booked.");

        this.status = "BOOKED";
        return "Seat " + seatNumber + " has been successfully booked.";
    }
}
