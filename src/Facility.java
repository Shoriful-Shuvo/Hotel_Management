public abstract class Facility {

    private String FacilityName;
    private double Fee;
    public Facility() {}

    public String getFacilityName() {
        return FacilityName;
    }
    public double getFee() {
        return Fee;
    }
    public void setFacilityName(String FacilityName) {
        this.FacilityName = FacilityName;
    }
    public void setFee(double Fee) {
        this.Fee = Fee;
    }
    public abstract void Facility();

    public void showFacilityInformation() {
        System.out.println("Facility  Name: " + FacilityName);
        System.out.println("Fee:  " + Fee);
    }
}
