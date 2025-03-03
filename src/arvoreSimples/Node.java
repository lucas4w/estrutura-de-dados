package arvoreSimples;
import java.util.ArrayList;

public class Node {
	private Object o;
	private Node pai;
	public ArrayList<Node> filhos = new ArrayList<>();
	
	public Node(Node pai, Object o) {
		this.pai = pai;
		this.o = o;
	}
	
	public Object getElement() {
		return o;
	}
	
	public Node parent() {
		return pai;
	}
	
	public void setElement(Object o) {
		this.o = o;
	}
	
	public void addChild(Node no) {
		filhos.add(no);
	}
	
	public void removeChild(Node no) {
		filhos.remove(no);
	}
	
	public int childrenNumber() {
		return filhos.size();
	}

}
