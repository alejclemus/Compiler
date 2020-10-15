package scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TScanner {

    public static boolean symbols(String parameter) {
        String[] dictSymbols = {"+", "-", "*", "/", "<", ">", "=", "<=", ">=", "!=", "==", "%", "&&", "||"};
        List<String> listSymbol = Arrays.asList(dictSymbols);
        return listSymbol.contains(parameter);
    }

    public static boolean brackets(String parameter) {
        String[] dictBracket = {"{", "(", "[", ";", ",", "]", ")", "}"};
        List<String> listBracket = Arrays.asList(dictBracket);
        return listBracket.contains(parameter);
    }

    public static boolean keywords(String parameter) {
        String[] dictKeyword = {"Class", "Program", "void", "else", "if", "true", "false", "boolean", "for", "int", "callout", "break", "continue", "return"};
        List<String> listKeyword = Arrays.asList(dictKeyword);
        return listKeyword.contains(parameter);
    }

    public static List Scan(Scanner in) {
        ArrayList<Token> tokenStream = new ArrayList<>();
//alfabetos
        char[] numeros = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

        return tokenStream;
    }

    public static String AutomataVerification(char[] tokens, int[][] automata, int type, char[] a) {
        // State #1
        int state = 1;
        boolean A = false;
        boolean B = false;

        for (int i = 0; i < tokens.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (tokens[i] == a[i]) {
                    state = automata[state - 1][i];
                    A = true;
                    break;
                }
            }
            if (!A || state == 0) {
                B = false;
                break;
            } else {
                A = false;
                B = true;
            }

            if (B == true) {
                if (type == 1) {
                    if (state == 5) {
                        return "char_literal";
                    } else {
                        return "error char";
                    }
                } else if (type == 2) {
                    if (state == 4) {
                        return "string_literal";
                    } else {
                        return "error string";
                    }
                } else if (type == 3) {
                    if (state == 2 || state == 3) {
                        return "decimal";
                    } else if (state == 5) {
                        return "hex";
                    } else {
                        return " error hex or decimal";
                    }
                } else if (type == 4) {
                    if (state == 2) {
                        return "identidfier";
                    } else {
                        return "error identifier";
                    }
                }
            } else {
                return "error";
            }

        }
        return "error";
    }

public static String AutomataToken(char[][] alpha, int[][][] automaton, String token, Token Ntoken){
        String Tokenn = token;
        Ntoken.Tokentype = Tokenn;

        if(keywords(Tokenn)){
            Ntoken.Token = "keyword";
        } else if (brackets(Tokenn)){
            Ntoken.Token = "bracket";
        }else if (symbols(Tokenn)){
            Ntoken.Token ="operator";
        }else{
           char excl[]= Tokenn.toCharArray();
           if(excl[0]=='\''){
               Ntoken.Token = AutomataVerification(excl, automaton[3], 1, alpha[2]);
           }else if(excl[0] == '\"'){
               Ntoken.Token = AutomataVerification(excl, automaton[2], 2, alpha[2]);
            } else if( excl[0]=='0'||excl[0]=='1'||excl[0]=='2'||excl[0]=='3'||excl[0]=='4'||excl[0]=='5'||excl[0]=='6'||excl[0]=='7'||excl[0]=='8'||excl[0]=='9'){
               Ntoken.Token = AutomataVerification(excl, automaton[0], 3, alpha[0]);
           } else{
               Ntoken.Token = AutomataVerification(excl, automaton[1], 4, alpha[1]);
           }
        }
return Ntoken.Token;
}


public static ArrayList MainScan (Scanner in){
      ArrayList<Token> TokenStream = new ArrayList<>();
      ArrayList<String> lexemas = new ArrayList<String>();
      ArrayList<String> errores = new ArrayList<String>();
      int errorLine = 1;
      int errorColumn = 1;
      String cToken ="";
      String error ="";


      //Alfabetos
    char[] hexNum={ '0','x','-','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','A','B','C','D','E','F'};
    char[] ids={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    char[] strings={' ', '!','#', '$', '%', '&','(',')','*','+',',','.','/','0','1','2','3','4','5','6','7','8','9',':',';','<','=','>','?','@','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','[',']','^','_','`','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','{','|','}','~','\\','"','\'',};// check n t later if it doesn't work
    char[][] alphab ={hexNum, ids, strings};
    // Automatas
    int[][] characaut = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0 },
            { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 0, 5, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },};
    int[][] stringaut = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0 },
            { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 4, 0, 2, 2 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }};
    int[][] identaut = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
            { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 } };
    int[][] numaut = { { 2, 0, 6, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 3, 4, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 3, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 5, 0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
            { 5, 0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
            { 3, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
    int[][][] auto ={numaut,identaut,stringaut,characaut};

    // separacion linea por linea
    while(in.hasNextLine()){
        String fileLine= in.nextLine();
        // recorrer linea por linea
        for (int i = 0; i <fileLine.length() ; i++) {
            char toAnalyze = fileLine.charAt(i);
            char upNext;
            error = "Error en la linea "+Integer.toString(errorLine);
            if( i != (fileLine.length()-1)){
                upNext = fileLine.charAt(i+1);
            }else{
                upNext ='$';
                errorColumn = 0;
            }
            if(toAnalyze == '/' && upNext =='/'){
                errorColumn=0;
                break;
            }
            if(toAnalyze != ' '&& toAnalyze!= '\t'){
                cToken +=toAnalyze;
                if(upNext == ' '|| upNext == '$'){
                    lexemas.add(cToken);
                    errores.add(error);
                    cToken= "";
                }
            }
            errorColumn += 1;
        }
        errorLine+= 1;
    }

    // analizar lexemas
    for (int i = 0; i < lexemas.size() ; i++) {
        Token tempToken = new Token("", "");
        AutomataToken(alphab, auto, lexemas.get(i), tempToken);
        boolean lexm = true;
        String possible ="";
        String possibleX="";
        if(lexemas.get(i).charAt(0)=='"'){
            for (int j = i; j < lexemas.size(); j++) {
                String iToken = lexemas.get(j);
                possible += iToken;
                possibleX += iToken+" ";

                if(iToken.charAt(iToken.length()-1)=='"'){
                    Token temp = new Token("", "");
                    AutomataToken(alphab, auto, possible, temp);
                    if(!temp.Token.equals("error")){
                        tempToken.Token = temp.Token;
                        tempToken.Tokentype= possibleX;
                        i=j;
                    }
                    break;
                }

            }
        }
        if(tempToken.Token == "error"){
            String pos="";
            String poss="";
            for (int j = 0; j <tempToken.Tokentype.length() ; j++) {
                pos += tempToken.Tokentype.charAt(j);
                Token tok3 = new Token("", "");
                AutomataToken(alphab, auto, pos, tok3);

                if(tok3.Token != "error"){
                    if( j != tempToken.Tokentype.length()-1){
                        poss = pos + tempToken.Tokentype.charAt(j+1);
                    } else {
                        poss = pos;
                    }
                    Token token4 = new Token ("", "");
                    AutomataToken(alphab, auto,poss, token4);
                    if(token4.Token =="error"){
                        TokenStream.add(tok3);
                        pos="";
                    }
                    lexm = false;
                }else{
                    lexm = true;
                }
            }
        }
        if(lexm){
            TokenStream.add(tempToken);
            if(tempToken.Token == "error"){
                System.out.println(errores.get(i));
            }
        }

    }
        return TokenStream;
}






}


