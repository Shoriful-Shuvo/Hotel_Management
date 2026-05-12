public abstract class Room {
    private int RoomNumber;
    private int Floor;
    private double Price;

    public Room (int RoomNumber,int Floor,double Price) {
         this.RoomNumber = RoomNumber;
         this.Floor = Floor;
         this.Price = Price;
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
