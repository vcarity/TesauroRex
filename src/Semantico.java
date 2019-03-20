import java.util.*;
import tesauroRex.analysis.*;
import tesauroRex.node.*;

public class Semantico extends DepthFirstAdapter {

	// Hashtable tabelaDeSimbolos = new Hashtable();
	// Stack pilha = new Stack();
	Stack pilha = new Stack();

	@Override
	public void inStart(Start node)
	{
		System.out.println("-------------------------------------------------");
		System.out.println("Iniciando análise semântica...");
		System.out.println("-------------------------------------------------");
	}

	 @Override
	 public void outStart(Start node)
	 {
		 System.out.println("-------------------------------------------------");
		 System.out.println("Fim da análise semântica");
		 System.out.println("-------------------------------------------------");
	 }

	 @Override
	 public void inAPrograma(APrograma node)
	 {
		 Hashtable tabelaDeSimbolos = new Hashtable();
		 pilha.push(tabelaDeSimbolos);
		 System.out.println("inAPrograma");
	 }

	 @Override
	 public void outAPrograma(APrograma node)
	 {
		 pilha.pop();
		 System.out.println("outAPrograma");
	 }

}
