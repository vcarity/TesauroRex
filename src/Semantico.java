import java.util.*;
import tesauroRex.analysis.*;
import tesauroRex.node.*;

public class Semantico extends DepthFirstAdapter {

	// Hashtable tabelaDeSimbolos = new Hashtable();
	// Stack pilha = new Stack
	Stack pilha = new Stack();
	
	public Stack getPilha() {
		return this.pilha;
	}
	
	public Boolean conferirTipo(String tipo, String valor) {
		switch (tipo) {
		case "integer ":
			//if (valor.charAt(1) == 'd' 
			//	|| valor.charAt(1) == 'b') 
			//{
			//	return true;
			//} else {
			//	return false;
			//}
			return true;
		case "real ":
			return true;
		case "symbol ":
			return true;
		default :
			return false;
		}
	}

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
		 if (pilha.empty()) {
			 Hashtable tabelaDeSimbolos = new Hashtable();
			 Simbolo simbolo = new Simbolo(node.getId().toString(), "Programa");
			 tabelaDeSimbolos.put(simbolo.getId(), simbolo);
			 pilha.push(tabelaDeSimbolos);
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
		 pilha.pop();
	 }
	 
	 @Override
	 public void inABloco(ABloco node)
	 {
		 if (pilha.size() > 1) {
			 Hashtable tabelaDeSimbolos = new Hashtable();
			 pilha.push(tabelaDeSimbolos);
		 }
	 }
	 
	 @Override
	 public void outABloco(ABloco node)
	 {
		 if (pilha.size() > 1) {
			 pilha.pop();
		 }
	 }
	 
	 @Override
	 public void inAVariableDeclaracao(AVariableDeclaracao node)
	 {
		 Hashtable tabelaDeSimbolos = (Hashtable) getPilha().peek();
		 String variavel = node.getIdentifier().toString();
		 Simbolo simboloVariavel = (Simbolo) tabelaDeSimbolos.get(variavel);
		 if (simboloVariavel == null) {
			 Simbolo simbolo = new Simbolo(node.getIdentifier().toString(), node.getTipo().toString());
			 tabelaDeSimbolos.put(simbolo.getId(), simbolo);
		 } else {
			 System.out.println("-------------------------------------------------");
			 System.out.println("Erro: variável " + variavel + " já existe.");
			 System.out.println("Análise Semântica Encerrada.");
			 System.out.println("-------------------------------------------------");
			 System.exit(0);
		 }
	 }
	 
	 @Override
	 public void outAVariableDeclaracao(AVariableDeclaracao node)
	 {
		 //
	 }
	 
	 @Override
	 public void inAConstDeclaracao(AConstDeclaracao node)
	 {
		 Hashtable tabelaDeSimbolos = (Hashtable) getPilha().peek();
		 String variavel = node.getIdentifier().toString();
		 Simbolo simboloVariavel = (Simbolo) tabelaDeSimbolos.get(variavel);
		 if (simboloVariavel == null) {
			 Simbolo simbolo = new Simbolo(node.getIdentifier().toString(), node.getTipo().toString());
			 tabelaDeSimbolos.put(simbolo.getId(), simbolo);
		 } else {
			 System.out.println("-------------------------------------------------");
			 System.out.println("Erro: variável " + variavel + " já existe.");
			 System.out.println("Análise Semântica Encerrada.");
			 System.out.println("-------------------------------------------------");
			 System.exit(0);
		 }
	 }
	 
	 @Override
	 public void outAConstDeclaracao(AConstDeclaracao node)
	 {
		 //
	 }
	 
	 @Override
	 public void inAAtribuicaoComando(AAtribuicaoComando node)
	 {
		 Hashtable tabelaDeSimbolos = (Hashtable) getPilha().peek();
		 String variavel = "["+ node.getVariavel().toString() + "]";
		 Simbolo simboloVariavel = (Simbolo) tabelaDeSimbolos.get(variavel);
		 if (conferirTipo(simboloVariavel.getTipo(), node.getExpr().toString())) {
			 Simbolo simbolo = new Simbolo(node.getExpr().toString(), node.getVariavel().toString());
			 tabelaDeSimbolos.put(simbolo.getId(), simbolo);
		 } else {
			 System.out.println("-------------------------------------------------");
			 System.out.println("Erro: Atribuição incorreta");
			 System.out.println(node.getExpr().toString() + " não é do tipo " + simboloVariavel.getTipo());
			 System.out.println("Análise Semântica Encerrada.");
			 System.out.println("-------------------------------------------------");
			 System.exit(0);
		 }
	 }

}
