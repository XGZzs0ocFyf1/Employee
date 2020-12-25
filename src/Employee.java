import java.util.stream.Stream;

public class Employee {
    private final String fullName;
    private final String position;
    private final String email;
    private final String phone;
    private final int salary;
    private final int age;


    public Employee(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }



    public int getAge() {
        return age;
    }


    public static void main(String[] args) {
        int listSize = 10;

        System.out.println("Steam API output");
        //stream api
        Stream.generate(new EmployeeFactory()::getEmployee)
                .limit(listSize)
                .filter(x -> x.getAge() > 40)
                .forEach(System.out::println);
        //clear blank line
        System.out.println();

        //loop
        EmployeeFactory ef = new EmployeeFactory();

        //create
        Employee[] employeeDep2 = new Employee[10];

        //populate
        for (int i = 0; i < employeeDep2.length; i++) {
            employeeDep2[i] = ef.getEmployee();
        }

        //filter
        System.out.println("Loop output");
        for (int i = 0; i < employeeDep2.length; i++) {
            if (employeeDep2[i].getAge() > 40) System.out.println(employeeDep2[i]); //scala like syntax
        }

    }
}
