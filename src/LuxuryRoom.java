public class LuxuryRoom extends Room {
    private String FoolService;

    public LuxuryRoom() {}

    public LuxuryRoom(String RoomName,int RoomNumber,int Floor,double Price,boolean AvailableRoom,String FoodService) {
        super(RoomName,RoomNumber,Floor,Price,AvailableRoom);
        this.FoolService = FoodService;
    }

}
