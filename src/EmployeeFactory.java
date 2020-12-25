import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;



public class EmployeeFactory  {

    public Employee getEmployee() {
        return new Employee(
                getRandomName(),
                getRandomPosition(),
                getRandomEmail(),
                getRandomPhoneNumber(),
                ThreadLocalRandom.current().nextInt(50_000, 70_000),
                ThreadLocalRandom.current().nextInt(25, 50)

        );
    }

    private String getRandomPhoneNumber() {
        StringBuilder sb = new StringBuilder("89");
        while (sb.length() < 10) {
            sb.append(new Random().nextInt(10));
        }
        return sb.toString();
    }

    private String getRandomName() {
        String[] names = {"Alex", "Anna", "Abraham", "Anastasy", "Alina",
                "Boris", "Brad", "Bella", "Beth", "Bruno",
                "Cappa", "Charlie", "Chloe"};
        return names[new Random().nextInt(names.length)];
    }

    private String getRandomPosition() {
        String[] positions = {"Tech lead", "Manager", "HR", "Senior developer", "Developer", "Tester", "Stuff",
                "Technical support"};
        return positions[new Random().nextInt(positions.length)];
    }

    private String getRandomEmail() {
        int emailLength = 10;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < emailLength) sb.append((char) ThreadLocalRandom.current().nextInt(65, 122));
        sb.append("gmail.com");
        return sb.toString();
    }


    public static void main(String[] args) {

        EmployeeFactory ef = new EmployeeFactory();
        for (int i = 0; i < 100; i++) {
            System.out.println(ef.getEmployee());
        }

    }
}
