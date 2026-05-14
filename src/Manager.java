public class Manager extends Employee {

    Manager(String employeeName,int  employeeId, double employeeSalary,String employeeRole){
        super(employeeName,employeeId,employeeSalary,employeeRole);
    }
    Manager(String employeeName,int  employeeId, double employeeSalary){
        super(employeeName,employeeId,employeeSalary);
    }

    Manager(String employeeName,int  employeeId){
        super(employeeName,employeeId);
    }
    Manager(String employeeName){
        super(employeeName);
    }
    Manager(){

    }
    @Override
    public void addEmployee(String employeeName,int  employeeId,double employeeSalary,String employeeRole){
        setEmployeeName(employeeName);
        setEmployeeId(employeeId);
        setEmployeeSalary(employeeSalary);
        setEmployeeRole(employeeRole);

    }
    @Override
    public void removeEmployee(String employeeName,int  employeeId,double employeeSalary,String employeeRole){
        if (employeeId == this.getEmployeeId() ){
            this.setEmployeeName("Null");
            this.setEmployeeId(0);
            this.setEmployeeSalary(0);
            this.setEmployeeRole("Null");
        }
    }

    @Override
    public  void  UpdateEmployeeRole(String employeeRole){
        this.setEmployeeName(employeeRole);
    }

    @Override
    public void UpdateEmployeeSalary(double employeeSalary) {
        this.setEmployeeSalary(employeeSalary);
    }
    public void ShowEmployeeDetails(){
        System.out.println("Name : " + this.getEmployeeName() + "Role : " +getEmployeeRole()+ "Id : " +getEmployeeId() +"Salary : "+getEmployeeSalary() );
    }


}
