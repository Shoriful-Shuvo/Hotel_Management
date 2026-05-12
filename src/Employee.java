import java.util.Scanner;

abstract class Employee  {

    private  String employeeRole;
    private int ID;
    private String Name;
    private int PhoneNumber;


    public Employee (int ID,String Name,int PhoneNumber,String employeeRole){

    }

    public abstract void  setWorkSummary( String EmployeeWorkSummary);


    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }


}
