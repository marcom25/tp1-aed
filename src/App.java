import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Por favor, ingrese el numero de filas.");
        int rows =  input.nextInt();

        System.out.println("Por favor, ingrese el numero de columnas.");
        int columns = input.nextInt();

        input.close();

        FileManager fileManager = new FileManager(rows, columns);
        fileManager.write();
        fileManager.read();
    }
}
