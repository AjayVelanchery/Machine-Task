import javax.print.attribute.standard.PrinterName;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//
//Create a Java program that defines an Employee class with the following fields:
//
//String name;
//double salary;
//LocalDate joiningDate;
//Optional<String> department;
//
//Then perform the following operations:
//
//        1. Use a functional interface and a lambda expression to calculate and print a 10% bonus for each employee.
//
//        2. Use the Stream API to:
//        - Filter employees who joined after 2020
//        - Map employee names to uppercase
//    - Count how many employees have a salary greater than ₹50,000
//        3. Use the Date and Time API to calculate and print each employee’s years of service.
//        4. Use the Optional class to safely print each employee’s department, or "Not Assigned" if absent.
//5. Create a Runnable thread to print each employee's name with a 1-second delay.

public class Database {
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

        employees.forEach(emp-> System.out.println(emp.getName()+ " "+bonusCalulater.calculate(emp.getSalary())));
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


        //calculate year of service
        employees.forEach(emp->{int years= Period.between(emp.getJoiningDate(),LocalDate.now()).getYears();
            System.out.println(emp.getName()+" "+years);
        });


//        4. Use Optional to print department

     employees.stream()
             .map(emp->emp.getDepartment().orElse("Not Assigned"))
             .forEach(System.out::println);


//        5. Runnable thread to print names with delay
Runnable printName=()->{
    for(Employee emp:employees){
        try {
            Thread.sleep(1000);
            System.out.println(emp.getName());

        }
      catch (InterruptedException e){
            Thread.currentThread().interrupt();
          System.out.println("Thread was interrupted");
      }}};
    Thread thread=new Thread(printName);
    thread.start();

    }}

