import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Instantiating objects
        Scanner input = new Scanner(System.in);
        
        
        
        System.out.println("Por favor, ingrese el número de filas.");
        int rows =  input.nextInt();
        
        System.out.println("Por favor, ingrese el número de columnas.");
        int columns = input.nextInt();
        
        input.close();
        
        FileManager fileManager = new FileManager(rows, columns);
        
        fileManager.Write();
        fileManager.Read();
        System.out.println();
        fileManager.RowAverage();
        System.out.println(fileManager.TotalAverage());
    }

}
