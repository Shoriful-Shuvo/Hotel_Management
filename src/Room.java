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

    public abstract void roomType();

    public void ShowRoomInformation() {
        System.out.println("Room Number: " +RoomNumber);
        System.out.println("Floor: " +Floor);
        System.out.println("Price: " +Price);
        System.out.println("AvailableRoom: "+AvailableRoom);
    }
}
