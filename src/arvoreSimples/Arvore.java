package arvoreSimples;

public class Arvore {
	private Node raiz;
	private int tamanho;
	
	public Arvore(Object o) {
		raiz = new Node(null,o);
		tamanho = 1;
	}
	
	public Node root() {
		return raiz;
	}
	
	public Node parent(Node v) {
		return v.parent();
	}
	
	public boolean isInternal(Node v) {
		return v.childrenNumber() > 0;
	}
	
	public boolean isExternal(Node v) {
		return v.childrenNumber() == 0;
	}
	
	public boolean isRoot(Node v) {
		return v == raiz;
	}
	
	public Node addChild(Object o, Node v) {
		Node no = new Node(v,o);
		v.addChild(no);
		tamanho++;
		return no;
	}
	
	public Object removeChild(Node v) {
		Node pai = v.parent();
		if (pai != null || isExternal(v))
			pai.removeChild(v);
		else
			throw new IndexOutOfBoundsException("aa");
		Object o = v.getElement();
		tamanho--;
		return o;
	}
	
	public void swapElements(Node v, Node w) {
		Object aux = v.getElement();
		v.setElement(w.getElement());
		w.setElement(aux);
	}
	
	public int depth(Node v) {
		return profundidade(v);
	}
	
	
	private int profundidade(Node v) {
		if (v == raiz)
			return 0;
		else
			return 1+profundidade(v.parent());
	}
	
	public int height(Node v) {
		if (isExternal(v))
			return 1;
		else {
			int h = 0;
			for (Node current:v.filhos) {
				h = Math.max(h,height(current));
			}
			return 1+h;
		}
	}
	
	public int count(Node v) {
		if (isExternal(v))
			return 1;
		else {
			int h = 1;
			for (Node current:v.filhos) {
				h += count(current);
			}
			return h;
		}
	}
	
	public int size() {
		return tamanho;
	}
	
	public Object replace(Node v, Object o) {
		Object aux = v.getElement();
		v.setElement(o);
		return aux;
	}
	
	public boolean isEmpty() {
		return false;
	}
	
}
