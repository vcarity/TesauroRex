/* Create an AST, then invoke our interpreter. */ 
import tesauroRex.interpret.Interpreter;
import tesauroRex.parser.* ;
import tesauroRex.lexer.* ;
import tesauroRex.node.* ;
 
import java.io.* ;
 
public class Main {
   public static void main(String[] args) {
      if (args.length > 0) {
         try {
            /* Form our AST */
            Lexer lexer = new Lexer (new PushbackReader(
               new FileReader(args[0]), 1024));
            Parser parser = new Parser(lexer);
            Start ast = parser.parse() ;
 
            /* Get our Interpreter going. */
            Interpreter interp = new Interpreter () ;
            ast.apply(interp) ;
         }
         catch (Exception e) {
            System.out.println (e) ;
         }
      } else {
         System.err.println("usage: java tesauroRex inputFile");
         System.exit(1);
      }
   }
} 