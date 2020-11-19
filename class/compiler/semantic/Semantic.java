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
    (root.child).add(newNode(new Token("field_decl","field_decl")));
    (root.child.get(3).child).add(newNode(new Token("type","int"))); //Add child to node field_decl
    (root.child.get(3).child).add(newNode(new Token("id","kalshjg89")));
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

    public static void Recorrer(Node root){
        boolean stop = false;

        for (int i = 0; i <root.child.size() ; i++) {
            System.out.println(root.child.get(i).key.tipo+" , "+ root.child.get(i).key.valor);

            if(root.child.get(i).child.isEmpty() == false){
                int index = i;
                for (int j = 0; j <root.child.get(index).child.size() ; j++) {
                    Node recursive = root.child.get(index).child.get(j);
                    System.out.println(root.child.get(index).child.get(j).key.valor +" , "+ root.child.get(index).child.get(j).key.tipo);
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
