package pilhaLigada;

public class Fila2stacks {
	private Pilha pilha1;
	private Pilha pilha2;
	
	public Fila2stacks() {
		pilha1 = new Pilha();
		pilha2 = new Pilha();
	}
	
	public void enqueue(Object o) {
		pilha1.push(o);
	}
	
	public Object dequeue() {
		if (pilha2.isEmpty()) {
			while(!pilha1.isEmpty())
				pilha2.push(pilha1.pop());
		}
		return pilha2.pop();
	}
	
	public Object first() {
		if (pilha2.isEmpty()) {
			while(!pilha1.isEmpty())
				pilha2.push(pilha1.pop());
		}
		return pilha2.top();
	}
	
	public boolean isEmpty() {
		return pilha1.isEmpty() && pilha2.isEmpty();
	}
}
