public class SwimmingPool extends Facility {
    public SwimmingPool() {
        try { setFacilityName("Swimming Pool"); setFee(300.0); }
        catch (InvalidFacilityException e) { System.out.println("SwimmingPool setup error: " + e.getMessage()); }
    }
    @Override public void Facility() { System.out.println("Facility Type: Swimming Pool"); }
}
