public class LuxuryRoom extends Room {
    private boolean hasFridge;
    private boolean hasSmartTv;
    private String bedType;

    public LuxuryRoom(String RoomNumber,int floorLevel,double costPerNight,boolean hasFridge,boolean hasSmartTv,String bedType) throws InvalidRoomException {
        super(RoomNumber,floorLevel,costPerNight,true);
        if(bedType == null || bedType.trim().isEmpty()) {
            throw new InvalidRoomException("Bed type cannot be empty.");
        }
        this.hasFridge = hasFridge;
        this.hasSmartTv = hasSmartTv;
        this.bedType = bedType;

    }
    @Override
    public String getRoomType() {
        return "Luxury room";
    }
    @Override
    public int getMaxOccupancy (){
        return 2;

    }
    @Override
    public void showRoomInformation() {
        super.showRoomInformation();
        System.out.println("Fridge: "+hasFridge);
        System.out.println("SmartTv: "+hasSmartTv);
        System.out.println("BedType: "+bedType);
    }
}
