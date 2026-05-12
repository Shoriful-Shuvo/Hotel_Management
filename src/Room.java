public abstract class Room {
    private int RoomNumber;
    private int Floor;
    private double Price;
    private boolean AvailableRoom;

    public Room (int RoomNumber,int Floor,double Price,boolean AvailableRoom) {
         this.RoomNumber = RoomNumber;
         this.Floor = Floor;
         this.Price = Price;
         this.AvailableRoom = AvailableRoom;
    }
    public int getRoomNumber() {
        return RoomNumber;
    }

    public int getFloor() {
        return Floor;
    }
    public double getPrice() {
        return Price;
    }
    public boolean getAvailableRoom () {
        return AvailableRoom;
    }
    public void setPrice(double Price) {
        this.Price = Price;

    }
    public void setAvailableRoom (boolean AvailableRoom) {
        this.AvailableRoom = AvailableRoom;
    }
    public void RoomBooking () {
        if(!AvailableRoom) {
            System.out.println("Room is already Booked");
            return;
        }
        AvailableRoom = false;
        System.out.println("Now room is successfully booked");
    }





}
