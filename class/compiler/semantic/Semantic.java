package semantic;
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
    ((root.child.get(3).child).get(4).child.get(3).child.get(1).child).add(newNode(new Token("bin_op", "exp")));
    ((root.child.get(3).child).get(4).child.get(3).child.get(1).child).add(newNode(new Token("exp", "exp")));
    ((root.child.get(3).child).get(4).child.get(3).child.get(1).child.get(0).child).add(newNode(new Token("literal", "literal")));
    ((root.child.get(3).child).get(4).child.get(3).child.get(1).child.get(2).child).add(newNode(new Token("literal", "literal")));

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


        
    }


    static LinkedList<Row> table = new LinkedList<>();
    static int scope = 0;
    public static LinkedList<Row> Recorrer(Node root){
        for (int i = 0; i <root.child.size() ; i++) {

            if(root.child.get(i).key.tipo.equals("{")||root.child.get(i).key.tipo.equals("(")){
                scope +=1;

            }else if(root.child.get(i).key.tipo.equals("}")||root.child.get(i).key.tipo.equals("}")){
                scope = scope-1;
               ;

            }else if(root.child.get(i).key.tipo.equals("type")){


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
                        System.out.println(root.child.get(index).child.get(j).key.valor+" "+root.child.get(index).child.get(j+1).key.valor+" "+scope);
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
    public static void insertTotable(){
    


    }





    public static void checkmethoddeclaration(){

    }
}
