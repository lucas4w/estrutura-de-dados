package arvoreSimples;

public class ArvoreTeste {
	public static void main(String[] args) {
		Arvore arv = new Arvore("a");
		
		Node pai = arv.addChild("b", arv.root());
		arv.addChild("d", pai);
		Node paiE = arv.addChild("e", pai);
		arv.addChild("i", paiE);
		arv.addChild("j", paiE);
		arv.addChild("k", paiE);
		paiE = arv.addChild("f", pai);
		arv.addChild("l", paiE);
		arv.addChild("m", paiE);
		arv.addChild("n", paiE);
		pai = arv.addChild("c", arv.root());
		arv.addChild("h", pai);
		pai = arv.addChild("g", pai);
		paiE = arv.addChild("p", pai);
		arv.addChild("s", paiE);
		pai = arv.addChild("o", pai);
		arv.addChild("q", pai);
		arv.addChild("r", pai);
		
		
		System.out.println(arv.count(arv.root()));
		
		
	}
}
