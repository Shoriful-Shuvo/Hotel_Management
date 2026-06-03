public class Attendant extends Employee{
    Attendant(String employeeName, int  employeeId, double employeeSalary){
        super(employeeName,employeeId,employeeSalary,"Attendant");
    }

    Attendant(String employeeName,int  employeeId){
        super(employeeName,employeeId);
    }
    Attendant(String employeeName){
        super(employeeName);
    }
    Attendant(){
        setEmployeeRole("Attendant");
    }

    @Override
    public void Work() {
        System.out.println("Welcome everyone");
    }
    @Override
    public void ShowEmployeeDetails(){
        System.out.println("Name : " + this.getEmployeeName() + "\nRole : " +getEmployeeRole()+ "\nId : " +getEmployeeId() +"\nSalary : "+getEmployeeSalary() );
        Work();
    }
}
