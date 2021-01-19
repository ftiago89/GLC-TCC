package syntaticsmartsubwaytest;

import java.util.ArrayList;


public class SyntaticAnalyzer {
    
    private ArrayList<Token> tokens;
    private int index;
    private Token current;
    private int contadorTermo;

    public SyntaticAnalyzer(ArrayList<Token> tokens) {
        this.tokens = tokens;
        this.index = 0;
        this.contadorTermo = 0;
    }
    
    
    public void Analyze() throws Exception{
        nextToken();
        funcaoAvaliacao();
    }
    
    private void funcaoAvaliacao() throws Exception{
        expressao();
    }
    
    
    private void expressao() throws Exception{
        if ((current.getType().equalsIgnoreCase("Identificador")) || (current.getType().equalsIgnoreCase("Funcao"))
                || (current.getContent().equalsIgnoreCase("(")) || (current.getType().equalsIgnoreCase("Inteiro"))
                || (current.getType().equalsIgnoreCase("Real")) || (current.getContent().equalsIgnoreCase("$"))){
            //nextToken();
            ++contadorTermo;
            termo();
            --contadorTermo;
            expressao2();
        }else{
            if (current.getType().equalsIgnoreCase("Unario")){
                nextToken();
                ++contadorTermo;
                termo();
                --contadorTermo;
                expressao2();
            }else{
                throw new Exception("Erro sintatico.");
            }
        }
    }
    
    private void expressao2() throws Exception{
        if (current.getType().equalsIgnoreCase("Aditivo")){
            nextToken();
            ++contadorTermo;
            termo();
            --contadorTermo;
            expressao2();
        }else{
            if ((contadorTermo == 0) && (!current.getType().equalsIgnoreCase("FIM"))){
                throw new Exception("Erro sintatico.");
            }
        }
    }
    
    private void termo() throws Exception{
        if ((current.getType().equalsIgnoreCase("Identificador")) || (current.getType().equalsIgnoreCase("Funcao"))
                || (current.getContent().equalsIgnoreCase("(")) || (current.getType().equalsIgnoreCase("Inteiro"))
                || (current.getType().equalsIgnoreCase("Real")) || (current.getContent().equalsIgnoreCase("$"))){
            //nextToken();
            ++contadorTermo;
            fator();
            --contadorTermo;
            termo2();
        }else{
            throw new Exception("Erro sintatico.");
        }
    }
    
    private void termo2() throws Exception{
        System.out.println(current.getContent());
        if (current.getType().equalsIgnoreCase("Multiplicativo")){
            nextToken();
            fator();
            termo2();
        }
    }
    
    private void fator() throws Exception{
        if (current.getType().equalsIgnoreCase("Identificador")){
            nextToken();
            if (current.getContent().equalsIgnoreCase("(")){
                nextToken();
                indices();
                if (current.getContent().equalsIgnoreCase(")")){
                    nextToken();
                }else{
                    throw new Exception("Erro sintatico.");
                }
            }
                
        }else{
            if (current.getType().equalsIgnoreCase("Funcao")){
                nextToken();
                if (current.getContent().equalsIgnoreCase("(")){
                    nextToken();
                    expressao();
                    if (current.getContent().equalsIgnoreCase(")")){
                        nextToken();
                    }else{
                        throw new Exception("Erro sintatico.");
                        
                    }
                }else{
                    throw new Exception("Erro sintatico.");
                }
            }else{
                if (current.getContent().equalsIgnoreCase("(")){
                    nextToken();
                    expressao();
                    if (current.getContent().equalsIgnoreCase(")")){
                        nextToken();
                    }else{
                        throw new Exception("Erro sintatico.");
                    }
                }else{
                    if ((current.getType().equalsIgnoreCase("Inteiro")) || (current.getType().equalsIgnoreCase("Real"))){
                        numero();
                    }else{
                        if (current.getContent().equalsIgnoreCase("$")) {
                            nextToken();
                            if (current.getContent().equalsIgnoreCase("(")) {
                                nextToken();
                                if (current.getType().equalsIgnoreCase("Identificador")) {
                                    nextToken();
                                    if (current.getContent().equalsIgnoreCase(",")) {
                                        nextToken();
                                        if (current.getType().equalsIgnoreCase("Inteiro")) {
                                            nextToken();
                                            if (current.getContent().equalsIgnoreCase(",")) {
                                                nextToken();
                                                if ((current.getType().equalsIgnoreCase("Identificador")) || (current.getType().equalsIgnoreCase("Inteiro"))) {
                                                    nextToken();
                                                    if (current.getContent().equalsIgnoreCase(",")) {
                                                        nextToken();
                                                        expressao();
                                                        if (current.getContent().equalsIgnoreCase(")")) {
                                                            nextToken();                                                          
                                                        }else{
                                                            throw new Exception("Erro sintatico.");
                                                        }
                                                    }else{
                                                        throw new Exception("Erro sintatico.");
                                                    }
                                                }else{
                                                    throw new Exception("Erro sintatico.");
                                                }
                                            }else{
                                                throw new Exception("Erro sintatico.");
                                            }
                                        }else{
                                            throw new Exception("Erro sintatico.");
                                        }
                                    }else{
                                        throw new Exception("Erro sintatico.");
                                    }
                                }else{
                                    throw new Exception("Erro sintatico.");
                                }
                            }else{
                                throw new Exception("Erro sintatico.");
                            }
                        }else{
                            throw new Exception("Erro sintatico.");
                        }
                    }
                }
            }
        }
    }
    
