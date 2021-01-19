package syntaticsmartsubwaytest;

import java.util.ArrayList;


public class SyntaticSmartSubwayTest {

    
    public static void main(String[] args) throws Exception {
        ArrayList<Token> tokens = new ArrayList<>();
        SyntaticAnalyzer analyzer;
        
        //função de mayrton, inverso da energia
        /*
        tokens.add(new Token("1", "Inteiro"));
        tokens.add(new Token("/", "Multiplicativo"));
        tokens.add(new Token("(", "Delimitador"));
        tokens.add(new Token("(", "Delimitador"));
        tokens.add(new Token("massa", "Identificador"));
        tokens.add(new Token("*", "Multiplicativo"));
        tokens.add(new Token("velocidade", "Identificador"));
        tokens.add(new Token("(", "Delimitador"));
        tokens.add(new Token("^", "Delimitador"));
        tokens.add(new Token("2", "Inteiro"));
        tokens.add(new Token(")", "Delimitador"));
        tokens.add(new Token(")", "Delimitador"));
        tokens.add(new Token("/", "Multiplicativo"));
        tokens.add(new Token("2", "Inteiro"));
        tokens.add(new Token(")", "Delimitador"));
        */
        
        //FUNCAO MAPEAMENTO SISTEMATICO ARTIGO 3
        /*
        tokens.add(new Token("MI", "Funcao"));
        tokens.add(new Token("(", "Delimitador"));
        tokens.add(new Token("Ftr", "Identificador"));
        tokens.add(new Token("*", "Multiplicativo"));
        tokens.add(new Token("v", "Identificador"));
        tokens.add(new Token("*", "Multiplicativo"));
        tokens.add(new Token("t", "Identificador"));
        tokens.add(new Token(")", "Delimitador"));
        tokens.add(new Token("*", "Multiplicativo"));
        tokens.add(new Token("we", "Identificador"));
        tokens.add(new Token("+", "Aditivo"));
        tokens.add(new Token("MI", "Funcao"));
        tokens.add(new Token("(", "Delimitador"));
        tokens.add(new Token("T", "Identificador"));
        tokens.add(new Token(")", "Delimitador"));
        tokens.add(new Token("*", "Multiplicativo"));
        tokens.add(new Token("wt", "Identificador"));
        */
        
        //FUNCAO MAPEAMENTO SISTEMATICO ARTIGO 4
        /*
        tokens.add(new Token("$", "Especial"));
        tokens.add(new Token("(", "Delimitador"));
        tokens.add(new Token("i", "Identificador"));
        tokens.add(new Token(",", "Delimitador"));
        tokens.add(new Token("1", "Inteiro"));
        tokens.add(new Token(",", "Delimitador"));
        tokens.add(new Token("n", "Identificador"));
        tokens.add(new Token(",", "Delimitador"));
        tokens.add(new Token("E", "Identificador"));
        tokens.add(new Token("(", "Delimitador"));
        tokens.add(new Token("^", "Delimitador"));
        tokens.add(new Token("q", "Identificador"));
        tokens.add(new Token(",", "Delimitador"));
        tokens.add(new Token("_", "Delimitador"));
        tokens.add(new Token("i", "Identificador"));
        tokens.add(new Token(")", "Delimitador"));
        tokens.add(new Token("*", "Multiplicativo"));
        tokens.add(new Token("(", "Delimitador"));
        tokens.add(new Token("T", "Identificador"));
        tokens.add(new Token("(", "Delimitador"));
        tokens.add(new Token("^", "Delimitador"));
        tokens.add(new Token("q", "Identificador"));
        tokens.add(new Token(",", "Delimitador"));
        tokens.add(new Token("_", "Delimitador"));
        tokens.add(new Token("i", "Identificador"));
        tokens.add(new Token(")", "Delimitador"));
        tokens.add(new Token(")", "Delimitador"));
        tokens.add(new Token(")", "Delimitador"));
        */
        
        //FUNCAO MAPEAMENTO SISTEMATICO ARTIGO 16
        /*
        tokens.add(new Token("$", "Especial"));
        tokens.add(new Token("(", "Delimitador"));
        tokens.add(new Token("k", "Identificador"));
        tokens.add(new Token(",", "Delimitador"));
        tokens.add(new Token("0", "Inteiro"));
        tokens.add(new Token(",", "Delimitador"));
        tokens.add(new Token("N", "identificador"));
        tokens.add(new Token(",", "Delimitador"));
        tokens.add(new Token("(", "Delimitador"));
        tokens.add(new Token("F", "Identificador"));
        tokens.add(new Token("(", "Delimitador"));
        tokens.add(new Token("_", "Delimitador"));
        tokens.add(new Token("k", "Identificador"));
        tokens.add(new Token(")", "Delimitador"));
        tokens.add(new Token("*", "Multiplicativo"));
        tokens.add(new Token("v", "identificador"));
        tokens.add(new Token("(", "Delimitador"));
        tokens.add(new Token("_", "Delimitador"));
        tokens.add(new Token("k", "Identificador"));
        tokens.add(new Token(")", "Delimitador"));
        tokens.add(new Token(")", "Delimitador"));
        tokens.add(new Token("/", "Multiplicativo"));
        tokens.add(new Token("(", "Delimitador"));
        tokens.add(new Token("2650", "Inteiro"));
        tokens.add(new Token("*", "Multiplicativo"));
        tokens.add(new Token("n", "identificador"));
        tokens.add(new Token(")", "Delimitador"));
        tokens.add(new Token("*", "Multiplicativo"));
        tokens.add(new Token("deltaT", "identificador"));
        tokens.add(new Token("+", "Aditivo"));
        tokens.add(new Token("P", "Identificador"));
        tokens.add(new Token(")", "Delimitador"));
        */
        
        //FUNCAO MAPEAMENTO SISTEMATICO ARTIGO 18
        /*
        tokens.add(new Token("(", "Delimitador"));
        tokens.add(new Token("F", "Identificador"));
        tokens.add(new Token("*", "Multiplicativo"));
        tokens.add(new Token("v", "Identificador"));
        tokens.add(new Token(")", "Delimitador"));
        
        tokens.add(new Token("/", "Multiplicativo"));
        tokens.add(new Token("(", "Delimitador"));
        
        tokens.add(new Token("(", "Delimitador"));
        tokens.add(new Token("u", "Identificador"));
        tokens.add(new Token("*", "Multiplicativo"));
        tokens.add(new Token("i", "Identificador"));
        tokens.add(new Token("*", "Multiplicativo"));
        tokens.add(new Token("cos", "Funcao"));
        tokens.add(new Token("(", "Delimitador"));
        tokens.add(new Token("theta", "Identificador"));
        tokens.add(new Token(")", "Delimitador"));
        tokens.add(new Token(")", "Delimitador"));
        
        tokens.add(new Token("-", "Aditivo"));       
        tokens.add(new Token("Paux", "Identificador"));
        
        tokens.add(new Token(")", "Delimitador"));
        */
     
        analyzer = new SyntaticAnalyzer(tokens);
        
        analyzer.Analyze();
    }
    
}
