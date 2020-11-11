package parser;

import scanner.Token;

import java.util.*;

public class Parser {

    AST root;

    Parser (String key,List<AST> children)
    {
        root = new AST(key, children);
    }

    Parser ()
    {
        root = null;
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

        //Crear lista de los nodos hijo a partir de la gramatica
        List<AST> addchildren = new ArrayList<>();


        if(tree.root != null){
            System.out.println("Hay que cambiar el root");
        }
        else
        {
            for(int i=1; i< target;i++){
                List<AST> grandchildren = new ArrayList<>();
                addchildren.add(new AST(grammar[num-1][i],grandchildren));
            }
            
            tree.root=new AST(grammar[num-1][0],addchildren);
        }

    }
    static  void error(){
        System.out.println("Token not valid");
    }

    public static void main(String[] args)  {
        Stack stkTokens = new Stack();
        Stack stkStates = new Stack();
        stkStates.push(0);

        Parser ASTree = new Parser();


        //ACTIONS TABLE ARRAYS
        String [][] grammar ={{"S","X"},
                              {"X","(","X",")"},
                              {"X","(",")"},};
        String [] inputSymbols = {"(",")","$","X"};
        String[][] actionsT = {{"shift 2","error", "error","goto 1"},
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

        for (int i = 0; i < actionsT.length; i++){
            for (int j = 0; j < actionsT[i].length; j++){
                System.out.println();
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
                            i=2;
                            tokensCounter++;
                            break;
                        //case "error":x
                           // error();
                            //break;

                    }
                }
            }
        }


    }
}
