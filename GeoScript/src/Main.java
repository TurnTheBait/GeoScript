import org.antlr.runtime.*;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        String inputFile = (args.length > 0) ? args[0] : "test.geo";
        InputStream is = new FileInputStream(inputFile);

        ANTLRInputStream input = new ANTLRInputStream(is);
        GeoScriptGrammarLexer lexer = new GeoScriptGrammarLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GeoScriptGrammarParser parser = new GeoScriptGrammarParser(tokens);

        // Avvia la regola principale
        parser.prog();
    }
}
