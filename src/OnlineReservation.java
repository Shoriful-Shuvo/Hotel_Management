import java.time.LocalDate;
public class OnlineReservation extends Reservation{
    private String PaymentMethod;
    private String TransactionID;
    private String PhoneNumber;

    public OnlineReservation(){}

    public OnlineReservation(LocalDate arrivalDate, LocalDate departureDate, Guest guest, Room room, String status, double price, String PaymentMethod, String TransactionID, String PhoneNumber){
        super(arrivalDate, departureDate, guest, room, status, price);
        this.PaymentMethod=PaymentMethod;
        this.TransactionID=TransactionID;
        this.PhoneNumber=PhoneNumber;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.PaymentMethod = paymentMethod;
    }

    public void setTransactionID(String transactionID) {
        this.TransactionID = transactionID;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public String getTransactionID() {
        return TransactionID;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    @Override
    public double CalculateTotalcost(){
        return getPrice()*0.5 ;
    }

    @Override
    public void DisplayInformation() {
        super.DisplayInformation();
        System.out.println("");
        System.out.println("");
        System.out.println("");

    }
}
