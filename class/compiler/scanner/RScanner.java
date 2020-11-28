package scanner;

import scanner.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class RScanner {
    public static boolean symbols(String parameter) {
        String dictSymbols[] = {"=", "!", "*", "/", "%", "+", "-", "<", "<=", ">=", ">", "==", "!=", "&&", "||", "+=", "-="};

        List<String> listSymbols = Arrays.asList(dictSymbols);
        if (listSymbols.contains(parameter)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean brackets(String parameter) {
        String dictBrackets[] = {"(", ")", "[", "]", "{", "}", ";", ","};
        List<String> listBRackets = Arrays.asList(dictBrackets);
        if (listBRackets.contains(parameter)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean keywords(String parameter) {
        String dictKeywords[] = {"boolean", "break", "callout", "class", "continue", "else", "false", "for", "if", "int", "return", "true", "void", "main"};
        List<String> list = Arrays.asList(dictKeywords);
        if (list.contains(parameter)) {
            return true;
        } else {
            return false;
        }
    }


    public static String AutomataVerification(int automata[][], int type, char[] tokens, char[] a) {
        int state = 1;
        boolean A = false;
        boolean B = false;
        for (int i = 0; i < tokens.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (tokens[i] == a[j]) {
                    state = automata[state - 1][j];
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
        }
        if (B) {

            if (type == 1) {
                if (state == 5) {
                    return "charLiteral";
                } else {
                    return "error";
                }

            } else if (type == 2) {
                if (state == 4) {
                    return "stringLiteral";
                } else {
                    return "error";
                }

            } else if (type == 3) {
                if (state == 3 || state == 2) {
                    return "literal";
                } else if (state == 5) {
                    return "literal";
                } else {
                    return "error";
                }

            } else if (type == 4) {
                if (state == 2) {
                    return "id";
                } else {
                    return "error";
                }
            }
        } else {

            return "error";
        }

        return "error";
    }

    public static String AutomataToken(String token, Token nextToken, int[][][] automaton, char[][] alpha) {

        String token1 = token;
        nextToken.valor = token1;
        if (keywords(token1)) {
            nextToken.tipo = "Keyword";
        } else if (symbols(token1)) {
            nextToken.tipo = "operator";
        } else if (brackets(token1)) {
            nextToken.tipo = "Bracket";
        } else {
            char excl[] = token1.toCharArray();
            if (excl[0] == '\'') {
                nextToken.tipo = AutomataVerification(automaton[3], 1, excl, alpha[2]);
            } else if (excl[0] == '\"') {
                nextToken.tipo = AutomataVerification(automaton[2], 2, excl, alpha[2]);
            } else if (excl[0] == '0' || excl[0] == '1' || excl[0] == '2' || excl[0] == '3' || excl[0] == '4' || excl[0] == '5' || excl[0] == '6' || excl[0] == '7' || excl[0] == '8' || excl[0] == '9') {
                nextToken.tipo = AutomataVerification(automaton[0], 3, excl, alpha[0]);
            } else {
                nextToken.tipo = AutomataVerification(automaton[1], 4, excl, alpha[1]);
            }
        }
        return nextToken.tipo;
    }


    public static ArrayList MainScan(Scanner scan) {
        ArrayList<Token> stream = new ArrayList<>();
        ArrayList<String> lexem = new ArrayList<String>();
        ArrayList<String> errorList = new ArrayList<String>();
        int linee = 1;
        int column = 1;
        String posible = "";
        String posibleError = "";


        char[] hexNum = {'0', 'x', '-', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] assig = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '_'};
        char[] strings = {' ', '!', '#', '$', '%', '&', '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':', ';', '<', '=', '>', '?', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', ']', '^', '_', '`', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'o', 'p', 'q', 'r', 's', 'u', 'v', 'w', 'x', 'y', 'z', '{', '|', '}', '~', '\\', '"', '\'', 'n', 't'};
        char[][] alpha = {hexNum, assig, strings};

        int[][] numAut = {{2, 0, 6, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {3, 4, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {3, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {5, 0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
                {5, 0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, {3, 0, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int[][] stringAut = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 4, 0, 2, 2},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int[][] characOut = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0},
                {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 0, 5, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},};
        int[][] identAut = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}};
        int[][][] automatas = {numAut, identAut, stringAut, characOut};

        while (scan.hasNextLine()) {
            String line = scan.nextLine();

            for (int i = 0; i < line.length(); i++) {
                char valor = line.charAt(i);
                char ahead;
                posibleError = "error linea " + Integer.toString(linee);

                if (i != (line.length() - 1)) {
                    ahead = line.charAt(i + 1);
                } else {
                    ahead = '$';
                    column = 0;
                }

                if (valor != ' ' && valor != '\t') {
                    posible += valor;

                    if ((ahead == ' ') || ahead == '$') {
                        lexem.add(posible);
                        errorList.add(posibleError);
                        posible = "";
                    }
                }
                if (valor == '/' && ahead == '/') {
                    column = 0;
                    break;
                }


                column += 1;
            }
            linee += 1;
        }

        for (int i = 0; i < lexem.size(); i++) {
            Token token1 = new Token("", "");
            AutomataToken(lexem.get(i), token1, automatas, alpha);
            boolean lexm = true;
            String pos = "";
            String posx = "";

            if (lexem.get(i).charAt(0) == '"') {
                for (int j = i; j < lexem.size(); j++) {
                    String token2 = lexem.get(j);
                    pos += token2;
                    posx += token2 + " ";

                    if (token2.charAt(token2.length() - 1) == '"') {
                        Token token3 = new Token("", "");
                        AutomataToken(pos, token3, automatas, alpha);

                        if (!token3.tipo.equals("error")) {
                            token1.tipo = token3.tipo;
                            token1.valor = posx;
                            i = j;
                        }
                        break;
                    }
                }
            }
            if (token1.tipo.equals("error")) {
                String sa = "";
                String sb = "";

                for (int k = 0; k < token1.valor.length(); k++) {
                    sa += token1.valor.charAt(k);

                    Token token4 = new Token("", "");
                    AutomataToken(sa, token4, automatas, alpha);

                    if (!token4.tipo.equals("error")) {
                        if (k != token1.valor.length() - 1) {
                            sb = sa + token1.valor.charAt(k + 1);
                        } else {
                            sb = sa;
                        }

                        Token token5 = new Token("", "");
                        AutomataToken(sb, token5, automatas, alpha);

                        if (token5.tipo.equals("error")) {
                            stream.add(token4);
                            //System.out.println('"' + token4.tipo + ", " + token4.valor + '"');
                            sa = "";
                        }
                        lexm = false;
                    } else {
                        lexm = true;
                    }
                }
            }

            if (lexm) {
                stream.add(token1);
                //System.out.println('"' + token1.tipo + ", " + token1.valor + '"');
                if (token1.tipo.equals("error")) {
                    System.out.println(errorList.get(i));
                }
            }
        }
        StreamCorrection(stream);
       return stream;
    }

    public static ArrayList StreamCorrection(ArrayList<Token> stream) {
        ArrayList<Token> newTokenStream = new ArrayList<>();

        System.out.println(stream.size());

        for (int i = 0; i < stream.size(); i++) {

            Token toCorrect = new Token(stream.get(i).tipo, stream.get(i).valor);

            if (toCorrect.valor.equals("int") || toCorrect.valor.equals("boolean")) {
                toCorrect.tipo = "type";
                newTokenStream.add(toCorrect);
            } else if (toCorrect.valor.equals("class")) {
                toCorrect.tipo = "class";
                newTokenStream.add(toCorrect);
            } else if (toCorrect.valor.equals("program")) {
                toCorrect.tipo = "program";
                newTokenStream.add(toCorrect);
            }  else if (toCorrect.valor.equals("void")) {
                toCorrect.tipo = "void";
                newTokenStream.add(toCorrect);
            }else if (toCorrect.valor.equals("}")) {
                toCorrect.tipo = "}";
                newTokenStream.add(toCorrect);
            } else if (toCorrect.valor.equals("{")) {
                toCorrect.tipo = "{";
                newTokenStream.add(toCorrect);
            }else if (toCorrect.valor.equals("]")) {
                toCorrect.tipo = "]";
                newTokenStream.add(toCorrect);
            }else if (toCorrect.valor.equals("[")) {
                toCorrect.tipo = "[";
                newTokenStream.add(toCorrect);
            } else if (toCorrect.valor.equals(",")) {
                toCorrect.tipo = ",";
                newTokenStream.add(toCorrect);
            } else if (toCorrect.valor.equals(";")) {
                toCorrect.tipo = ";";
                newTokenStream.add(toCorrect);
            } else if (toCorrect.valor.equals(")")) {
                toCorrect.tipo = ")";
                newTokenStream.add(toCorrect);
            } else if (toCorrect.valor.equals("(")) {
                toCorrect.tipo = "(";
                newTokenStream.add(toCorrect);
            } else if (toCorrect.valor.equals("$")) {
                toCorrect.tipo = "$";
                newTokenStream.add(toCorrect);
            } else if (toCorrect.valor.equals("if")) {
                toCorrect.tipo = "if";
                newTokenStream.add(toCorrect);
            } else if (toCorrect.valor.equals("else")) {
                toCorrect.tipo = "else";
                newTokenStream.add(toCorrect);
            } else if (toCorrect.valor.equals("return")) {
                toCorrect.tipo = "return";
                newTokenStream.add(toCorrect);
            } else if (toCorrect.valor.equals("break")) {
                toCorrect.tipo = "break";
                newTokenStream.add(toCorrect);
            } else if (toCorrect.valor.equals("continue")) {
                toCorrect.tipo = "continue";
                newTokenStream.add(toCorrect);
            } else if (toCorrect.valor.equals("for")) {
                toCorrect.tipo = "for";
                newTokenStream.add(toCorrect);
            } else if (toCorrect.valor.equals("=") || toCorrect.valor.equals("+=") || toCorrect.valor.equals("-=")) {
                toCorrect.tipo = "assignation";
                newTokenStream.add(toCorrect);
            }else if (toCorrect.valor.equals("true") || toCorrect.valor.equals("false")) {
                toCorrect.tipo = "literal";
                newTokenStream.add(toCorrect);
            }else if (toCorrect.valor.equals("callout")) {
                toCorrect.tipo = "callout";
                newTokenStream.add(toCorrect);
            }else if(toCorrect.valor.equals("a") || toCorrect.valor.equals("b") ||toCorrect.valor.equals("c") || toCorrect.valor.equals("d")
                    ||toCorrect.valor.equals("e") || toCorrect.valor.equals("f") ||toCorrect.valor.equals("g") || toCorrect.valor.equals("h")
                    ||toCorrect.valor.equals("i") || toCorrect.valor.equals("j") ||toCorrect.valor.equals("k") || toCorrect.valor.equals("l")
                    ||toCorrect.valor.equals("m") || toCorrect.valor.equals("n") ||toCorrect.valor.equals("ñ") || toCorrect.valor.equals("o")
                    ||toCorrect.valor.equals("p") || toCorrect.valor.equals("q") ||toCorrect.valor.equals("r") || toCorrect.valor.equals("s")
                    ||toCorrect.valor.equals("t") || toCorrect.valor.equals("u") ||toCorrect.valor.equals("v") || toCorrect.valor.equals("w")
                    ||toCorrect.valor.equals("x") || toCorrect.valor.equals("y") || toCorrect.valor.equals("z")){
                toCorrect.tipo = "charLiteral";
                newTokenStream.add(toCorrect);
            }else if (toCorrect.valor.equals("!")) {
                toCorrect.tipo = "!";
                newTokenStream.add(toCorrect);
            }else if(stream.get(i-1).valor.equals('"')){}

            else{
                newTokenStream.add(toCorrect);
            }


        }
        for (int a = 0; a < newTokenStream.size(); a++) {
            System.out.println(newTokenStream.get(a).tipo + ", " + newTokenStream.get(a).valor);
        }



        return newTokenStream;
    }
}
