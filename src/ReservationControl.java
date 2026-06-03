import java.util.ArrayList;
public class ReservationControl {
    private ArrayList<Reservation> ReservationList;

    public ReservationControl(){
        ReservationList = new ArrayList<>();
    }

    public void AddReservation(Reservation r)throws InvalidReservationException{
        if(r == null){
            throw new InvalidReservationException("Reservation details cannot be null.");
        }
        ReservationList.add(r);
        System.out.println("Reservation Is Done Succesfully");
    }

    public void RemoveReservation(Reservation r)throws ReservationNotFoundException{
        if(!ReservationList.contains(r)){
            throw new ReservationNotFoundException("Reservation Is Not Found.");
        }

        ReservationList.remove(r);
        System.out.println("Reservation removed successfully.");
    }

    public void DisplayReservationList(){
        if (ReservationList.isEmpty()){
            System.out.println("No Reservation Is Available!!");
            return;
        }
        int count=1;
        for (Reservation r : ReservationList){
            System.out.println("***Reservation No. "+ count++ +" ::");
            r.DisplayInformation();
            System.out.println();
        }
    }

    public void UpdateStatus(Reservation r, String status)throws InvalidStatusException{
        if(!(status.equalsIgnoreCase("Pending")
                || status.equalsIgnoreCase("Confirmed")
                || status.equalsIgnoreCase("Cancelled"))) {

            throw new InvalidStatusException("Invalid reservation status.");
        }
        r.setStatus(status);
        System.out.println("Status Updated To : "+status);
    }






}
