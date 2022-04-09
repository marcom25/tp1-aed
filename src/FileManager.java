import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private final String FILENAME = "test.csv";
    private int rows;
    private int columns;
    private int totalNumbers = 0;

    public FileManager(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.totalNumbers = rows * columns;
    }

    private static int getRandomNumber() {
        return (int) (Math.random() * 1001);
    }

    public void write() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME));
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    if (j == columns - 1) {
                        writer.write(getRandomNumber() + "\n");
                    } else {
                        writer.write(getRandomNumber() + ", ");
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read() {
        String line;
        float acc = 0;
        float accTotal = 0;
        float result = 0;
        float totalResult = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));

            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                String lastItem = row[row.length - 1];

                for (String string : row) {
                    float number = Float.parseFloat(string);
                    if (string.equals(lastItem)) {
                        System.out.print(string + "\n");
                    } else {
                        System.out.print(string + ", ");
                    }
                    acc += number;
                    accTotal += number;
                }

                result = acc / columns;
                System.out.println("Promedio por Fila: " + result);
                acc = 0;
            }

            totalResult = accTotal / totalNumbers;
            System.out.println("Promedio Total: " + totalResult);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
