package sequencia;

public class TesteSequencia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sequencia seq =  new Sequencia();
		for (int i = 1;i < 11;i++)	
			seq.insertLast(i);
		
		Node no = seq.atRank(9);
		seq.makeFirst(no);
		seq.listar();
	}
}
