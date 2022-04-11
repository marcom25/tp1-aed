import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FileManager fileManager = new FileManager();

        System.out.println("Por favor, ingrese el número de filas.");
        int rows =  input.nextInt();

        System.out.println("Por favor, ingrese el número de columnas.");
        int columns = input.nextInt();

        input.close();

        fileManager.write(rows, columns);
        fileManager.read(rows, columns);
    }
}