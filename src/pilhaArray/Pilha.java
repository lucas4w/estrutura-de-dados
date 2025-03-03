package pilhaArray;

public class Pilha implements IPilha {
	private int top;
	private int capacidade;
	private Object pilha[];
	private int incremento;
	
	public Pilha(int capacidade, int incremento) {
		this.capacidade = capacidade;
		pilha = new Object[capacidade];
		this.incremento = incremento;
		top = -1;
	}
	
	public int size() {
		return top+1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public Object top() {
		if (isEmpty())
			throw new EPilhaVazia("Pilha Vazia");
		return pilha[top];
	}
	
	public void push(Object o) {
		if (top+1==capacidade) {
			if (incremento == 0)
				capacidade *= 2;
			else
				capacidade += incremento;
			Object[] aux = new Object[capacidade];
			for (int i = 0; i<pilha.length;i++)
				aux[i] = pilha[i];
			pilha = aux;
		}	
		top++;
		pilha[top] = o;
		
	}
	
	public Object pop() {
		Object o = top();
		top--;
		return o;
	}
	
	public void listar() {
		if (isEmpty())
			return;
		for (int i = 0; i<size();i++)
			System.out.print(pilha[i] + " ");
		System.out.print("\n");
	}
}
