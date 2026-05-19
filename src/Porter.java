public class Porter extends Employee {
    Porter(String employeeName,int  employeeId, double employeeSalary){
        super(employeeName,employeeId,employeeSalary,"Porter");
    }

    Porter(String employeeName,int  employeeId){
        super(employeeName,employeeId);
    }
    Porter(String employeeName){
        super(employeeName);
    }
    Porter(){
        setEmployeeRole("Porter");
    }

    @Override
    public void Work() {
        System.out.println("pick up the Bag");
    }
    @Override
    public void ShowEmployeeDetails(){
        System.out.println("Name : " + this.getEmployeeName() + "\nRole : " +getEmployeeRole()+ "\nId : " +getEmployeeId() +"\nSalary : "+getEmployeeSalary() );
        Work();
    }
}