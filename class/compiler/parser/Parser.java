package compiler.parser;

import compiler.scanner.Token;

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



    static void shift(Stack st, Stack <Token> to, Token token, int a, int state) { //Mete un token al stack de tokens y un estado al stack de estados
        st.push(state);
        System.out.println("States: " + st);
        to.push(token);
        System.out.println("Tokens: "+ to.toString() );

    }

    static void goTo(Stack st, int a) { //mete un estado al stack de estados
        st.push(a);
        System.out.println("States: " + st);
    }

    static void reduce(Stack st, Stack <Token> to, Stack<Node> rto,int num, String [] grammar, Node root, Token [] newTokens) { //Se sacan los tokens que se pueden simplificar y se sacan la cantidad de estados que diga

        //AST
        Node temproot = newNode(newTokens[num]); //Root temporal de la reduccion

        String searchFor=grammar[num]; //Encontrar el nodo hasta en en donde se tiene que hacer la reduccion

        //Pop del array de tokens y de estados
        while (!to.empty() && !to.peek().equals(searchFor)) {
            if(to.peek().tipo == rto.peek().key.tipo){
                (temproot.child).add(rto.pop());
            }
            else {
                (temproot.child).add(newNode(to.pop())); //Agregar como hijos del temporal a los tokens
            }
            st.pop();
        }
        to.push(newTokens[num]);//Pushear el nodo de la reduccion
        rto.push(temproot); //Pushear al stack de tokens que ya tienen hijos este nodo



        System.out.println("States: " + st);
        System.out.println("Tokens: "+ to.toString() );
        //Push del nuevo token

        /*System.out.print(root.key.tipo+" ");
        for (Node it : root.child)
            System.out.print(it.key.tipo+" ");*/

    }

    static  void error(){
        System.out.println("Token not valid");
    }

    static void follow() {

    }

    static void accept() {

    }

    public Node mainParse(ArrayList<Token> listTokens)  {

        Node root=null;

        Stack <Token> stkTokens = new Stack();
        Stack <Node> stkReducedTokens = new Stack();
        Stack stkStates = new Stack();


        //Define grammar for reduce
        String[] grammar= {"main",
                "field_decl_list",
                "field_decl",
                "method_decl_list",
                "method_decl",
                "type",
                "id",
                "type",
                "void",
                "method_arg_list",
                "method_arg",
                "type",
                "{",
                "field_decl_list",
                "statement_list",
                "statement",
                "location",
                "method_call",
                "if",
                "for",
                "return",
                "break",
                "continue",
                "id",
                "location",
                "method_call",
                "literal",
                "expr",
                "operator",
                "!",
                "(",
                "id",
                "callout",
                "expr_list",
                "expr",
                "callout_arg_list",
                "callout_arg",
                "string_literal",
                "expr"
        };

        //ACTIONS TABLE ARRAYS
        String [] inputSymbols = {"class","program","{","}","$","[","]","(",")",",",";","!","type","void",
                "if", "else","for","return","break","continue","assignation","callout","operator",
                "literal","id","string_literal","Program","field_decl","method_decl","block","var_decl","statement",
                "method_call","method_name","location","expr","callout_arg"};

        String[][] actionsT = {
                {"shift 2","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","goto 1","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error"},
                {"error","error","error","error","accept","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error"},
                {"error","shift 3","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error"},
                {"error","error","shift 4","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error"},
                {"error","error","error","shift 5","error","error","error","error","error","error","error","error","shift 16","shift 17","error","error","error","error","error","error","error","error","error","error","error","error","error","goto 6","goto 7","goto 8","error","goto 9","error","error","error","error","error","error","error","error","error","error","error","error"},
                {"Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error"},
                {"error","error","error","shift 10","error","error","error","error","error","error","error","error","shift 16","shift 17","error","error","error","error","error","error","error","error","error","error","error","error","error","error","goto 11","goto 12","error","goto 9","error","error","error","error","error","error","error","error","error","error","error","error" },
                {"error","error","error","shift 13","error","error","error","error","error","error","error","error","shift 18","shift 17","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","goto 14","error","error","error","error","error","error","error","error","error","error","error","error" },
                {"Reduce 2","Reduce 2","Reduce 2","Reduce 2","Reduce 2","Reduce 2","Reduce 2","Reduce 2","Reduce 2","Reduce 2","Reduce 2","Reduce 2","Reduce 2","Reduce 2","Reduce 2","Reduce 2","Reduce 2","Reduce 2","Reduce 2","Reduce 2","Reduce 2","Reduce 2","Reduce 2","Reduce 2","Reduce 2","Reduce 2","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error" },
                {"Reduce 4","Reduce 4","Reduce 4","Reduce 4","Reduce 4","Reduce 4","Reduce 4","Reduce 4","Reduce 4","Reduce 4","Reduce 4","Reduce 4","Reduce 4","Reduce 4","Reduce 4","Reduce 4","Reduce 4","Reduce 4","Reduce 4","Reduce 4","Reduce 4","Reduce 4","Reduce 4","Reduce 4","Reduce 4","Reduce 4","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error" },
                {"Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error"},
                {"error","error","error","error","error","error","error","error","error","error","error","error","shift 18 ","shift 17","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","goto 14","error","error","error","error","error","error","error","error","error","error","error","error" },
                {"follow 0","follow 0","follow 0","follow 0","follow 0","follow 0","follow 0","follow 0","follow 0","follow 0","follow 0","follow 0","follow 0","follow 0","follow 0","follow 0","follow 0","follow 0","follow 0","follow 0","follow 0","follow 0","follow 0","follow 0","follow 0","follow 0","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error" },
                { "Reduce 0 ","Reduce 0 ","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error" },
                {"Reduce 3","Reduce 3","Reduce 3","Reduce 3","Reduce 3","Reduce 3","Reduce 3","Reduce 3","Reduce 3","Reduce 3","Reduce 3","Reduce 3","Reduce 3","Reduce 3","Reduce 3","Reduce 3","Reduce 3","Reduce 3","Reduce 3","Reduce 3","Reduce 3","Reduce 3","Reduce 3","Reduce 3","Reduce 3","Reduce 3","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error" },
                {"Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","Reduce 0","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error" },
                {"error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","shift 19","error","error","error","error","error","goto 20","error","error","error","error","error","error","error","error","error","error","error","error","error" },
                {"error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","shift 21","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error" },
                {"error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","shift 22","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error" },
                {"error","error","error","error","error","error","error","shift 24","error","shift 35","shift 23","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error" },
                {"error","error","error","error","error","error","error","error","error","error","shift 25","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error" },
                {"error","error","error","error","error","error","error","shift 26","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error" },
                {"error","error","error","error","error","error","error","shift 24","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error" },
                {"Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error\n" },
                {"error","error","error","error","error","error","error","error","shift 28","error","error","error","shift 32","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","goto 29","goto 31","error","error","error","error","error","error","error","error","error","error" },
                {"Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","Reduce 5","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error"}
        };


        int tokensCounter=0;
        int currentState=0;

        Token [] newTokens = {new Token("main","main"), //0
                              new Token("field_decl_list","field_decl_list"), //1
                              new Token("field_decl_list","field_decl_list"), //2
                              new Token("method_decl_list","method_decl_list"), //3
                              new Token("method_decl_list","method_decl_list"), //4
                              new Token("field_decl","field_decl"), //5
                              new Token("id_list","id_list"), //6
                              new Token("method_decl","method_decl"), //7
                              new Token("method_decl","method_decl"), //8
                              new Token("method_arg_list","method_arg_list"), //9
                              new Token("method_arg_list","method_arg_list"), //10
                              new Token("method_arg","method_arg"), //11
                              new Token("block","block"), //12
                              new Token("var_list","var_list"), //13
                              new Token("statement_list","statement_list"), //14
                              new Token("statement_list","statement_list"), //15
                              new Token("statement","statement "), //16
                              new Token("statement","statement "), //17
                              new Token("statement","statement "), //18
                              new Token("statement","statement "), //19
                              new Token("statement","statement "), //20
                              new Token("statement","statement "), //21
                              new Token("statement","statement "), //22
                              new Token("location","location"), //23
                              new Token("expr","expr"), //24
                              new Token("expr","expr"), //25
                              new Token("expr","expr"), //26
                              new Token("expr","expr"), //27
                              new Token("expr","expr"), //28
                              new Token("expr","expr"), //29
                              new Token("expr","expr"), //30
                              new Token("method_call","method_call"), //31
                              new Token("method_call","method_call"), //32
                              new Token("expr_list","expr_list"), //33
                              new Token("expr_list","expr_list"), //34
                              new Token("callout_arg_list","callout_arg_list"),//35
                              new Token("callout_arg_list","callout_arg_list"),//36
                              new Token("callout_arg","callout_arg"), //37
                              new Token("callout_arg","callout_arg") //38

        };


        for (int i = 0; i < actionsT.length; i++){ //Recorrer cada "fila" de la tabla de acciones
            for (int j = 0; j < actionsT[i].length; j++){ //Recorrer cada "columna" de la tabla de acciones
                if (inputSymbols[j]==listTokens.get(tokensCounter).tipo){ //Si el siguiente token hace match con un uno de los tokens de simbolos,
                    String expression=actionsT[i][j]; //Se busca en la tabla de acciones
                    String[] expressionarr = expression.split(" "); //Se divide la accion para tomar la palabra y el numero por aparte
                    switch (expressionarr[0]) { //Se toma la palabra
                        case "shift":
                            int k=Integer.parseInt(expressionarr[1]); //El numero para saber a que estado hacer el shift
                            System.out.println("shift to s"+k);
                            shift(stkStates,stkTokens,listTokens.get(tokensCounter),k,currentState); //Hay que tomar el token de la lista
                            i=k;
                            tokensCounter++;
                            currentState=k;
                            break;
                        case "goTo":
                            int l=Integer.parseInt(expressionarr[1]); //El numero para saber a que estado hacer el goto
                            System.out.println("goto s"+l);
                            goTo(stkStates,l);
                            i=l;
                            tokensCounter++;
                            currentState=l;
                            break;
                        case "reduce":
                            int m=Integer.parseInt(expressionarr[1]);
                            System.out.println("reduce ("+m+")");
                            reduce(stkStates,stkTokens,stkReducedTokens,m,grammar,root,newTokens);
                            i=Integer.parseInt(stkStates.peek().toString());
                            //tokensCounter++;
                            break;
                        case "error":
                            error();
                            break;

                    }
                }
            }
        }

        return root;
    }
}
