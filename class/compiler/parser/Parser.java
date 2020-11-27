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

    static void reduce(Stack st, Stack <Token> to, int num, String [] grammar, Node root, Token [] newTokens) { //Se sacan los tokens que se pueden simplificar y se sacan la cantidad de estados que diga

        //AST
        if(root == null){
            root =newNode(newTokens[num]);
            for (int i=0;i<to.size();i++){
                (root.child).add(newNode(to.get(i)));
            }
        }
        else{
            Node temproot= newNode(newTokens[num]);
        }

        String searchFor=grammar[num];
        //Pop del array de tokens y de estados
        while (!to.empty() && !to.peek().equals(searchFor)) {
            to.pop();
            st.pop();
        }
        System.out.println("States: " + st);
        System.out.println("Tokens: "+ to.toString() );
        //Push del nuevo token

        System.out.print(root.key.tipo+" ");
        for (Node it : root.child)
            System.out.print(it.key.tipo+" ");

    }

    static  void error(){
        System.out.println("Token not valid");
    }

    static void follow() {

    }

    static void accept() {

    }

    public static void main (String[] args)  {

        Node root=null;
        // Node root = newNode(new Token("program_nt","program")); //root
        //(root.child).add(newNode(new Token("class","class")));//Add child to root
        // (root.child).add(newNode(new Token("Program","Program")));
        // (root.child).add(newNode(new Token("{","{")));
        //(root.child).add(newNode(new Token("field_decl","field_decl")));
        // (root.child.get(3).child).add(newNode(new Token("type","int"))); //Add child to node field_decl
        // (root.child.get(3).child).add(newNode(new Token("id","kalshjg89")));
        //  (root.child.get(3).child).add(newNode(new Token(";",";")));
        //  (root.child).add(newNode(new Token("}","}")));

        Stack <Token> stkTokens = new Stack();
        Stack stkStates = new Stack();


        //Define grammar for reduce
        String[] grammar= {"class", //⟨program⟩ 0
                "type", //⟨field decl⟩ 1
                "type", //⟨method decl⟩ 2
                "void", //⟨method decl⟩ 3
                "{", //⟨block⟩ 4
                "type", //⟨var decl⟩ 5
                "location", //⟨statement⟩ 6
                "method_call", //⟨statement⟩ 7
                "if", //⟨statement⟩ 8
                "for", //⟨statement⟩ 9
                "return", //⟨statement⟩ 10
                "break", //⟨statement⟩ 11
                "continue", //⟨statement⟩ 12
                "block", //⟨statement⟩ 13
                "method_name", //⟨method call⟩ 14
                "callout", //⟨method call⟩ 15
                "id", //⟨method name⟩ 16
                "id", //⟨location⟩ 17
                "location", //⟨expr⟩ 18
                "method_call", //⟨expr⟩ 19
                "literal", //⟨expr⟩ 20
                "expr", //⟨expr⟩ 21
                "operator", //⟨expr⟩ 22
                "!", //⟨expr⟩ 23
                "(", //⟨expr⟩ 24
                "expr", //⟨callout arg⟩ 25
                "string_literal" //⟨callout arg⟩ 26
        };

        //ACTIONS TABLE ARRAYS
        String [] inputSymbols = {"class","program","{","}","$","[","]","(",")",",",";","!","type","void",
                "if", "else","for","return","break","continue","assign_op","callout","bin_op",
                "literal","id","string_literal","Program","field_decl","method_decl","block","var_decl","statement",
                "method_call","method_name","location","expr","callout_arg"};

        String[][] actionsT = {{"shift 1","error", "error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error"},
                {"error","shift 2","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error"},
                {"error","error","shift 3","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error"},
                {"error","error","error","shift 4","error","error","error","error","error","error","error","error","shift 5","shift 5","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error"},
                {"error","error","error","error","reduce 0","error","error","error","error","error","error","error","shift 5","shift 5","error","error","accept","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error","error"},
                //{"reduce 2","reduce 2","reduce 2"}
        };



        ArrayList<Token> listTokens = new ArrayList<>();
        listTokens.add(new Token("class","class"));
        listTokens.add(new Token("program","program"));
        listTokens.add(new Token("{","{"));
        listTokens.add(new Token("}","}"));
        listTokens.add(new Token("$","$"));

        int tokensCounter=0;
        int currentState=0;

        Token [] newTokens = {new Token("main","main"), //0
                              new Token("field_decl","field_decl"), //1
                              new Token("method_decl","method_decl"), //2
                              new Token("method_decl","method_decl"), //3
                              new Token("block","block"), //4
                              new Token("var_decl","var_decl"), //5
                              new Token("statement","statement "), //6
                              new Token("statement","statement "), //7
                              new Token("statement","statement "), //8
                              new Token("statement","statement "), //9
                              new Token("statement","statement "), //10
                              new Token("statement","statement "), //11
                              new Token("statement","statement "), //12
                              new Token("statement","statement "), //13
                              new Token("method_call","method_call"), //14
                              new Token("method_call","method_call"), //15
                              new Token("method_name","method_name"), //16
                              new Token("location","location"), //17
                              new Token("expr","expr"), //18
                              new Token("expr","expr"), //19
                              new Token("expr","expr"), //20
                              new Token("expr","expr"), //21
                              new Token("expr","expr"), //22
                              new Token("expr","expr"), //23
                              new Token("expr","expr"), //24
                              new Token("callout_arg","callout_arg"), //25
                              new Token("callout_arg","callout_arg") //26

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
                            int l=Integer.parseInt(expressionarr[1]);
                            System.out.println("goto s"+l);
                            goTo(stkStates,l);
                            i=l-1;
                            tokensCounter++;
                            break;
                        case "reduce":
                            int m=Integer.parseInt(expressionarr[1]);
                            System.out.println("reduce ("+m+")");
                            reduce(stkStates,stkTokens,m,grammar,root,newTokens);
                            //tokensCounter++;
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
