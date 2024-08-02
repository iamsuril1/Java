import java.io.*;
import java.util.*;

public class Task6 {
    public static void main(String[] args) throws IOException {
        Map<String, List<Double>> productSales = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("products.txt"));
        String line = br.readLine(); 
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");
            String product = parts[0].trim();
            String priceString = parts[1].trim().replace(",", ""); 
            double price = Double.parseDouble(priceString);
            productSales.computeIfAbsent(product, k -> new ArrayList<>()).add(price);
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter("average_sales.csv"));
        for (Map.Entry<String, List<Double>> entry : productSales.entrySet()) {
            String product = entry.getKey();
            List<Double> prices = entry.getValue();
            double average = prices.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            bw.write(product + "," + average);
            bw.newLine();
        }
        bw.close();
    }
}