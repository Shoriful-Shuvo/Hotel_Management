import java.util.ArrayList;
public class ReservationControl {
    private ArrayList<Reservation> ReservationList;

    public ReservationControl{
        ReservationList = new ArrayList<>();
    }

    public void AddReservation(Reservation r){
        ReservationList.add(r);
        System.out.println("Reservation Is Done Succesfully");
    }

    public void RemoveReservation(Reservation r){
        if (ReservationList.remove(r)){
            System.out.println("Reservation Is Removed Succesfully");
        }
        else {
            System.out.println("Reservation Is Not Found");
        }
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

    public void UpdateStatus(Reservation r, String status){
        r.setStatus(status);
        System.out.println("Status Updated To : "+status);
    }






}
