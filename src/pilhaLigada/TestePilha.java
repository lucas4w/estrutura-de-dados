package pilhaLigada;

public class TestePilha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pilha stack1 = new Pilha();
		Pilha stack2 = new Pilha();
		stack1.push(12);
		stack1.push(13);
		stack1.push(14);
		stack1.push(15);
		stack1.push(16);
		stack1.push(17);
		stack1.push(18);
		stack2.push(21);
		stack2.push(22);
		stack2.push(23);
		stack2.push(24);
		stack2.push(25);
		stack2.push(26);
		stack1.listar();
		stack2.adicionaPilha(stack1);
		stack2.listar();
		stack2.pop();
		stack2.pop();
		stack2.listar();
	}

}
