public class LuxuryRoom extends Room {
    private String FoolService;

    public LuxuryRoom() {}

    public LuxuryRoom(String RoomNumber,int floorLevel,double costPerNight,String FoodService) {
        super(RoomNumber,floorLevel,costPerNight,true);
        this.FoolService = FoodService;
    }


}
