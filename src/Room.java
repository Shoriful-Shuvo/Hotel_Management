public abstract class Room {
    private String roomName;
    private int roomNumber;
    private int floorLevel;
    private double cost;
    private boolean availableRoom;

    public Room() {}

    public Room (String roomName,int roomNumber,int floorLevel,double cost,boolean availableRoom) {
         this.roomName = roomName;
         this.roomNumber = roomNumber;
         this.floorLevel = floorLevel;
         this.cost= cost;
         this.availableRoom = availableRoom;
    }
    public String getRoomName() {
        return roomName;
    }
    public int getRoomNumber() {
        return roomNumber;
    }

    public int getFloorLevel() {
        return floorLevel;
    }
    public double getCost() {
        return cost;
    }
    public boolean getAvailableRoom () {
        return availableRoom;
    }
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    public void setCost(double cost) {
        this.cost = cost;

    }
    public void setAvailableRoom (boolean availableRoom) {
        this.availableRoom = availableRoom;
    }
    public abstract void roomType();

    public void ShowRoomInformation() {
        System.out.println("Room Name: " +roomName);
        System.out.println("Room Number: " +roomNumber);
        System.out.println("Floor: " +floorLevel);
        System.out.println("Price: " +cost);
        System.out.println("AvailableRoom: "+availableRoom);
    }
}