import java.time.LocalDate;

public class OfflineReservation extends Reservation{
    private String DeskName;
    private String EmployeeName;

    public OfflineReservation(){}

    public OfflineReservation(LocalDate arrivalDate, LocalDate departureDate, Guest guest, Room room, String status, double price, String DeskName, String EmployeeName){
        super(arrivalDate, departureDate, guest, room, status, price);
        this.DeskName=DeskName;
        this.EmployeeName=EmployeeName;
    }

    public void setDeskName(String deskName) {
        this.DeskName = deskName;
    }

    public void setEmployeeName(String employeeName) {
        this.EmployeeName = employeeName;
    }

    public String getDeskName() {
        return DeskName;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }



    @Override
    public void DisplayInformation() {
        super.DisplayInformation();
        System.out.println("");
        System.out.println("");
        System.out.println("");

    }


}
