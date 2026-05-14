public abstract class Room {
    private String roomNumber;
    private int floorLevel;
    private double costPerNight;
    private boolean available;

    public Room() {}

    public Room (String roomNumber,int floorLevel,double costPerNight,boolean available) {
         this.roomNumber = roomNumber;
         this.floorLevel = floorLevel;
         this.costPerNight = costPerNight;
         this.available = available;
    }
    public String getRoomNumber() {
        return roomNumber;
    }

    public int getFloorLevel() {
        return floorLevel;
    }
    public double getCostPerNight() {
        return costPerNight;
    }
    public boolean isAvailable () {
        return available;
    }

    public void setAvailable (boolean available) {
        this.available = available;
    }
    public abstract String getRoomType();

    public abstract int getMaxOccupancy ();

    public void reserveRoom() {
        available = false;
        System.out.println("Room Reserved");
    }
    public void cancelReservation() {
        available = true;
        System.out.println("Reservation Cancelled");
    }

    public void ShowRoomInformation() {
        System.out.println("Room Number: " +roomNumber);
        System.out.println("Floor: " +floorLevel);
        System.out.println("Price: " +costPerNight);
        System.out.println("Available: "+available);
        System.out.println("RoomType: "+getRoomType());
        System.out.println("RoomCapacity: "+getMaxOccupancy());
    }
}