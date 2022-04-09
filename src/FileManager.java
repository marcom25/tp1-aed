import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private String line = "";
    private float acc = 0;
    private int totalNumbers = 0;
    private float result = 0;
    private int rows;
    private int columns;
    private long start;
    private long end;


    public FileManager(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        totalNumbers = rows * columns;
    }

    public static int RandomNumber() {
        return (int) (Math.random() * 1001);
    }

    public void Write() {
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("test.csv"));
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    if (j == columns - 1) {
                        writer.write(RandomNumber() + "\n");
                    } else writer.write(RandomNumber() + ", ");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Read() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("test.csv"));
            while ((line = reader.readLine()) != null) {

                String[] row = line.split(",");

                for (String index : row) {
                    
                    System.out.println(index);
                }
                System.out.println();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public float TotalAverage() {
        start = System.currentTimeMillis();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("test.csv"));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (String index : row) {
                    acc += Float.parseFloat(index);
                }
            }
            result = acc / totalNumbers;
            reader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        end = System.currentTimeMillis();
        System.out.println("tiempo: " + (end - start));
        return result;
    }

    public void RowAverage() {
        start = System.currentTimeMillis();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("test.csv"));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (String index : row) {
                    acc += Float.parseFloat(index);
                }
                result = acc / columns;
                System.out.println(result);
               
                acc = 0;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        end = System.currentTimeMillis();

        System.out.println("tiempo: " + (end - start));
    }

}

