import java.io.*;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter semester: ");
        String semester = scanner.nextLine();

        BufferedWriter bw = new BufferedWriter(new FileWriter("students.csv", true));
        bw.write(firstName + "," + lastName + "," + address + "," + contactNumber + "," + semester);
        bw.newLine();
        bw.close();
    }
}
