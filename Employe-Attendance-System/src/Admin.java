import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    public void addEmployee(Employee employee) {
        Database.addEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        Database.updateEmployee(employee);
    }

    public void removeEmployee(String employeeId) {
        Database.removeEmployee(employeeId);
    }

    public Employee searchForEmployee(String employeeId) {
        return Database.searchForEmployee(employeeId);
    }

    public void viewEmployeeReports() {
        List<Employee> employees = Database.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println("Name: " + employee.getName() + "\n" +
                    "ID: " + employee.getId() + "\n" +
                    "Age: " + employee.getAge() + "\n" +
                    "Gender: " + employee.getGender() + "\n" +
                    "Phone Number: " + employee.getPhoneNumber() + "\n" +
                    "Address: " + employee.getAddress() + "\n" +
                    "------------------------------------------");

        }
    }

    public void viewLeaveApplications() {
        List<Leave> leaves = Database.getLeaveApplications();
        Scanner get = new Scanner(System.in);
        for (Leave leave : leaves) {
            System.out.println(leave);
            System.out.println("Enter 0 to accept and 1 to reject: ");
            int status = get.nextInt();
            if(status == 0) {
                approveOrRejectLeave(leave.getEmployeeId(), leave.getStartDate(), "Accepted");
            } else {
                approveOrRejectLeave(leave.getEmployeeId(), leave.getStartDate(), "Rejected");
            }
        }
    }

    public void approveOrRejectLeave(String employeeId, String startDate, String status) {
        Database.updateLeaveStatus(employeeId, startDate, status);
    }


    public void viewResignations() {
        Stack<String> resignations = Database.resignations;
        List<Employee> employees = Database.getAllEmployees();

        Scanner get = new Scanner(System.in);
        for (Employee employee : employees) {
            for (int i = 0; i < resignations.size(); i++) {
                if (employee.getId().equals(resignations.pop())) {
                    System.out.println("Employee " + employee.getName() + " have applied for resignation!");
                    System.out.println("Enter 0 to accept, 1 to reject");
                    int check = get.nextInt();
                    if (check == 0) {
                        System.out.println("Resignation accepted");
                        Database.removeEmployee(employee.getId());
                    } else {
                        System.out.println("Resignation not accepted");
                    }
                }
            }
        }

    }
}
