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
			 tabelaDeSimbolos.put("Programa", simbolo);
			 pilha.push(tabelaDeSimbolos);
			 //System.out.println(tabelaDeSimbolos);
			 //System.out.println(tabelaDeSimbolos.get("Programa"));
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
	 
	 @Override
	 public void inABloco(ABloco node)
	 {
		 System.out.println("inABloco");
		 if (pilha.size() > 1) {
			 Hashtable tabelaDeSimbolos = new Hashtable();
			 pilha.push(tabelaDeSimbolos);
		 }
	 }
	 
	 @Override
	 public void outABloco(ABloco node)
	 {
		 System.out.println("outABloco");
		 if (pilha.size() > 1) {
			 pilha.pop();
		 }
	 }
	 
	 @Override
	 public void inAVariableDeclaracao(AVariableDeclaracao node)
	 {
		 System.out.println("inAVariableDeclaracao");
		 defaultIn(node);
	 }

}
