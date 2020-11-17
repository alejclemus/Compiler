package parser;

import scanner.Token;

import java.util.*;

public class Parser {

    static class Node
    {
        Token key;
        Vector<Node> child;
    };

    static Node newNode(Token key)
    {
        Node temp = new Node();
        temp.key = (Token) key;
        temp.child = new Vector<Node>();
        return temp;
    }

    static void shift(Stack st, Stack to, Token token, int a) { //Mete un token al stack de tokens y un estado al stack de estados
        st.push(a);
        System.out.println("States: " + st);
        String tokenItem= token.tipo;
        to.push(tokenItem);
        System.out.println("Tokens: " + to);
    }

    static void goTo(Stack st, int a) { //mete un estado al stack de estados
        st.push(a);
        System.out.println("States: " + st);
    }

    static void reduce(Stack st, Stack to, int num, String [][] grammar, Parser tree) { //Se sacan los tokens que se pueden simplificar y se sacan la cantidad de estados que diga

        int target=grammar[num-1].length;
        //Pop del array de estadis
        for(int i =0; i < target-1; i++){
            System.out.print("pop -> ");
            Integer a = (Integer) st.pop();
            System.out.println(a);
        }
        System.out.println("States: " + st);

        //Pop del array de tokens
        for(int i =0; i < target-1; i++){
            System.out.print("pop -> ");
            String b = (String) to.pop();
            System.out.println(b);
        }

        //Push del nuevo token
        to.push(grammar[num-1][0]);

        System.out.println("Tokens: " + to);

        //Crear lista de los nodos hijo
        List<Node> addchildren = new ArrayList<>();


    }
    static  void error(){
        System.out.println("Token not valid");
    }

    public static void main(ArrayList<Token> tokens)  {

        Node root = newNode(new Token("program_nt","program")); //root
        (root.child).add(newNode(new Token("class","class")));//Add child to root
        (root.child).add(newNode(new Token("Program","Program")));
        (root.child).add(newNode(new Token("{","{")));
        (root.child).add(newNode(new Token("field_decl","field_decl")));
        (root.child.get(3).child).add(newNode(new Token("type","int"))); //Add child to node field_decl
        (root.child.get(3).child).add(newNode(new Token("id","kalshjg89")));

        Stack stkTokens = new Stack();
        Stack stkStates = new Stack();
        stkStates.push(0);


        //ACTIONS TABLE ARRAYS
       /* String [][] grammar ={{"S","X"},
                              {"X","(","X",")"},
                              {"X","(",")"},};
        String [] inputSymbols = {"(",")","$","X"};
        String[][] actionsT = {{"shift 2","error", "error","goto 1"},
                          {"error","error","accept",},
                          {"shift 2","shift 4","error","goto 3"},
                          {"error","shift 5","error",},
                          {"reduce 3","reduce 3","reduce 3"},
                          {"reduce 2","reduce 2","reduce 2"}};

        */

        ArrayList<Token> listTokens = new ArrayList<>();
        listTokens.add(new Token("(","terminal"));
        listTokens.add(new Token("(","terminal"));
        listTokens.add(new Token(")","terminal"));
        listTokens.add(new Token(")","terminal"));

        int tokensCounter=0;
        int statesCounter=0;

        //int listzise=listTokens.size();

        Token[] terminals= new Token[23];
        terminals[0]=new Token("class","class");
        terminals[1]=new Token("program","program");
        terminals[2]=new Token("{","{");
        terminals[3]=new Token("}","}");

        if(listTokens.get(tokensCounter).tipo.equals(terminals[tokensCounter].tipo)){
            tokensCounter++;
            shift(stkStates,stkTokens,listTokens.get(tokensCounter),statesCounter);

            if (listTokens.get(tokensCounter).tipo.equals(terminals[tokensCounter].tipo)){
                tokensCounter++;
                if(listTokens.get(tokensCounter).tipo.equals(terminals[tokensCounter].tipo)){
                    tokensCounter++;
                    if(listTokens.get(tokensCounter).tipo.equals(terminals[tokensCounter].tipo)){
                        //Empty program

                    }

                }
                else System.out.print("Error missing '{'");
            }
            else System.out.print("Error:class Program not declared");
        }
        else System.out.print("Error: class Program not declared");






/*        for (int i = 0; i < actionsT.length; i++){
            for (int j = 0; j < actionsT[i].length; j++){
                if (inputSymbols[j]==listTokens.get(tokensCounter).tipo){
                    String expression=actionsT[i][j];
                    String[] expressionarr = expression.split(" ");
                    switch (expressionarr[0]) {
                        case "shift":
                            int k=Integer.parseInt(expressionarr[1]);
                            System.out.println("shift to s"+k);
                            shift(stkStates,stkTokens,listTokens.get(tokensCounter),k);
                            i=k-1;
                            tokensCounter++;
                            if(tokensCounter==listzise){

                            }
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
                            reduce(stkStates,stkTokens,m,grammar, ASTree);
                            String lastToken= stkStates.peek().toString();
                            System.out.println(lastToken);
                            i=Integer.parseInt(lastToken)-1;
                            //tokensCounter++;
                            break;
                        //case "error":x
                           // error();
                            //break;

                    }
                }
            }
        }*/


    }

    void field_decl_list ( ArrayList<Token> listTokens,Token[] terminals, int tcounter, int scounter){
        if (listTokens.get(tcounter).tipo.equals(terminals[tcounter].tipo)){

        }
    }

    void method_decl_list (){

    }

}
