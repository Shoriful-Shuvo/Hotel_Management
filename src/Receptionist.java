public class Receptionist extends Employee{
    Receptionist(String employeeName,int  employeeId, double employeeSalary){
        super(employeeName,employeeId,employeeSalary,"Receptionist");
    }

    Receptionist(String employeeName,int  employeeId){
        super(employeeName,employeeId);
    }
    Receptionist(String employeeName){
        super(employeeName);
    }
    Receptionist(){
        setEmployeeRole("Receptionist");
    }
    @Override
    public void Work() {
        System.out.println("hello sir How can i help you");
    }

    public void addGuest(){
        Guest guestOne = new Guest();
    }
    public void addGuest(String guestName) {
        if (guestName == null || guestName.isBlank())
            throw new IllegalArgumentException("Guest name cannot be empty.");
        Guest guestOne = new Guest(guestName);
    }
    public void addGuest(String guestName,int guesrNid){
        Guest guestOne = new Guest(guestName,guesrNid);

    }
    public void addGuest(String guestName,int guesrNid,String guestReview){
        Guest guestOne = new Guest(guestName,guesrNid,guestReview);

    }
    public void addGuest(String guestName,int guesrNid,String guestReview,String guestCategory){
        Guest guestOne = new Guest(guestName,guesrNid,guestReview,guestCategory);

    }

    public void addGuest(String guestName,int guesrNid,String guestCategory,String guestReview,int guestInRoom){
        Guest guestOne = new Guest(guestName,guesrNid,guestCategory,guestReview,guestInRoom);
    }
    // push 1
    public void Removeguest(Guest guest){
        guest =null;
    }
    // push 1
    public void SeeGuestDetails(Guest guest){
        if (guest == null)
            throw new IllegalArgumentException("Guest cannot be null.");
        System.out.println("Guest Name : " + guest.getGuestName() + "\nGuest Nid : " +guest.getGuesrNid()+"\nGuest Review : " +"\nGuest Review : " + guest.getGuestReview()+ "\nGuest Category : "+ guest.getGuestCategory()+"\nGuest In Room No :" + guest.getGuestInRoom());
    }
    @Override
    public void ShowEmployeeDetails(){
        System.out.println("Name : " + this.getEmployeeName() + "\nRole : " +getEmployeeRole()+ "\nId : " +getEmployeeId() +"\nSalary : "+getEmployeeSalary() );
        Work();
    }
}
