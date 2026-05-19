public  class HotelManagement {
    public static void show(Employee [] employees){
        System.out.println();
        System.out.println("Hotel Management Employee Numbers : "+Employee.getTotalEmployee());
        System.out.println();
        for (int i =0; i<8;i++){
            if (i==0){
                System.out.println("=========================================");
                System.out.println();
                System.out.println("              Employee List");
                System.out.println();
                System.out.println("=========================================");
                System.out.println();
            }
            employees[i].ShowEmployeeDetails();
            System.out.println();
            System.out.println("====================");
            System.out.println();
        }


    }
    public static void main(String[] args) {
        Employee [] employee = {new Manager()
                ,new Receptionist()
                ,new Receptionist()
                ,new Attendant()
                ,new Attendant()
                ,new Porter()
                ,new Porter()
                ,new Porter()
        };
        HotelManagement.show(employee);
          Manager manager = (Manager) employee[0];
          //manager.addEmployee("Shoriful",202,500000,"CEO");

          manager.removeEmployee(employee[1]);
        HotelManagement.show(employee);


    }
}