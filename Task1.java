import java.io.*;
public class Task1 {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("one.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("two.txt"));
        int data;
        while ((data = bis.read()) != -1) {
            bos.write(data);
        }
        bis.close();
        bos.close();
    }
}
