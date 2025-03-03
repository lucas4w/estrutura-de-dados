package bsTree;
import java.util.Random;

public class BSTtest {
	public static void main(String[] args) {
		BStree tree = new BStree(5);
		Random r = new Random();
		for (int i = 1; i < 40; i++) {
			//tree.add(r.nextInt(5));
			tree.add(i);
		}
		tree.inOrder(tree.root());
		System.out.println();
		tree.prova(tree.root(), 10, 20);
	}
}
