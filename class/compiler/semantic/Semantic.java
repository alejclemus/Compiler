package semantic;
import java.sql.SQLOutput;
import java.util.*;
import scanner.Token;



public class Semantic {


    //building Tree
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
public static void TreeCreator(){

Node root = newNode(new Token("program_nt","program")); //root

/*
    (root.child).add(newNode(new Token("class","class")));//Add child to root
    (root.child).add(newNode(new Token("Program","Program")));
    (root.child).add(newNode(new Token("{","{")));
    (root.child).add(newNode(new Token("method_decl","method_decl")));
    (root.child).add(newNode(new Token("}","}")));
    (root.child.get(3).child).add(newNode(new Token("type","int")));
    (root.child.get(3).child).add(newNode(new Token("id","a")));
    (root.child.get(3).child).add(newNode(new Token("(","(")));
    (root.child.get(3).child).add(newNode(new Token(")",")")));
    (root.child.get(3).child).add(newNode(new Token("block","block")));
    ((root.child.get(3).child).get(4).child).add(newNode(new Token("{", "{")));
    ((root.child.get(3).child).get(4).child).add(newNode(new Token("var_decl", "var_decl")));
    ((root.child.get(3).child).get(4).child).add(newNode(new Token("statement", "statement")));
    ((root.child.get(3).child).get(4).child).add(newNode(new Token(";", ";")));
    ((root.child.get(3).child).get(4).child).add(newNode(new Token("}", "}")));
    ((root.child.get(3).child).get(4).child).get(1).child.add(newNode(new Token("type", "int")));
    ((root.child.get(3).child).get(4).child).get(1).child.add(newNode(new Token("id", "b")));
    ((root.child.get(3).child).get(4).child).get(1).child.add(newNode(new Token(";", ";")));
    ((root.child.get(3).child).get(4).child).get(2).child.add(newNode(new Token("location", "location")));
    ((root.child.get(3).child).get(4).child).get(2).child.add(newNode(new Token("assignation", "=")));
    ((root.child.get(3).child).get(4).child).get(2).child.add(newNode(new Token("expr", "expr")));
    ((root.child.get(3).child).get(4).child).get(2).child.add(newNode(new Token(";", ";")));
    ((root.child.get(3).child).get(4).child).get(2).child.get(0).child.add(newNode(new Token("id", "b")));
    ((root.child.get(3).child).get(4).child).get(2).child.get(2).child.add(newNode(new Token("literal", "1")));
*/
/*
    (root.child).add(newNode(new Token("class","class")));//Add child to root
    (root.child).add(newNode(new Token("Program","Program")));
    (root.child).add(newNode(new Token("{","{")));
    (root.child).add(newNode(new Token("method_decl","method_decl")));
    (root.child.get(3).child).add(newNode(new Token("type","int")));
    (root.child.get(3).child).add(newNode(new Token("id","a")));
    (root.child.get(3).child).add(newNode(new Token("(","(")));
    (root.child.get(3).child).add(newNode(new Token(")",")")));
    (root.child.get(3).child).add(newNode(new Token("block","block")));
    ((root.child.get(3).child).get(4).child).add(newNode(new Token("{", "{")));
    ((root.child.get(3).child).get(4).child).add(newNode(new Token("var_decl", "var_decl")));
    ((root.child.get(3).child).get(4).child).add(newNode(new Token("var_decl", "var_decl")));
    ((root.child.get(3).child).get(4).child).add(newNode(new Token("statement", "statement")));
    ((root.child.get(3).child).get(4).child).add(newNode(new Token(";", ";")));
    ((root.child.get(3).child).get(4).child.get(1).child).add(newNode(new Token("type", "int")));
    ((root.child.get(3).child).get(4).child.get(1).child).add(newNode(new Token("id", "b")));
    ((root.child.get(3).child).get(4).child.get(1).child).add(newNode(new Token(";", ";")));
    ((root.child.get(3).child).get(4).child.get(2).child).add(newNode(new Token("type", "int")));
    ((root.child.get(3).child).get(4).child.get(2).child).add(newNode(new Token("id", "c")));
    ((root.child.get(3).child).get(4).child.get(2).child).add(newNode(new Token(";", ";")));
    ((root.child.get(3).child).get(4).child.get(3).child).add(newNode(new Token("return", "return")));
    ((root.child.get(3).child).get(4).child.get(3).child).add(newNode(new Token("exp", "exp")));
    ((root.child.get(3).child).get(4).child.get(3).child.get(1).child).add(newNode(new Token("exp", "exp")));
    ((root.child.get(3).child).get(4).child.get(3).child.get(1).child).add(newNode(new Token("operator", "*")));
    ((root.child.get(3).child).get(4).child.get(3).child.get(1).child).add(newNode(new Token("exp", "exp")));
    ((root.child.get(3).child).get(4).child.get(3).child.get(1).child.get(0).child).add(newNode(new Token("literal", "a")));
    ((root.child.get(3).child).get(4).child.get(3).child.get(1).child.get(2).child).add(newNode(new Token("literal", "c")));
    ((root.child.get(3).child).get(4).child.get(4).child).add(newNode(new Token("exp", "exp")));
    ((root.child.get(3).child).get(4).child.get(4).child).add(newNode(new Token("return", "return")));
    ((root.child.get(3).child).get(4).child.get(4).child.get(1).child).add(newNode(new Token("exp", "exp")));
    ((root.child.get(3).child).get(4).child.get(4).child.get(1).child).add(newNode(new Token("operator", "*")));
    ((root.child.get(3).child).get(4).child.get(4).child.get(1).child).add(newNode(new Token("exp", "exp")));
    ((root.child.get(3).child).get(4).child.get(4).child.get(1).child.get(0).child).add(newNode(new Token("literal", "b")));
    ((root.child.get(3).child).get(4).child.get(4).child.get(1).child.get(2).child).add(newNode(new Token("literal", "c")));
    (root.child).add(newNode(new Token("{","{")));
    (root.child).add(newNode(new Token("type","int")));
    (root.child).add(newNode(new Token("id","c")));
*/


    /*
    ((root.child.get(3).child).get(4).child.get(3).child).add(newNode(new Token("exp", "exp")));
    ((root.child.get(3).child).get(4).child.get(3).child.get(2).child).add(newNode(new Token("exp", "exp")));
    ((root.child.get(3).child).get(4).child.get(3).child.get(2).child).add(newNode(new Token("operator", "*")));
    ((root.child.get(3).child).get(4).child.get(3).child.get(2).child).add(newNode(new Token("exp", "exp")));
    ((root.child.get(3).child).get(4).child.get(3).child.get(2).child.get(0).child).add(newNode(new Token("literal", "c")));
    ((root.child.get(3).child).get(4).child.get(3).child.get(2).child.get(2).child).add(newNode(new Token("literal", "d")));
*/

    /* first scope detection test
    (root.child).add(newNode(new Token("class","class")));//Add child to root
    (root.child).add(newNode(new Token("Program","Program")));
    (root.child).add(newNode(new Token("{","{")));
    (root.child).add(newNode(new Token("field_decl","field_decl")));
    (root.child.get(3).child).add(newNode(new Token("type","int"))); //Add child to node field_decl
    (root.child.get(3).child).add(newNode(new Token("id","a")));
    (root.child).add(newNode(new Token("{","{")));
    (root.child).add(newNode(new Token("field_decl","field_decl")));
    (root.child.get(5).child).add(newNode(new Token("type","int"))); //Add child to node field_decl
    (root.child.get(5).child).add(newNode(new Token("id","b")));
    (root.child).add(newNode(new Token("}","}")));
    (root.child).add(newNode(new Token("field_decl","field_decl")));
    (root.child.get(7).child).add(newNode(new Token("type","int"))); //Add child to node field_decl
    (root.child.get(7).child).add(newNode(new Token("id","c")));
    (root.child).add(newNode(new Token("}","}")));
    */

   /*  Code for testing the tree iteration, it works!
    Node root = newNode(new Token("program_nt","x")); //root
    (root.child).add(newNode(new Token("class","0, UNO")));//Add child to root
    (root.child).add(newNode(new Token("Program","1, SIETE")));
    (root.child).add(newNode(new Token("{","2, OCHO")));
    (root.child).add(newNode(new Token("field_decl","3, NUEVE")));
    (root.child.get(3).child).add(newNode(new Token("type","3.0, DIEZ"))); //Add child to node field_decl
    (root.child.get(3).child).add(newNode(new Token("id","3.1, DOCE")));
    (root.child.get(3).child).add(newNode(new Token("id","3.2, CATORCE")));
    ((root.child.get(3).child).get(0).child).add(newNode(new Token("id", "3.0.1, ONCE")));
    ((root.child.get(3).child).get(1).child).add(newNode(new Token("id", "3.1.1, TRECE")));
    (root.child.get(0).child).add(newNode(new Token("type","0.1, DOS")));
    (root.child.get(0).child).add(newNode(new Token("type","0.2, TRES")));
    ((root.child.get(0).child).get(1).child).add(newNode(new Token("id", "0.2.1, CUATRO")));
    ((root.child.get(0).child).get(1).child).add(newNode(new Token("id", "0.2.2 CINCO")));
    ((root.child.get(0).child).get(1).child).add(newNode(new Token("id", "0.2.3 SEIS")));
*/


checkUniqueness(Recorrer(root));
typeCheck(root, Recorrer(root));



    }

