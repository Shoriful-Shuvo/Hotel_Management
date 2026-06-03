public class Business extends Guest {

    private String companyName;

    public Business(int guestID, String guestName,
                    long phoneNumber, String companyName)
            throws GuestException {

        super(guestID, guestName, phoneNumber);

        if (companyName == null || companyName.isEmpty())
            throw new GuestException("Company name required");

        this.companyName = companyName;
    }

    @Override
    public void rest() {
        System.out.println(getGuestName()
                + " is resting before a meeting.");
    }

    @Override
    public void showGuestInfo() {
        super.showGuestInfo();
        System.out.println("Company: " + companyName);
    }
}