public class LuxuryRoom extends Room {
    private boolean hasFridge;
    private boolean hasSmartTv;
    private String bedType;

    public LuxuryRoom(String RoomNumber,int floorLevel,double costPerNight,boolean hasFridge,boolean hasSmartTv,String bedType) {
        super(RoomNumber,floorLevel,costPerNight,true);
        this.hasFridge = hasFridge;
        this.hasSmartTv = hasSmartTv;
        this.bedType = bedType;

    }


}
