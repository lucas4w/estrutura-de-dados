package deque;

public class Deque {
	private Node head;
	private Node tail;
	private Node inicio;
	private Node fim;
 	private int tamanho;
	
	public Deque() {
		head = new Node(null);
		tail = new Node(null);
		head.setNext(tail);
		head.setPrev(null);
		tail.setPrev(head);
		tail.setNext(null);
		tamanho = 0;
		inicio = head;
		fim = tail;
	}
	
	public void inserirFim(Object o) {
		Node no = new Node(o);
		no.setNext(tail);
		no.setPrev(tail.getPrev());
		tail.getPrev().setNext(no);
		tail.setPrev(no);
		fim = no;
		if (isEmpty())
			inicio = no;
		tamanho++;
	}
	
	public void inserirInicio(Object o) {
		Node no = new Node(o);
		no.setPrev(head);
		no.setNext(head.getNext());
		head.getNext().setPrev(no);
		head.setNext(no);
		inicio = no;
		if (isEmpty())
			fim = no;
		tamanho++;
	}
	
	public Object removeFim() {
		Object o = fim.getElemento();
		fim.getPrev().setNext(tail);
		tail.setPrev(fim.getPrev());
		fim = fim.getPrev();
		tamanho--;
		return o;
	}
	
	public Object removeInicio() {
		Object o = inicio.getElemento();
		inicio.getNext().setPrev(head);
		head.setNext(inicio.getNext());
		inicio = inicio.getNext();
		tamanho--;
		return o;
	}
	
	public Object first() {
		return inicio.getElemento();
	}
	
	public Object last() {
		return fim.getElemento();
	}
	
	public int size() {
		return tamanho;
	}
	
	public void listar() {
		Node current = inicio;
		while(current.getNext()!=null) {
			System.out.print(current.getElemento()+" ");
			current = current.getNext();
		}
		System.out.println("");
	}
	
	public boolean isEmpty() {
		return tamanho == 0;
	}
}

