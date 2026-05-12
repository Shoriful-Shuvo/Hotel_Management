public class Manager extends Employee {


    Manager(int ID,String Name,int PhoneNumber){
        super(ID,Name,PhoneNumber);
    }

    private  String EmployeeWorkSummary;

    @Override
    public void setWorkSummary( String  EmployeeWorkSummary){
        this.EmployeeWorkSummary =EmployeeWorkSummary;

    }
    public String  WorkSummary(){
        return EmployeeWorkSummary;
    }


}
