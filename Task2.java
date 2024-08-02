import java.io.*;
public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("one.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("two.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
