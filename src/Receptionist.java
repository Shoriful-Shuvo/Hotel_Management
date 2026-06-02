import java.util.ArrayList;

public class Receptionist extends Employee {

    private ArrayList<Guest> guestList = new ArrayList<>();

    Receptionist(String employeeName, int employeeId, double employeeSalary) {
        super(employeeName, employeeId, employeeSalary, "Receptionist");
    }
    Receptionist(String employeeName, int employeeId) { super(employeeName, employeeId); }
    Receptionist(String employeeName) { super(employeeName); }
    Receptionist() { setEmployeeRole("Receptionist"); }

    @Override
    public void Work() {
        System.out.println("Hello sir, how can I help you?");
    }

    public void addVipGuest(int guestID, String guestName, long phoneNumber, String butlerName)
            throws GuestException {
        if (guestName == null || guestName.isBlank())
            throw new GuestException("Guest name cannot be empty.");
        Guest guest = new Vip(guestID, guestName, phoneNumber, butlerName);
        guestList.add(guest);
        System.out.println("VIP Guest added: " + guestName);
    }

    public void addBusinessGuest(int guestID, String guestName, long phoneNumber, String companyName)
            throws GuestException {
        if (guestName == null || guestName.isBlank())
            throw new GuestException("Guest name cannot be empty.");
        Guest guest = new Business(guestID, guestName, phoneNumber, companyName);
        guestList.add(guest);
        System.out.println("Business Guest added: " + guestName);
    }

    public void removeGuest(int guestID) throws GuestException {
        Guest found = findGuest(guestID);
        guestList.remove(found);
        System.out.println("Guest removed: " + found.getGuestName());
    }

    public void checkInGuest(int guestID, int roomNumber) throws GuestException {
        Guest guest = findGuest(guestID);
        guest.assignRoom(roomNumber);
        guest.checkIn();
        System.out.println(guest.getGuestName() + " checked into room " + roomNumber);
    }

    public void checkOutGuest(int guestID) throws GuestException {
        Guest guest = findGuest(guestID);
        guest.checkOut();
        System.out.println(guest.getGuestName() + " checked out.");
    }

    public void seeGuestDetails(int guestID) throws GuestException {
        Guest guest = findGuest(guestID);
        guest.showGuestInfo();
    }

    public void showAllGuests() {
        if (guestList.isEmpty()) {
            System.out.println("No guests registered.");
            return;
        }
        for (Guest g : guestList) {
            g.showGuestInfo();
            System.out.println("----");
        }
    }

    public ArrayList<Guest> getGuestList() {
        return guestList;
    }

    private Guest findGuest(int guestID) throws GuestException {
        for (Guest g : guestList)
            if (g.getGuestID() == guestID) return g;
        throw new GuestException("Guest with ID " + guestID + " not found.");
    }

    @Override
    public void ShowEmployeeDetails() {
        System.out.println("Name   : " + getEmployeeName()
                + "\nRole   : " + getEmployeeRole()
                + "\nId     : " + getEmployeeId()
                + "\nSalary : " + getEmployeeSalary());
        Work();
    }
}
