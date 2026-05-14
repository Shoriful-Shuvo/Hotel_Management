public class DuplexRoom extends Room{
    private int numberOfLevels;
    private boolean hasLivingArea;

    public DuplexRoom(String roomNumber,int floorLevel,double costPerNight,int numberOfLevels,boolean hasLivingArea){
       super(roomNumber,floorLevel,costPerNight,true);
       this.hasLivingArea = hasLivingArea;
       this.numberOfLevels = numberOfLevels;
    }


}
