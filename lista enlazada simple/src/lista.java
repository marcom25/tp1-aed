import java.util.Scanner;

public class lista {

	protected Nodo inicio,fin; // referencias para saber donde esta el inicio y el fin
	
	public void Lista () {
		inicio = null;
		fin = null;
	}
	
	// Metodo para agregar un nodo al inicio de la lista
	
	public void agregarAlInicio (int elemento) {
		// Creando el nodo
		inicio = new Nodo(elemento, inicio);
		if (fin==null) {
			fin=inicio;
		}
	}
	// Metodo para mostrar los datos
	public void mostrarLista () {
		
		Nodo recorrer = inicio;
		System.out.println();
		while (recorrer != null) {
			System.out.print("[" + recorrer.dato + "]---->");
			recorrer = recorrer.siguiente;
		}
		
	}
	
}


