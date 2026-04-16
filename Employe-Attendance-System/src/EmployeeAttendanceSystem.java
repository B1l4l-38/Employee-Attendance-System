
import java.time.*;
import java.time.format.*;
import java.util.*;

public class EmployeeAttendanceSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Admin admin = new Admin("admin", "admin123"); // Example admin account
    private static List<AttendanceRecord> attendanceRecords = new ArrayList<>();



    public static void markAttendance(Employee employee) {
        String employeeId = employee.getId();
        System.out.println("Enter today's date in yyyy-MM-dd format");
        String currentDate = scanner.nextLine();
        System.out.println("Enter current time in HH:MM format");
        String currentTime = scanner.nextLine();

        for (AttendanceRecord record : attendanceRecords) {
            if (record.getEmployeeId().equals(employeeId) && record.getDate().equals(currentDate)) {
                if (record.getTimeOut() == null) {
                    record.setTimeOut(currentTime);
                    System.out.println("Marked out attendance for employee: " + employeeId);
                    Database.recordAttendance(record);
                } else {
                    AttendanceRecord newRecord = new AttendanceRecord(employeeId, currentDate, currentTime);
                    attendanceRecords.add(newRecord);
                    System.out.println("Marked in attendance for employee: " + employeeId);
                }
                return;
            }
        }
        AttendanceRecord newRecord = new AttendanceRecord(employeeId, currentDate, currentTime);
        attendanceRecords.add(newRecord);
        System.out.println("Marked in attendance for employee: " + employeeId);
        // System.out.println(newRecord);
        // attendanceRecords.add()
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Employee Attendance System");
        while (true) {
            System.out.println("\n1. Login as Admin\n2. Login as Employee\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    loginAdmin();
                    break;
                case 2:
                    loginEmployee();
                    break;
                case 3:
                    System.out.println("Exiting system.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void loginAdmin() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (admin.login(username, password)) {
            System.out.println("Admin login successful.");
            adminMenu();
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void loginEmployee() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        Employee employee = Database.checkEmployeeValidation(username, password);
        if (employee != null) {
            System.out.println("Employee login successful.");
            employeeMenu(employee);
        } else {
            System.out.println("Username/password incorrect or employee does not exist.");
        }
    }

    private static void adminMenu() {
        boolean run = true;
        while (run) {
            System.out.println("\nAdmin Menu");
            System.out.println("1. Add an Employee\n2. Remove an Employee\n3. Update an Employee\n4. View Employee Reports\n5. View Leave Applications\n6. View Resignations\n7. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter Employee Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter Employee Password: ");
                    String pass = scanner.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter Employee ID: ");
                    String id = scanner.next();
                    System.out.print("Enter Employee Gender: ");
                    String gender = scanner.next();
                    System.out.print("Enter Employee Phone Number: ");
                    String phoneNumber = scanner.next();
                    System.out.print("Enter Employee Address: ");
                    String address = scanner.next();
                    
                    admin.addEmployee(new Employee(username, pass, name, age, id, gender, phoneNumber, address));
                    break;
                case 2:
                    System.out.print("Enter Employee ID: ");
                    String id2 = scanner.nextLine();
                    admin.removeEmployee(id2);
                    break;
                case 3:
                    System.out.print("Enter Employee ID you want to update: ");
                    String id3 = scanner.nextLine();
                    System.out.print("Enter Employee Username: ");
                    String username3 = scanner.nextLine();
                    System.out.print("Enter Employee Password: ");
                    String pass3 = scanner.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name3 = scanner.nextLine();
                    System.out.print("Enter Employee Age: ");
                    int age3 = scanner.nextInt();
                    System.out.print("Enter Employee Gender: ");
                    String gender3 = scanner.next();
                    System.out.print("Enter Employee Phone Number: ");
                    String phoneNumber3 = scanner.next();
                    System.out.print("Enter Employee Address: ");
                    String address3 = scanner.next();
                    
                    admin.updateEmployee(new Employee(username3, pass3, name3, age3, id3, gender3, phoneNumber3, address3));
                    break;
                case 4:
                    admin.viewEmployeeReports();
                    break;
                case 5:
                    admin.viewLeaveApplications();
                    break;
                case 6:
                    admin.viewResignations();
                    break;
                case 7:
                    run = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }


    private static void employeeMenu(Employee employee) {
        boolean run = true;
        while (run) {
            System.out.println("\nEmployee Menu");
            System.out.println("1. Mark Check-In Attendance\n2. Mark Check-Out Attendance\n3. View Weekly Attendance\n4. Apply for Leave\n5. Apply for Resignation\n6. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    markAttendance(employee);
                    break;
                case 2:
                    markAttendance(employee);
                    //Database.recordAttendance(attendanceRecords.get(attendanceRecords.size() - 1));
                    break;
                case 3:
                    employee.viewWeeklyAttendance();
                    break;
                case 4:
                    System.out.println("Enter the Start date of leave in yyyy-MM-dd format: ");
                    String startDate = scanner.nextLine();
                    //LocalDate date = LocalDate.parse(startDate);
                    //startDate = dateFormatter.format(date);

                    System.out.println("Enter the End date of leave in yyyy-MM-dd format: ");
                    String endDate = scanner.nextLine();
                    //date = LocalDate.parse(endDate);
                    //endDate = dateFormatter.format(date);

                    System.out.println("Enter the Reason leave: ");
                    String reason = scanner.nextLine();

                    employee.applyForLeave(startDate, endDate, reason);
                    break;
                case 5:
                    employee.applyForResignation();
                    break;
                case 6:
                    run = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}