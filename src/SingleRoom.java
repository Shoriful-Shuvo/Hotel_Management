public class SingleRoom extends Room{
    private boolean hasStudyTable;
    private boolean hasSingleBed;
    private boolean hasTv;

    public SingleRoom(String roomNumber,int floorLevel,double costPerNight,boolean hasStudyTable,boolean hasSingleBed,boolean hasTv) {
        super(roomNumber,floorLevel,costPerNight,true);
        this.hasStudyTable = hasStudyTable;
        this.hasSingleBed = hasSingleBed;
        this.hasTv = hasTv;
    }

    @Override
    public String getRoomType() {
        return "Single room";
    }
    @Override
    public int getMaxOccupancy() {
        return 1;
    }
    @Override
    public void ShowRoomInformation() {
        super.ShowRoomInformation();
        System.out.println("Study Table: "+hasStudyTable);
        System.out.println("Bed: "+hasSingleBed);
        System.out.println("Tv: "+hasTv);
    }
}
