public abstract class Guest {
    private int guestID;
    private String guestName;
    private long phoneNumber;
    private int roomNumber;
    private boolean checkedIn;

    public Guest(int guestID, String guestName, long phoneNumber)
            throws GuestException {

        if (guestID <= 0)
            throw new GuestException("Invalid Guest ID");

        if (guestName == null || guestName.isEmpty())
            throw new GuestException("Guest name cannot be empty");

        this.guestID = guestID;
        this.guestName = guestName;
        this.phoneNumber = phoneNumber;
        this.checkedIn = false;
    }

    public int getGuestID() {
        return guestID;
    }

    public String getGuestName() {
        return guestName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void assignRoom(int roomNumber) throws GuestException {
        if (roomNumber <= 0)
            throw new GuestException("Invalid room number");

        this.roomNumber = roomNumber;
    }

    public void checkIn() throws GuestException {
        if (roomNumber == 0)
            throw new GuestException("Room not assigned");

        checkedIn = true;
    }

    public void checkOut() throws GuestException {
        if (!checkedIn)
            throw new GuestException("Guest is not checked in");

        checkedIn = false;
    }

    public void showGuestInfo() {
        System.out.println("ID: " + guestID);
        System.out.println("Name: " + guestName);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Room: " + roomNumber);
    }

    public abstract void rest();
}
