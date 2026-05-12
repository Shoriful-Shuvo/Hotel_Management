public class Attendant extends Employee{
    private  String EmployeeWorkSummary;

    Attendant(int ID,String Name,int PhoneNumber,String employeeRole){
        super(ID,Name,PhoneNumber,employeeRole);
    }

    @Override
    public void setWorkSummary( String  EmployeeWorkSummary){
        this.EmployeeWorkSummary = EmployeeWorkSummary;

    }

    public String getEmployeeWorkSummary() {
        return EmployeeWorkSummary;
    }
    public void Welcome(){

    }

}
