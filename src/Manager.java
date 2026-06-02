public class Manager extends Employee {

    Manager(String employeeName,int  employeeId, double employeeSalary){
        super(employeeName,employeeId,employeeSalary,"Manager");
        //setTotalEmployee(getTotalEmployee()+1);
    }

    Manager(String employeeName,int  employeeId){
        super(employeeName,employeeId);
    }
    Manager(String employeeName){
        super(employeeName);
    }
    Manager(){
        setEmployeeRole("Manager");
    }
    public void addEmployee(String employeeName,int  employeeId,double employeeSalary,String employeeRole){
        //Employee employee =   addEmployees(employeeName,employeeId,employeeSalary,employeeRole);
//        return this;

    }

    public void removeEmployee(Employee[] employees, int index){
        if (employees == null)
            throw new IllegalArgumentException("Employee array is null.");
        if (index < 0 || index >= employees.length)
            throw new ArrayIndexOutOfBoundsException("Invalid employee index: " + index);
        employees[index]=null;
    }


    public  void  UpdateEmployeeRole(String employeeRole){
        this.setEmployeeName(employeeRole);
    }


    public void UpdateEmployeeSalary(double employeeSalary) {
        this.setEmployeeSalary(employeeSalary);
    }
    @Override
    public void ShowEmployeeDetails(){
        System.out.println("Name : " + this.getEmployeeName() + "\nRole : " +getEmployeeRole()+ "\nId : " +getEmployeeId() +"\nSalary : "+getEmployeeSalary() );
        Work();
    }

    @Override
    public void Work(){
        System.out.println("Managing the Hotel");
    }



}
