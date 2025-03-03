package vectorLigada;

public class TesteVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector vector = new Vector();
		vector.insertAtRank(0,11);
		vector.insertAtRank(1,12);
		vector.insertAtRank(1,13);
		vector.insertAtRank(3,14);
		vector.listar();
		vector.removeAtRank(3);
		vector.listar();
		
	}

}
