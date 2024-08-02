import java.io.*;
public class Task7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        String headerLine = br.readLine();
        String[] headers = headerLine.split(",");
        BufferedWriter[] writers = new BufferedWriter[headers.length];
        for (int i = 0; i < headers.length; i++) {
            writers[i] = new BufferedWriter(new FileWriter(headers[i] + ".txt"));
        }

        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            for (int i = 0; i < values.length; i++) {
                writers[i].write(values[i]);
                writers[i].newLine();
            }
        }

        for (BufferedWriter writer : writers) {
            writer.close();
        }
        br.close();
    }
}
