abstract class Employee  {
    private static int totalEmployee;
    {
        totalEmployee++;
    }
   private String employeeName;
   private  int  employeeId;
   private  double employeeSalary;
   private  String employeeRole;

    public abstract void ShowEmployeeDetails();

    Employee(){
        this("Null");
    }
    Employee(String employeeName){
        this(employeeName, 0);
    }
    Employee(String employeeName, int  employeeId){
        this(employeeName, employeeId,0.0);
    }

   Employee(String employeeName,int  employeeId,double employeeSalary){
       this(employeeName,employeeId,employeeSalary,"Employee");
   }
    Employee(String employeeName,int  employeeId,double employeeSalary,String employeeRole){
        this.employeeName =employeeName;
        this.employeeId =employeeId;
        this.employeeSalary =employeeSalary;
        this.employeeRole =employeeRole;
    }
//    public void addEmployees(String employeeName,int  employeeId,double employeeSalary,String employeeRole){
//        this.employeeName =employeeName;
//        this.employeeId =employeeId;
//        this.employeeSalary =employeeSalary;
//        this.employeeRole =employeeRole;
//    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public static int getTotalEmployee() {
        return totalEmployee;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public static void setTotalEmployee(int totalEmployee) {
        Employee.totalEmployee = totalEmployee;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
    public abstract void Work();

}
