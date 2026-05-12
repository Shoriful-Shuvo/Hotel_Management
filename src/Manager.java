public class Manager extends Employee {


    Manager(int ID,String Name,int PhoneNumber,String employeeRole){
        super(ID,Name,PhoneNumber,employeeRole);
    }

    private  String EmployeeWorkSummary;

    @Override
    public void setWorkSummary( String  EmployeeWorkSummary){
        this.EmployeeWorkSummary =EmployeeWorkSummary;

    }
    public String  WorkSummary(){
        return EmployeeWorkSummary;
    }
    public void addEmployee(){

    }
    public void removeEmployee(){

    }


}
