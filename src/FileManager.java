import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileManager {
    private final String FILENAME = "test.csv";

    private static int getRandomNumber() {
        return (int) (Math.random() * 1001);
    }

    public void write(int rows, int columns) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME));
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (j == columns - 1) {
                        writer.write(getRandomNumber() + "\n");
                    } else writer.write(getRandomNumber() + ", ");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(int rows, int columns) {
        int i = 0;
        int totalNumbers = rows * columns;
        String line;
        float acc = 0;
        float result = 0;
        float accTotal = 0;
        float totalResult = 0;
        float [] rowAverages = new float[rows];
        

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
            
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                String lastItem = row[row.length - 1];

                for (String string : row) {
                    float number = Float.parseFloat(string);
                    if (string.equals(lastItem)) {
                        System.out.print(string + "\n");
                    } else System.out.print(string + ", ");

                    acc += number;
                    accTotal += number;
                }
                
                result = acc / columns;
                rowAverages[i] = result;
                i++;
                acc = 0;
            }
            reader.close();

            
            for (int j = 0; j < rows; j++) System.out.println("Promedio de la fila " + (j + 1) + ": " + rowAverages[j]);
            
            totalResult = accTotal / totalNumbers;
            System.out.println("Promedio total: " + totalResult); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}