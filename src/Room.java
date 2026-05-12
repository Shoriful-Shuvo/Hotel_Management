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





}