    static LinkedList<Row> table = new LinkedList<>();
    static int scope = 0;
    public static LinkedList<Row> Recorrer(Node root){
        for (int i = 0; i <root.child.size() ; i++) {

            if(root.child.get(i).key.tipo.equals("{")||root.child.get(i).key.tipo.equals("(")){
                scope +=1;

            }else if(root.child.get(i).key.tipo.equals("}")||root.child.get(i).key.tipo.equals("}")){
                scope = scope-1;
            }
            if(root.child.get(i).child.isEmpty() == false){
                int index = i;
                for (int j = 0; j <root.child.get(index).child.size() ; j++) {
                    //check for scope
                    if(root.child.get(index).child.get(j).key.tipo.equals("{") ||root.child.get(index).child.get(j).key.tipo.equals("(") ){
                        scope +=1;
                    }else if(root.child.get(index).child.get(j).key.tipo.equals("}")||root.child.get(index).child.get(j).key.tipo.equals(")")){
                        scope = scope-1;
                    }else if(root.child.get(index).child.get(j).key.tipo.equals("type")){ // check if node has a variable declaration
                        Row fila = new Row(root.child.get(index).child.get(j).key.valor, root.child.get(index).child.get(j+1).key.valor, scope);
                        //System.out.println(root.child.get(index).child.get(j).key.valor+" "+root.child.get(index).child.get(j+1).key.valor+" "+scope);
                        table.add(fila);
                    }
                    Node recursive = root.child.get(index).child.get(j);
                    //System.out.println(root.child.get(index).child.get(j).key.valor +" , "+ root.child.get(index).child.get(j).key.tipo);
                    Recorrer(recursive);

                }

            }

        }


        return table;

    }

