public abstract class Room {
    private String RoomName;
    private int RoomNumber;
    private int Floor;
    private double Price;
    private boolean AvailableRoom;

    public Room() {}

    public Room (String RoomName,int RoomNumber,int Floor,double Price,boolean AvailableRoom) {
         this.RoomName = RoomName;
         this.RoomNumber = RoomNumber;
         this.Floor = Floor;
         this.Price = Price;
         this.AvailableRoom = AvailableRoom;
    }
    public String getRoomName() {
        return RoomName;
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
    public void setRoomName(String RoomName) {
        this.RoomName = RoomName;
    }
    public void setPrice(double Price) {
        this.Price = Price;

    }
    public void setAvailableRoom (boolean AvailableRoom) {
        this.AvailableRoom = AvailableRoom;
    }
    public abstract void roomType();

    public void ShowRoomInformation() {
        System.out.println("Room Name: " +RoomName);
        System.out.println("Room Number: " +RoomNumber);
        System.out.println("Floor: " +Floor);
        System.out.println("Price: " +Price);
        System.out.println("AvailableRoom: "+AvailableRoom);
    }
}
