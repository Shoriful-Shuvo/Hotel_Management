public class Guest {
    private static int totalGuest;
    {
        totalGuest++;
    }
    private int guesrNid;
    private String guestName;
    private String guestCategory;
    private String guestReview;
    private int guestInRoom;
    Guest (String guestName , int guesrNid,String guestReview,String guestCategory,int guestInRoom){
        this.guestName = guestName;
        this.guesrNid  = guesrNid;
        this.guestReview  = guestReview;
        this.guestCategory  = guestCategory;
        this.guestInRoom =guestInRoom;
    }
    Guest (String guestName , int guesrNid,String guestReview,String guestCategory){
        this(guestName,guesrNid,guestReview,"Guest",0);
    }
    Guest (String guestName , int guesrNid,String guestReview){
        this(guestName,guesrNid,guestReview,"Guest",0);
    }

    Guest (String guestName , int guesrNid){
        this(guestName,guesrNid,"5 Star","Guest",0);
    }
    Guest (String guestName ){
        this(guestName,0,"5 Star","Guest",0);
    }
    Guest (){
        this("Guest Name",0,"5 Star","Guest",0);
    }

    public static int getTotalGuest() {
        return totalGuest;
    }

    public int getGuesrNid() {
        return guesrNid;
    }

    public void setGuesrNid(int guesrNid) {
        this.guesrNid = guesrNid;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestCategory() {
        return guestCategory;
    }

    public void setGuestCategory(String guestCategory) {
        this.guestCategory = guestCategory;
    }

    public int getGuestInRoom() {
        return guestInRoom;
    }

    public void setGuestInRoom(int guestInRoom) {
        this.guestInRoom = guestInRoom;
    }

    public String getGuestReview() {
        return guestReview;
    }

    public void setGuestReview(String guestReview) {
        this.guestReview = guestReview;
    }
}
