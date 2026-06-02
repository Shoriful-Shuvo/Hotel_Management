public class Vip extends Guest {

    private String butlerName;

    public Vip(int guestID, String guestName,
               long phoneNumber, String butlerName)
            throws GuestException {

        super(guestID, guestName, phoneNumber);

        if (butlerName == null || butlerName.isEmpty())
            throw new GuestException("Butler name required");

        this.butlerName = butlerName;
    }

    @Override
    public void rest() {
        System.out.println(getGuestName()
                + " is resting in a VIP suite.");
    }

    @Override
    public void showGuestInfo() {
        super.showGuestInfo();
        System.out.println("Butler: " + butlerName);
    }
}