    static int scope2 = 0;
    public static void typeCheck(Node root, LinkedList<Row> tabla) {
        ArrayList<String> ids = new ArrayList<>();
        ArrayList<String> operators = new ArrayList<>();
        for (int i = 0; i < root.child.size(); i++) {
            //definimos scope
            if (root.child.get(i).key.tipo.equals("{") || root.child.get(i).key.tipo.equals("(")) {
                scope2 += 1;

            } else if (root.child.get(i).key.tipo.equals("}") || root.child.get(i).key.tipo.equals("}")) {
                scope2 = scope2 - 1;
            } else if (root.child.get(i).key.tipo.equals("operator")|| root.child.get(i).key.tipo.equals("assignation")) {
                //System.out.println(scope2);
                operators.add(root.child.get(i).key.valor);
            }else if(root.child.get(i).key.tipo.equals("literal")){
                ids.add(root.child.get(i).key.valor);
            }
            if (root.child.get(i).child.isEmpty() == false) {
                int index = i;

                for (int j = 0; j < root.child.get(index).child.size(); j++) {
                    if (root.child.get(index).child.get(j).key.tipo.equals("{") || root.child.get(index).child.get(j).key.tipo.equals("(")) {
                        scope2 += 1;
                    } else if (root.child.get(index).child.get(j).key.tipo.equals("}") || root.child.get(index).child.get(j).key.tipo.equals(")")) {
                        scope2 = scope2 - 1;
                    } else if (root.child.get(index).child.get(j).key.tipo.equals("literal") && root.child.get(index).child.get(j).key.tipo != "true" && root.child.get(index).child.get(j).key.tipo != "false") {// si uno de los hijos del nodo es literal
                        //System.out.println(scope2);
                        ids.add(root.child.get(index).child.get(j).key.valor);
                        for (int k = 0; k < ids.size(); k++) {
                            //System.out.println(ids.size());
                            //System.out.println(ids.get(k));

                        }
                    } else if (root.child.get(index).child.get(j).key.tipo.equals("operator")|| root.child.get(index).child.get(j).key.tipo.equals("assignation")) {
                        operators.add(root.child.get(index).child.get(j).key.valor);
                        //System.out.println(root.child.get(index).child.get(j).key.valor);
                    }
                    Node recursive = root.child.get(index).child.get(j);
                    typeCheck(recursive, table);
                }
            }
        }


//SCOPE CHECK
        if (ids.size() > 1 && operators.size() > 0) {
            System.out.println("PASS");
            //iteramos la tabla para encontrar el scope sobre el cual las variables estan escritas
            ArrayList<String> idsInScope = new ArrayList();
            ArrayList<String> typesinScope = new ArrayList<>();

            //AGARRAR SOBRE EL SCOPE
            for (int j = 0; j < tabla.size(); j++) {
                if (tabla.get(j).scope <= scope2) {
                    idsInScope.add(tabla.get(j).name);
                    typesinScope.add(tabla.get(j).type);
                    //System.out.println(idsInScope.get(j));
                   // System.out.println(typesinScope.get(j));
                }
            }

//AGARRAR TYPES CORRESPONDIENTE
            ArrayList<String> typesinOperation = new ArrayList<>();
            for (int i = 0; i < ids.size(); i++) {
                for (int j = idsInScope.size(); j-- > 0; ) {

                    if (ids.get(i).equals(idsInScope.get(j))) {
                        typesinOperation.add(typesinScope.get(j));
                        break;
                    }

                }

            }
// CHEQUEAR TIPO
            if (typesinOperation.get(0) != typesinOperation.get(1)) {
                System.out.println("ERROR, INCOPATIBLE OPERATION, PARAMETERS HAVE DIFFERENT TYPES");
            }

//CHEQUEAR SI EXISTE EN SCOPE
            for (int j = 0; j < ids.size(); j++) {
                String toCheck = ids.get(j);
                if (idsInScope.contains(toCheck)) {
                } else {
                    System.out.println("ERROR, VARIABLE CALLED OUT OF SCOPE OR DOESN\'T EXIST");
                }


            }
//CHEQUEAR QUE LA OPERACION SEA CORRECTA
            for (int i = 0; i < typesinOperation.size(); i++) {
                if(typesinOperation.get(i)=="boolean"){
                    for (int j = 0; j <operators.size() ; j++) {
                        if(operators.get(i).equals("<") ||operators.get(i).equals(">") ||operators.get(i).equals("<=")
                                || operators.get(i).equals(">=") || operators.get(i).equals("+") ||operators.get(i).equals("-")
                                ||operators.get(i).equals("*") ||operators.get(i).equals("/") ||operators.get(i).equals("%")){

                            System.out.println("OPERATION CANNOT BE DONE WITH VARIABLE TYPE");
                        }

                    }
                }


            }


        }

    }

