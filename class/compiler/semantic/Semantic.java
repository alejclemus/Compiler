package semantic;
import java.util.*;

import com.sun.source.tree.Tree;

import scanner.Token;

import java.util.ArrayList;
import java.util.*;

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
    (root.child.get(3).child).add(newNode(new Token("type","hijo0"))); //Add child to node field_decl
    (root.child.get(3).child).add(newNode(new Token("id","hijo1")));
    (root.child.get(3).child).add(newNode(new Token("id","hijo2")));
    ((root.child.get(3).child).get(0).child).add(newNode(new Token("id", "nivel 4")));
    ((root.child.get(3).child).get(1).child).add(newNode(new Token("id", "nivel 5")));


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
