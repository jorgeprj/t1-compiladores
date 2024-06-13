package br.ufscar.dc.compiladores.novo.la.lexico;

import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class App {

    public static void main(String[] args) {
        String arquivoSaida = args[1];
        
        try (PrintWriter pw = new PrintWriter(arquivoSaida)) {
            CharStream cs = CharStreams.fromFileName(args[0]);
            LaLexer lex = new LaLexer(cs);
            Token t;

            while ((t = lex.nextToken()).getType() != Token.EOF) {
                String nomeToken = LaLexer.VOCABULARY.getDisplayName(t.getType());
                String mensagem = null;
                
                switch (nomeToken) {
                    case "SIMBOLO_NAO_ENCONTRADO":
                        mensagem = "Linha " + t.getLine() + ": " + t.getText() + " - simbolo nao identificado";
                        break;
                    case "COMENTARIO_NAO_FECHADO":
                        mensagem = "Linha " + t.getLine() + ": comentario nao fechado";
                        break;
                    case "CADEIA_LITERAL_NAO_FECHADA":
                        mensagem = "Linha " + t.getLine() + ": cadeia literal nao fechada";
                        break;
                    default:
                        mensagem = "<'" + t.getText() + "'," + nomeToken + ">";
                        break;
                }

                pw.println(mensagem);
                pw.flush();

                if (mensagem.contains("simbolo nao identificado") || mensagem.contains("comentario nao fechado") || mensagem.contains("cadeia literal nao fechada")) {
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
