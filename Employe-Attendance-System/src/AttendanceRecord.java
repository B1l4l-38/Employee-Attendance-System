import java.util.*;
import java.time.*;
class AttendanceRecord {
    private String employeeId;
    private String date;
    private String timeIn;
    private String timeOut;



    public AttendanceRecord(String employeeId, String date, String timeIn) {
        this.employeeId = employeeId;
        this.date = date;
        this.timeIn = timeIn;
    }


    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getDate() {
        return date;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    @Override
    public String toString() {
        return "AttendanceRecord{" +
                "employeeId='" + employeeId + '\'' +
                ", checkInTime=" + getTimeIn() +
                ", checkOutTime=" + getTimeOut() +
                '}';
    }
}