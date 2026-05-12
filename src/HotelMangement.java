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



}
