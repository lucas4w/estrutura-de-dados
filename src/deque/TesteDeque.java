package deque;

public class TesteDeque {
	public static void main(String[] args) {
		Deque deque = new Deque();
		deque.inserirFim(1);
		deque.inserirInicio(89);
		deque.inserirFim(13);
		deque.inserirInicio(80);
		deque.inserirFim(14);
		deque.inserirInicio(57);
		deque.inserirFim(5);
		deque.inserirInicio(46);
		deque.listar();
		System.out.println(deque.first());
		deque.removeInicio();
		deque.removeFim();
		deque.removeFim();
		deque.removeInicio();
		deque.removeFim();
		deque.removeInicio();
		deque.listar();
	}
}
