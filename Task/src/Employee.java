import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Employee {

    String name;
    double Salary;
    LocalDate joiningDate;
    Optional<String>department;

    public Employee(String name, double salary, LocalDate joiningDate, Optional<String> department) {
        this.name = name;
        Salary = salary;
        this.joiningDate = joiningDate;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Optional<String> getDepartment() {
        return department;
    }

    public void setDepartment(Optional<String> department) {
        this.department = department;
    }

   }
