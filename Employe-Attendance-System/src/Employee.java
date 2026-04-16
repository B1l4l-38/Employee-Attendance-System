import java.util.*;
public class Employee extends User {
    private String name;
    private int age;
    private String id;
    private String gender;
    private String phoneNumber;
    private String address;

    public Employee(String username, String password, String name, int age, String id, String gender, String phoneNumber, String address) {
        super(username, password);
        this.name = name;
        this.age = age;
        this.id = id;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return super.getUsername();
    }




    public void applyForLeave(String startDate, String endDate, String reason) {
        // Assuming Database class has a method to add a leave application
        Leave leave = new Leave(this.id, startDate, endDate, reason, "Pending");
        Database.addLeaveApplication(leave);
        System.out.println("Leave application submitted for review.");
    }

    public void viewWeeklyAttendance() {
        // Assuming Attendance class can return attendance records for an employee
        List<AttendanceRecord> records = Database.getAttendanceRecords(this.id);
        for (int i = 0; i < records.size(); i++) {
            if (i == 7)
                break; 
            System.out.println(records.get(i));
            
        }       
    }

    public void applyForResignation() {
        // Assuming Database class has a method to mark an employee for resignation
        Database.applyForResignation(this.getId());
        System.out.println("Resignation application submitted.");
    }


}
