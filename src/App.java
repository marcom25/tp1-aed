import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Por favor, ingrese el numero de filas: ");
        int rows =  input.nextInt();

        System.out.print("Por favor, ingrese el numero de columnas: ");
        int columns = input.nextInt();

        input.close();

        FileManager fileManager = new FileManager();
        double writeTime = fileManager.write(rows, columns);
        double readTime = fileManager.read(rows, columns);
        double totalTime = writeTime + readTime;

        System.out.println("Tiempo tardado en escribir los datos: " + writeTime + " segundos.");
        System.out.println("Tiempo tardado en leer los datos: " + readTime + " segundos.");
        System.out.println("Tiempo tardado en total: " + totalTime + " segundos.");
    }
}
