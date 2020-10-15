package parser;


import scanner.Token;

import java.util.*;

public class Parser {

    static void shift(Stack st, Stack to, Token token, int a) { //Mete un token al stack de tokens y un estado al stack de estados
        st.push(a);
        System.out.println("States: " + st);
        String tokenItem= token.Token;
        to.push(tokenItem);
        System.out.println("Tokens: " + to);
    }

    static void goTo(Stack st, int a) { //mete un estado al stack de estados
        st.push(a);
        System.out.println("States: " + st);
    }

    static void reduce(Stack st, Stack to, int num) { //Se sacan los tokens que se pueden simplificar y se sacan la cantidad de estados que diga
        for(int i =0; i < num; i++){
            System.out.print("pop -> ");
            Integer a = (Integer) st.pop();
            System.out.println(a);
        }
        System.out.println("Tokens: " + st);

        //Pop from Tokens
        for(int i =0; i < num; i++){
            System.out.print("pop -> ");
            Integer b = (Integer) to.pop();
            System.out.println(b);
        }
        System.out.println("Tokens: " + to);

    }
    static  void error(){
        System.out.println("Token not valid");
    }

    public static void main(String[] args)  {
        Stack stkTokens = new Stack();
        Stack stkStates = new Stack();
        stkStates.push(0);


        //ACTIONS TABLE ARRAYS
        String [] inputSymbols = {"(",")","$","X"};
        String[][] grammar = {{"shift 2","error", "error","goto 1"},
                          {"error","error","accept",},
                          {"shift 2","shift 4","error","goto 3"},
                          {"error","shift 5","error",},
                          {"reduce 3","reduce 3","reduce 3"},
                          {"reduce 2","reduce 2","reduce 2"}};



        List<Token> listTokens = new ArrayList<Token>();
        listTokens.add(new Token("(","terminal"));
        listTokens.add(new Token("(","terminal"));
        listTokens.add(new Token(")","terminal"));
        listTokens.add(new Token(")","terminal"));

        int tokensCounter=0;
        int listzise=listTokens.size();

        for (int i = 0; i < grammar.length; i++){
            for (int j = 0; j < grammar[i].length; j++){
                if (inputSymbols[j]==listTokens.get(tokensCounter).Token){
                    String expression=grammar[i][j];

                    String[] expressionarr = expression.split(" ");
                    switch (expressionarr[0]) {
                        case "shift":
                            int k=Integer.parseInt(expressionarr[1]);
                            System.out.println("shift to s"+k);
                            shift(stkStates,stkTokens,listTokens.get(tokensCounter),k);
                            i=k-1;
                            tokensCounter++;
                            break;
                        case "goTo":
                            int l=Integer.parseInt(expressionarr[1]);
                            System.out.println("goto s"+l);
                            goTo(stkStates,l);
                            i=l-1;
                            tokensCounter++;
                            break;
                        case "reduce":
                            int m=Integer.parseInt(expressionarr[1]);
                            System.out.println("reduce ("+m+")");
                            reduce(stkStates,stkTokens,m);
                            i=m-1;
                            tokensCounter++;
                            break;
                        //case "error":
                           // error();
                            //break;

                    }
                }
            }
        }


    }
}
