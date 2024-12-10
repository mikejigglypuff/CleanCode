package cleanupV5;

public class Seat {
    private final String seatNumber;
    private SeatStatus status;

    public Seat(String seatNumber, SeatStatus status) {
        this.seatNumber = seatNumber;
        this.status = status;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public String book() {
        if(status.equals(SeatStatus.BOOKED))
            throw new IllegalStateException("Seat " + seatNumber + " is already booked.");

        this.status = SeatStatus.BOOKED;
        return "Seat " + seatNumber + " has been successfully booked.";
    }
}
