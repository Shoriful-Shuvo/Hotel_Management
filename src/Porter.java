public class Porter extends Employee{
    private  String EmployeeWorkSummary;


    Porter(int ID,String Name,int PhoneNumber,String employeeRole){
        super(ID,Name,PhoneNumber,employeeRole);
    }
    @Override
    public void setWorkSummary( String  EmployeeWorkSummary){
        this.EmployeeWorkSummary = EmployeeWorkSummary;

    }
    public String  WorkSummary(){
        return EmployeeWorkSummary;
    }
    public String laguageCarry(boolean answer){
        if (answer){
            return "Good Work.place it in the room";
        }
        else {
            return "Do it Quickly";
        }
    }
}
