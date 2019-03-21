import java.util.*;
import tesauroRex.analysis.*;
import tesauroRex.node.*;

public class Semantico extends DepthFirstAdapter {

	// Hashtable tabelaDeSimbolos = new Hashtable();
	// Stack pilha = new Stack
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
		 System.out.println("inAPrograma");
		 if (pilha.empty()) {
			 Hashtable tabelaDeSimbolos = new Hashtable();
			 Simbolo simbolo = new Simbolo(node.getClass().getSimpleName().toString(), node.getId().toString());
			 tabelaDeSimbolos.put(simbolo, simbolo.getHash());
			 pilha.push(tabelaDeSimbolos);
			 System.out.println(tabelaDeSimbolos);
		 } else {
			 System.out.println("-------------------------------------------------");
			 System.out.println("Erro: Programa já declarado.");
			 System.out.println("Análise Semântica Encerrada.");
			 System.out.println("-------------------------------------------------");
			 System.exit(0);
		 }
	 }

	 @Override
	 public void outAPrograma(APrograma node)
	 {
		 System.out.println("outAPrograma");
		 pilha.pop();
	 }

}
