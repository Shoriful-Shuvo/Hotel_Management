import java.time.LocalDate;
public abstract class Reservation {
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private Guest guest;
    private Room room;
    private String status;
    private double price;
    public Reservation(){}
    public Reservation(LocalDate arrivalDate, LocalDate departureDate, Guest guest, Room room, String status, double price)throws InvalidReservationException {
        if(arrivalDate == null || departureDate == null){
            throw new InvalidReservationException("Arrival and Departure dates cannot be empty.");
        }

        if(price <= 0){
            throw new InvalidReservationException("Price must be Positive.");
        }

        this.arrivalDate=arrivalDate;
        this.departureDate=departureDate;
        this.guest=guest;
        this.room=room;
        this.status=status;
        this.price=price;
    }

    public abstract double CalculateTotalcost();

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public String getStatus() {
        return status;
    }

    public double getPrice() {
        return price;
    }

    public void DisplayInformation(){
        System.out.println("*****Reservation Information :  *****");
        System.out.println("Guest Name       : ");
        System.out.println("Room Number      : ");
        System.out.println("ArrivalDate      : "+arrivalDate);
        System.out.println("Departure Date   : "+departureDate);
        System.out.println("Status           : "+status);
        System.out.println("Price            : "+price);
    }
}

