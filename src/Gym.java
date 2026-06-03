public class Gym extends Facility {
    public Gym() {
        try { setFacilityName("Gym"); setFee(500.0); }
        catch (InvalidFacilityException e) { System.out.println("Gym setup error: " + e.getMessage()); }
    }
    @Override public void Facility() { System.out.println("Facility Type: Gym"); }
}
