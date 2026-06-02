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

        // 1. Catch errors when creating employees
        Employee[] employee = new Employee[8];
        try {
            employee[0] = new Manager("shuvo", 101, 80000);
            employee[1] = new Receptionist("rifat", 102, 40000);
            employee[2] = new Receptionist("mubin", 103, 40000);
            employee[3] = new Attendant("ahad", 104, 30000);
            employee[4] = new Attendant("rahid", 105, 30000);
            employee[5] = new Porter("Rafi", 106, 25000);
            employee[6] = new Porter("Hasan", 107, 25000);
            employee[7] = new Porter("akash", 108, 25000);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating employee: " + e.getMessage());
        }

        // 2. Catch errors when showing the list
        try {
            HotelManagement.show(employee);
        } catch (IllegalArgumentException e) {
            System.out.println("Cannot show list: " + e.getMessage());
        }

        // 3. Catch errors when removing an employee
        Manager manager = (Manager) employee[0];
        try {
            manager.removeEmployee(employee, 1);  // remove index 1
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Remove failed: " + e.getMessage());
        }

        // 4. Catch errors when a receptionist adds a guest
        Receptionist receptionist = (Receptionist) employee[2];
        try {
            receptionist.addGuest("Bashir", 12345, "5 Star", "VIP", 201);
        } catch (IllegalArgumentException e) {
            System.out.println("Cannot add guest: " + e.getMessage());
        }

        // Show updated list
        try {
            HotelManagement.show(employee);
        } catch (IllegalArgumentException e) {
            System.out.println("Cannot show list: " + e.getMessage());
        }
    }
}