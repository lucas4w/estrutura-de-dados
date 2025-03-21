package filaLigada;

public class Fila implements IFila{
    private Node inicio;
    private Node fim;
    private int tamanho;

    public Fila(){
        inicio = new Node(null,null);
        inicio.setNext(null);
        tamanho = 0;
    }

    public void enqueue(Object o){
        Node newE = new Node(o,null);
        if (isEmpty()) {
        	tamanho++;
        	inicio.setNext(newE);
        	fim = newE;
        	fim.setNext(null);
        	return;
        }
        tamanho++;
        fim.setNext(newE);
        fim = newE;
        fim.setNext(null);
    }

    public void listar() {
    	Node no = inicio.getNext();
    	while (no != null) {
    		System.out.print(no.getElemento() + " ");
    		no = no.getNext();
    	}
    	System.out.println("");
    }
    
    public void inverte() {
    	Node newnode = new Node(inicio.getNext().getElemento(),null);
    	Node newFim = newnode;
    	Node newInicio = new Node(null,newnode);
    	Node no = inicio.getNext().getNext();
    	while (no != null) {
    		Node added = new Node(no.getElemento(),newnode);
    		newInicio.setNext(added);
    		newnode = added;
    		no = no.getNext();
    	}
    	fim = newFim;
    	inicio = newInicio;
    }
    
    public Object dequeue(){
    	if (isEmpty())
    		throw new FilaVaziaException("Fila Vazia");
    	
        Object o = inicio.getNext().getElemento();
        tamanho--;
        inicio.setNext(inicio.getNext().getNext());;
        return o;
    }

    public Object first(){
    	if (isEmpty())
    		throw new FilaVaziaException("Fila vazia");
        return inicio.getNext().getElemento();
    }
   
    public int size(){
        return tamanho;
    }

    public boolean isEmpty(){
        return inicio.getNext()==null;
    }
}


