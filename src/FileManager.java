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

    public double write(int rows, int columns) {
        double totalTimeInSeconds = -1;

        try {
            double startTime = java.lang.System.currentTimeMillis();

            BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME));
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (j == columns - 1) {
                        writer.write(getRandomNumber() + "\n");
                    } else {
                        writer.write(getRandomNumber() + ", ");
                    }
                }
            }
            writer.close();

            double finishTime = java.lang.System.currentTimeMillis();
            totalTimeInSeconds = (finishTime - startTime) / 1000;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return totalTimeInSeconds;
    }

    public double read(int rows, int columns) {
        double totalTimeInSeconds = -1;

        int i = 0;
        int totalNumbers = rows * columns;
        String line;
        float acc = 0;
        float result = 0;
        float accTotal = 0;
        float totalResult = 0;
        float[] rowAverages = new float[rows];

        try {
            double startTime = java.lang.System.currentTimeMillis();

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
                rowAverages[i] = result;
                i++;
                acc = 0;
            }
            reader.close();

            for (int j = 0; j < rows; j++) {
                System.out.println("Promedio de la fila " + (j + 1) + ": " + rowAverages[j]);
            }

            totalResult = accTotal / totalNumbers;
            System.out.println("Promedio total: " + totalResult); 

            double finishTime = java.lang.System.currentTimeMillis();
            totalTimeInSeconds = (finishTime - startTime) / 1000;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return totalTimeInSeconds;
    }
}
