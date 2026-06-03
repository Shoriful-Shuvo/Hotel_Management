public abstract class Room {
    private String roomNumber;
    private int floorLevel;
    private double costPerNight;
    private boolean available;
    public Room() {}
    public Room(String roomNumber, int floorLevel, double costPerNight, boolean available) throws InvalidRoomException {
        if (roomNumber == null || roomNumber.trim().isEmpty())
            throw new InvalidRoomException("Room number cannot be empty.");
        if (floorLevel < 0)
            throw new InvalidRoomException("Floor level cannot be negative.");
        if (costPerNight < 0)
            throw new InvalidRoomException("Cost per night cannot be negative.");
        this.roomNumber = roomNumber;
        this.floorLevel = floorLevel;
        this.costPerNight = costPerNight;
        this.available = available;
    }
    public String getRoomNumber() { return roomNumber; }
    public int getFloorLevel() { return floorLevel; }
    public double getCostPerNight() { return costPerNight; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public abstract String getRoomType();
    public abstract int getMaxOccupancy();
    public void reserveRoom() { this.available = false; System.out.println("Room " + roomNumber + " reserved."); }
    public void cancelReservation() { this.available = true; System.out.println("Room " + roomNumber + " reservation cancelled."); }
    public void showRoomInformation() {
        System.out.println("Room Number  : " + roomNumber);
        System.out.println("Floor        : " + floorLevel);
        System.out.println("Price/Night  : " + costPerNight);
        System.out.println("Available    : " + available);
        System.out.println("Room Type    : " + getRoomType());
        System.out.println("Max Occupancy: " + getMaxOccupancy());
    }
}
