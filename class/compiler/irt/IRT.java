package irt;

import scanner.Token;
import semantic.Row;


import java.util.LinkedList;
import java.util.Vector;

public class IRT {
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

    public static void Tree(){
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

Recorrer(root);

    }

    static LinkedList<String> listIRT = new LinkedList<>();
    public static LinkedList<String> Recorrer(Node root){
        for (int i = 0; i <root.child.size() ; i++) {
            if(root.child.get(i).key.tipo.equals("statement")){

                int index = i;
                listIRT.add("BEGIN");
                for (int j = 0; j <root.child.get(index).child.size() ; j++) {
                    listIRT.add(root.child.get(index).child.get(i).key.valor);
                    listIRT.add(root.child.get(index).child.get(i).key.tipo);

                }
                listIRT.add("END");

            }


        }

        for (int i = 0; i <listIRT.size() ; i++) {
            System.out.println(listIRT.get(i));

        }
        return listIRT;

    }

    public static void main(String[] args){
        Tree();
    }
}
