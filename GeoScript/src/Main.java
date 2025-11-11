import org.antlr.runtime.*;
import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        // Se non viene passato un file, usa test.geo come default
        String inputFile = (args.length > 0) ? args[0] : "test.geo";
        InputStream is = new FileInputStream(inputFile);

        // Lexer → TokenStream → Parser
        ANTLRInputStream input = new ANTLRInputStream(is);
        GeoScriptLexer lexer = new GeoScriptLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GeoScriptParser parser = new GeoScriptParser(tokens);

        // Avvia la regola principale
        parser.prog();
    }
}
