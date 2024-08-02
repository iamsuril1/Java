import java.io.*;
public class Task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("text.txt"));
        int wordCount = 0;
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");
            wordCount += words.length;
        }
        br.close();
        System.out.println("Total word count: " + wordCount);
    }
}
