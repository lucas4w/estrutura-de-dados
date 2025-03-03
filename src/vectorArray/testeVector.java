package vectorArray;

public class testeVector {
	public static void main(String[] args) {
		Vector vector = new Vector(3);
		vector.insertAtRank(0, 1);
		vector.insertAtRank(1, 2);
		vector.insertAtRank(2, 3);
		vector.insertAtRank(3, 4);
		vector.removeAtRank(4);
		vector.listar();
	}
}
