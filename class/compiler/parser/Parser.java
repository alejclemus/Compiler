package parser;


import scanner.Token;

import java.util.Hashtable;
import java.util.Stack;

public class Parser {

    static void shift(Stack st, Stack to, Token token, int a) {
        st.push(a);
        System.out.println("States: " + st);
        to.push(token);
        System.out.println("Tokens: " + st);
    }

    static void goTo(Stack st, int a) {
        st.push(a);
        System.out.println("States: " + st);
    }

    static void reduce(Stack st, Stack to) {
        System.out.print("pop -> ");
        Integer a = (Integer) st.pop();
        System.out.println(a);
        System.out.println("Tokens: " + st);

        //Pop from Tokens
        System.out.print("pop -> ");
        Integer b = (Integer) to.pop();
        System.out.println(a);
        System.out.println("Tokens: " + to);

    }
    static  void error(){
        System.out.println("Token not valid");
    }

    public static void main(String[] args)  {
        Stack stkTokens = new Stack();
        Stack stkStates = new Stack();
        int states_counter= 0;

        stkStates.push(0);
        System.out.println("stackTokens: " + stkTokens);
        System.out.println("stackStates: " + stkStates);

        //ACTIONS TABLE ARRAYS
        String [] inputSymbols = {"(",")","$","X"};
        String[][] grammar = {{"shift 2","error", "error","goto 1"},
                          {"error","error","accept",},
                          {"shift 2","shift 4","error","goto 3"},
                          {"error","shift 5","error",},
                          {"reduce 3","reduce 3","reduce 3"},
                          {"reduce 2","reduce 2","reduce 2"}};


        Token token =new Token("(","terminal","(",0);
        Token token2 =new Token("(","terminal","(",1);
        Token token3 =new Token(")","terminal",")",1);


        String currentToken=token.getToken;

        for (int i = 0; i < grammar.length; i++){
            for (int j = 0; j < grammar[i].length; j++){
                if (inputSymbols[j]==currentToken){
                    System.out.println(i);
                    System.out.println(j);
                    String expression=grammar[i][j];

                    System.out.println(expression);
                    switch (expression) {
                        case "shift":
                            states_counter=states_counter+1;
                            shift(stkStates,stkTokens,token,states_counter);
                            break;
                        case "goTo":
                            states_counter=states_counter+1;
                            goTo(stkStates,states_counter);
                            break;
                        case "reduce":
                            states_counter=states_counter+1;
                            reduce(stkStates,stkTokens);
                            break;
                        case "error":
                            error();
                            break;

                    }

                }
            }
        }


    }
}