    private void numero() throws Exception{
        if ((current.getType().equalsIgnoreCase("Inteiro")) || (current.getType().equalsIgnoreCase("Real"))){
            nextToken();
        }else{
            throw new Exception("Erro sintatico.");
        }
    }
    
    private void indices() throws Exception{
        if (current.getContent().equalsIgnoreCase("^")){
            nextToken();
            fator();
            indices2();
        }else{
            if (current.getContent().equalsIgnoreCase("_")) {
                nextToken();
                indiceInferior();
            }else{
                throw new Exception("Erro sintatico.");
            }
        }
        
        
    }
    
    private void indiceInferior() throws Exception{
        if ((current.getType().equalsIgnoreCase("Identificador")) || (current.getType().equalsIgnoreCase("Inteiro")) || (current.getType().equalsIgnoreCase("Real"))){
            nextToken();
            indices2();
        }else{
            throw new Exception("Erro sintatico.");
        }
    }
    
    private void indices2()throws Exception{
        if (current.getContent().equalsIgnoreCase(",")){
            nextToken();
            if (current.getContent().equalsIgnoreCase("_")){
                nextToken();
                if ((current.getType().equalsIgnoreCase("Identificador")) || (current.getType().equalsIgnoreCase("Inteiro")) || (current.getType().equalsIgnoreCase("Real"))){
                    nextToken();
                    indices2();
                }else{
                    throw new Exception("Erro sintatico.");
                }
            }else{
                throw new Exception("Erro sintatico.");
            }
            
        }
    }
    
    private void funcao() throws Exception{
        if (current.getType().equalsIgnoreCase("Funcao")){
            nextToken();
        }else{
            throw new Exception("Erro sintatico.");
        }
    }
    
    private void identificador() throws Exception{
        if (current.getType().equalsIgnoreCase("Identificador")){
            nextToken();
        }else{
            throw new Exception("Erro sintatico.");
        }
    }
    
    private void opUnario() throws Exception{
        if (current.getType().equalsIgnoreCase("Unario")){
            nextToken();
        }else{
            throw new Exception("Erro sintatico.");
        }
    }
    
    private void opAditivo() throws Exception{
        if (current.getType().equalsIgnoreCase("Aditivo")){
            nextToken();
        }else{
            throw new Exception("Erro sintatico.");
        }
    }
    
    private void opRelacional() throws Exception{
        if (current.getContent().equalsIgnoreCase("=")){
            nextToken();
        }else{
            if (current.getContent().equalsIgnoreCase("<")){
                nextToken();
                if (current.getContent().equalsIgnoreCase("=")){
                    nextToken();
                }
            }else{
                if (current.getContent().equalsIgnoreCase(">")){
                    nextToken();
                    if (current.getContent().equalsIgnoreCase("=")){
                        nextToken();
                    }
                }else{
                    if (current.getContent().equalsIgnoreCase("!")){
                        nextToken();
                        if (current.getContent().equalsIgnoreCase("=")){
                            nextToken();
                        }else{
                            throw new Exception("Erro sintatico.");
                        }
                    }else{
                        throw new Exception("Erro sintatico.");
                    }
                }
            }
        }
    }
    
    private void opMultiplicativo(){
        if (current.getType().equalsIgnoreCase("Multiplicativo")){
            nextToken();
        }
    }
    
    private void nextToken(){
        if (index < tokens.size()){
            current = tokens.get(index);
            ++index;
        }else{
            current = new Token("null", "FIM");
        }
        
    }
    
    private void seeNextToken(){
        
    }
}
