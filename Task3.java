import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) throws IOException {
        List<Integer> numbers = read("numbers.txt");
        write(getEven(numbers), "even.txt");
        write(getOdd(numbers), "odd.txt");
    }

    public static List<Integer> read(String filePath) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");
            for (String part : parts) {
                numbers.add(Integer.parseInt(part));
            }
        }
        br.close();
        return numbers;
    }

    public static List<Integer> getEven(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
    }

    public static List<Integer> getOdd(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
    }

    public static void write(List<Integer> numbers, String filePath) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        for (int number : numbers) {
            bw.write(String.valueOf(number));
            bw.write(" ");
        }
        bw.close();
    }
}
