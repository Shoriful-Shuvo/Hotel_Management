public class DuplexRoom extends Room{
    private int numberOfLevels;
    private boolean hasLivingArea;

    public DuplexRoom(String roomNumber,int floorLevel,double costPerNight,int numberOfLevels,boolean hasLivingArea) throws InvalidRoomException {
       super(roomNumber,floorLevel,costPerNight,true);

        if(numberOfLevels <= 0) {
            throw new InvalidRoomException("Number of levels must be greater than 0.");
        }
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
    public void showRoomInformation (){
        super.showRoomInformation();
        System.out.println("Levels: "+numberOfLevels);
        System.out.println("Living Area: "+hasLivingArea);
    }

}
