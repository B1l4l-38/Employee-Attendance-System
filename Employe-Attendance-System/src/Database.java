import java.util.*;

class Database {
    private static final List<Employee> employees = new ArrayList<>();
    private static final List<Leave> leaveApplications = new ArrayList<>();
    private static List<AttendanceRecord> attendanceRecords = new ArrayList<>();
    public static Stack<String> resignations = new Stack<String>();



    static {
        // Pre-populating the database with some employees for demonstration
        employees.add(new Employee("bilal", "bilal123", "Bilal", 30, "001", "Male", "1234567890", "Address 1"));
        employees.add(new Employee("muarij", "muarij123", "Muarij", 28, "002", "Male", "0987654321", "Address 2"));
        employees.add(new Employee("abdullah", "abdullah123", "Abdullah", 25, "003", "Male", "1234509876", "Address 3"));
        employees.add(new Employee("muaaz", "muaaz123", "Muaaz", 32, "004", "Male", "6789054321", "Address 4"));
    }

    public static void addEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
        }
    }

    public static void removeEmployee(String employeeId) {
        Employee employeeToRemove = null;
        for (Employee employee : employees) {
            if (employee.getId().equals(employeeId)) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
        }
    }

    public static void updateEmployee(Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(updatedEmployee.getId())) {
                employees.set(i, updatedEmployee);
                return;
            }
        }
    }

    public static Employee searchForEmployee(String username) {
        for (Employee employee : employees) {
            if (employee.getUsername().equals(username)) {
                return employee;
            }
        }
        return null;
    }

    public static Employee checkEmployeeValidation(String username, String password) {
        for (Employee employee : employees) {
            if (employee.getUsername().equals(username) && employee.getPassword().equals(password)) {
                return employee;
            }
        }
        return null;
    }

    public static List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    public static void addLeaveApplication(Leave leave) {
        leaveApplications.add(leave);
    }

    public static List<Leave> getLeaveApplications() {
        return new ArrayList<>(leaveApplications);
    }

    public static void updateLeaveStatus(String employeeId, String startDate, String status) {
        for (Leave leave : leaveApplications) {
            if (leave.getEmployeeId().equals(employeeId) && leave.getStartDate().equals(startDate)) {
                leave.setStatus(status);
                return;
            }
        }
    }

    public static void recordAttendance(AttendanceRecord record) {
        attendanceRecords.add(record);
    }

    public static List<AttendanceRecord> getAttendanceRecords(String employeeId) {
        List<AttendanceRecord> records = new ArrayList<>();
        for (AttendanceRecord record : attendanceRecords) {
            if (record.getEmployeeId().equals(employeeId)) {
                records.add(record);
            }
        }
        return records;
    }

    public static void applyForResignation(String employeeId) {
        resignations.add(employeeId);
    }
}