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
    /* 0 */(root.child).add(newNode(new Token("class","class")));//Add child to root
    /* 1 */(root.child).add(newNode(new Token("Program","Program")));
    /* 2 */(root.child).add(newNode(new Token("{","{")));
    /* 3 */(root.child).add(newNode(new Token("field_decl","field_decl")));
    (root.child.get(3).child).add(newNode(new Token("type","int"))); //Add child to node field_decl
    (root.child.get(3).child).add(newNode(new Token("id","a")));
    /* 4 */(root.child).add(newNode(new Token("{","{")));
    /* 5 */(root.child).add(newNode(new Token("field_decl","field_decl")));
    (root.child.get(5).child).add(newNode(new Token("type","int"))); //Add child to node field_decl
    (root.child.get(5).child).add(newNode(new Token("id","b")));
    /* 6 */(root.child).add(newNode(new Token("}","}")));
    /* 7 */(root.child).add(newNode(new Token("field_decl","field_decl")));
    (root.child.get(7).child).add(newNode(new Token("type","int"))); //Add child to node field_decl
    (root.child.get(7).child).add(newNode(new Token("id","c")));
    /* 8 */(root.child).add(newNode(new Token("}","}")));
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

Recorrer(root);



        
    }


    static LinkedList<Row> table = new LinkedList<>();
    static int scope = 0;
    public static void Recorrer(Node root){


        for (int i = 0; i <root.child.size() ; i++) {
            System.out.println(root.child.get(i).key.tipo+" , "+ root.child.get(i).key.valor);
            if(root.child.get(i).key.tipo.equals("{")||root.child.get(i).key.tipo.equals("(")){
                scope +=1;
                System.out.println(scope);
            }else if(root.child.get(i).key.tipo.equals("}")||root.child.get(i).key.tipo.equals("}")){
                scope = scope-1;
                System.out.println(scope);

            }else if(root.child.get(i).key.tipo.equals("type")){
                System.out.println(root.child.get(i).child.get(0).key.tipo);

            }

            if(root.child.get(i).child.isEmpty() == false){
                int index = i;
                for (int j = 0; j <root.child.get(index).child.size() ; j++) {
                    //check for scope
                    if(root.child.get(index).child.get(j).key.tipo.equals("{") ||root.child.get(index).child.get(j).key.tipo.equals("(") ){
                        scope +=1;
                    }else if(root.child.get(index).child.get(j).key.tipo.equals("}")||root.child.get(index).child.get(j).key.tipo.equals(")")){
                        scope =scope-1;
                    }else if(root.child.get(index).child.get(j).key.tipo.equals("type")){ // check if node has a variable declaration
                        Row fila = new Row(root.child.get(index).child.get(j).key.valor, root.child.get(index).child.get(j+1).key.valor, scope);
                        table.add(fila);

                        //imprimir table (also recorrerla)
                        for (int k = 0; k <table.size(); k++) {
                            System.out.println(table.get(k).type +", "+table.get(k).name+", "+table.get(k).scope);
                        }



                    }

                    Node recursive = root.child.get(index).child.get(j);
                    //System.out.println(root.child.get(index).child.get(j).key.valor +" , "+ root.child.get(index).child.get(j).key.tipo);
                    Recorrer(recursive);

                }

            }

        }

    }








public static void main(String[] args){

    TreeCreator();
}
    public static void insertTotable(){
    


    }

    public static void checkfielddeclaration(){

    }



    public static void checkmethoddeclaration(){

    }
}
