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

    public void setFacilityName(String FacilityName) throws InvalidFacilityException {
        if (FacilityName == null || FacilityName.trim().isEmpty()) {
            throw new InvalidFacilityException("Facility name cannot be empty.");
        }
        this.FacilityName = FacilityName;
    }

    public void setFee(double Fee) throws InvalidFacilityException {
        if (Fee < 0) {
            throw new InvalidFacilityException("Fee cannot be negative.");
        }
        this.Fee = Fee;
    }

    public abstract void Facility();

    public void showFacilityInformation() {
        System.out.println("Facility Name: " + FacilityName);
        System.out.println("Fee: " + Fee);
    }
}
