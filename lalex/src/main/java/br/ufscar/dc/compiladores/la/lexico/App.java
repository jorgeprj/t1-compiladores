package br.ufscar.dc.compiladores.la.lexico;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

import java.nio.charset.StandardCharsets;
import java.io.FileWriter;
import java.io.IOException;

public class App {

    public static void main(String[] args) {
        try {
            CharStream cs = CharStreams.fromFileName(args[0], StandardCharsets.UTF_8);
            LALexer lex = new LALexer(cs);
            Token t;
            String filename = args[1];

            try (FileWriter writer = new FileWriter(filename)) {
                while ((t = lex.nextToken()).getType() != Token.EOF) {
                    switch (t.getType()) {
                        case LALexer.ERRO:
                            writer.write("Linha " + t.getLine() + ": " + t.getText() + " - símbolo não identificado\n");
                            break;
                        case LALexer.COMENTARIO_NAO_FECHADO:
                            writer.write("Linha " + t.getLine() + ": comentário não fechado\n");
                            break;
                        case LALexer.CADEIA_NAO_FECHADA:
                            writer.write("Linha " + t.getLine() + ": cadeia literal não fechada\n");
                            break;
                        default:
                            String displayName = LALexer.VOCABULARY.getDisplayName(t.getType());
                            writer.write("<'" + t.getText() + "','" + displayName + "'>\n");
                            break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}