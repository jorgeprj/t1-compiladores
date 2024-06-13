package br.ufscar.dc.compiladores.novo.la.lexico;

import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import java.io.PrintWriter;

public class App {
    public static void main(String[] args) {
        String arquivoSaida = args[1];
        try {
            CharStream cs = CharStreams.fromFileName(args[0]);

            LaLexer lex = new LaLexer(cs);
            Token t = null;

            PrintWriter pw = new PrintWriter(arquivoSaida);

            while ((t = lex.nextToken()).getType() != Token.EOF) {
                String nomeToken = LaLexer.VOCABULARY.getDisplayName(t.getType());
                if (nomeToken.equals("SIMBOLO_NAO_ENCONTRADO")) {
                    pw.println("Linha " + t.getLine() + ": " + t.getText() + " - simbolo nao identificado");
                    break;
                } else if (nomeToken.equals("COMENTARIO_NAO_FECHADO")) {
                    pw.println("Linha " + t.getLine() + ": comentario nao fechado");
                    break;
                } else if (nomeToken.equals("CADEIA_LITERAL_NAO_FECHADA")) {
                    pw.println("Linha " + t.getLine() + ": cadeia literal nao fechada");
                    break;
                } else {
                    pw.println("<'" + t.getText() + "'," + nomeToken + ">");
                }

                pw.flush();
            }

            pw.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}