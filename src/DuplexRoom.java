public class DuplexRoom extends Room{
    private int numberOfLevels;
    private boolean hasLivingArea;

    public DuplexRoom(String roomNumber,int floorLevel,double costPerNight,int numberOfLevels,boolean hasLivingArea){
       super(roomNumber,floorLevel,costPerNight,true);
       this.hasLivingArea = hasLivingArea;
       this.numberOfLevels = numberOfLevels;
    }
    @Override
    public String getRoomType() {
        return "Duplex room";
    }
    @Override
    public int getMaxOccupancy() {
        return 3;
    }
    @Override
    public void ShowRoomInformation (){
        super.ShowRoomInformation();
        System.out.println("Levels: "+numberOfLevels);
        System.out.println("Living Area: "+hasLivingArea);
    }

}
