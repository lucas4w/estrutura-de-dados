package filaLigada;
// implementação do TAD pilha usando 2 filas 
public class Stack2Filas {
	private Fila fila1;
	private Fila fila2;
	
	public Stack2Filas() {
		fila1 = new Fila();
		fila2 = new Fila();
	}
	
	public void push(Object o) {
		fila2.enqueue(o);
		while(!fila1.isEmpty()) {
			fila2.enqueue(fila1.dequeue());
		}
		Fila temp = fila1;
		fila1 = fila2;
		fila2 = temp;
	}
	
	public Object pop() {
		return fila1.dequeue();
	}
}
