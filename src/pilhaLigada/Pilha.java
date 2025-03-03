package pilhaLigada;

public class Pilha {
	private Node top;
	private int tamanho;
	private Node head;
	
	public Pilha() {
		head = new Node(null);
		head.setNext(null);
		top = head;
		tamanho = 0;
	}
	
	public void push(Object o) {
		Node node = new Node(o);
		node.setNext(head.getNext());
		head.setNext(node);
		top = node;
		tamanho++;
	}
	
	public int size() {
		return tamanho;
	}
	
	public void adicionaPilha(Pilha p) {
		Pilha aux = new Pilha();
		while(!p.isEmpty()) {
			aux.push(p.pop());
		}
		
		while(!aux.isEmpty()) {
			Object o = aux.top();
			push(o);
			tamanho++;
			p.push(aux.pop());
		}
	}
	
	public void empty() {
		head.setNext(null);
		top = head;
		tamanho = 0;
	}
	
	public Object top() {
		if (isEmpty())
			throw new PilhaVaziaException("A pilha está vazia");
		return top.getElement();
	}
	
	public boolean isEmpty() {
		return head.getNext() == null;
	}
	
	public void listar() {
		Node current = head.getNext();
		while(current != null) {
			System.out.print(current.getElement() + " ");
			current = current.getNext();
		}
		System.out.println("");
	}
	
	public Object pop() {
		if (isEmpty())
			throw new PilhaVaziaException("A pilha está vazia");
		Object aux = top.getElement();
		head.setNext(top.getNext());
		top = head.getNext();
		tamanho--;
		return aux;
	}
	
}
