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
      //Alfabetos
    char[] hexNum={ '0','x','-','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','A','B','C','D','E','F'};
    char[] ids={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    char[] strings={' ', '!','#', '$', '%', '&','(',')','*','+',',','.','/','0','1','2','3','4','5','6','7','8','9',':',';','<','=','>','?','@','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','[',']','^','_','`','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','{','|','}','~','\\','"','\'',};// check n t later if it doesn't work
        return TokenStream;
}






}


