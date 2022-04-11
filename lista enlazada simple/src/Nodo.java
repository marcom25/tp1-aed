
public class Nodo {
		public int dato;
		public Nodo siguiente; //referencia enlace
		
		// constructor para insertar al final
		public Nodo (int d) {
			this.dato =d;
			
		}
		
		// Constructor para insertar al inicio
		public Nodo (int d, Nodo n) {
			dato = d;
			siguiente = n;
			
		}

		

		
	}
