public abstract class HotelMangement {
    private String ID;
    private String Name;
    private String PhoneNumber;

    public HotelMangement(String ID, String Name, String PhoneNumber){
        this.ID=ID;
        this.Name=Name;
        this.PhoneNumber=PhoneNumber;
    }

    public abstract String getSummary();
    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
}
