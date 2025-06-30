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

    interface BonusCalulater{
        double calculate(double Salary);
    }

    public static void main(String[] args) {


    List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Ajay", 200000, LocalDate.of(2020, 9, 15), Optional.of("Civil")));
        employees.add(new Employee("Suresh", 300000, LocalDate.of(2023, 11, 16), Optional.of("IT")));
        employees.add(new Employee("Vijesh", 400000, LocalDate.of(2002, 12, 17), Optional.of("Defence")));
        employees.add(new Employee("Gukesh", 600000, LocalDate.of(2003, 1, 17), Optional.of("AirForce")));
        employees.add(new Employee("Ramesh", 600000, LocalDate.of(2019, 4, 18), Optional.of("Cricket")));

    BonusCalulater bonusCalulater=(salary)->(salary*0.10);

     employees.forEach(emp-> System.out.println(emp.getName()+ " "+emp.getSalary()));
//        Filter employees who joined after 2020
     employees.stream().filter(emp->emp.getJoiningDate().isAfter(LocalDate.of(2020,2,2)))
             .forEach(emp-> System.out.println(emp.getName()));


//        - Map employee names to uppercase
     employees.stream()
             .map(emp ->emp.getName().toUpperCase() )
             .forEach(System.out::println);

//    - Count how many employees have a salary greater than ₹50,000

        long Salaryhigher=employees.stream().filter(emp->emp.getSalary()>50000).count();

        System.out.println(Salaryhigher);
}}