    static int scopeCounter=0;
    public static void checkUniqueness(LinkedList<Row> tabla){
        Collections.sort(tabla, new Comparator<Row>() {
            @Override
            public int compare(Row o1, Row o2) {
                return o1.scope - o2.scope;
            }
        });
    for (int i = 0; i <tabla.size(); i++) {
        LinkedList<Row> verify = checkrecursive(tabla);
            System.out.println(scopeCounter);
            if(verify.size()!=0){
                ArrayList<String> Unique = new ArrayList<>();
                for (int a = 0; a <verify.size() ; a++) {
                    Unique.add(verify.get(a).name);
                }

                for (int k = 0; k <Unique.size() ; k++) {
                   // String temp = Unique.get(k);
                    //Unique.set(k," ");
                    for (int j = k+1; j <Unique.size() ; j++) {
                        if(Unique.get(j).equals(Unique.get(k))){
                            System.out.println("VARIABLE NAME ALREADY EXISTS IN SCOPE");

                        }

                    }
                    //Unique.set(k, temp);
                }

            }
            scopeCounter +=1;
    }



/*
    for (int i = 0; i <temporal.size() ; i++) {
        System.out.println(temporal.get(i).type +" , "+temporal.get(i).name+" , "+temporal.get(i).scope);
    }
    */

}

public static LinkedList<Row> checkrecursive(LinkedList<Row> tabla){

        LinkedList<Row> temporal = new LinkedList<>();
        //imprimir table (also recorrerla)
        for (int k = 0; k <tabla.size(); k++) {

            if(tabla.get(k).scope == scopeCounter){
                temporal.add(tabla.get(k));

            }


        }
        for (int i = 0; i <temporal.size() ; i++) {
            System.out.println(temporal.get(i).type +" , "+temporal.get(i).name+" , "+temporal.get(i).scope);
        }

    return temporal;
    }



public static void main(String[] args){

    TreeCreator();

}




}
