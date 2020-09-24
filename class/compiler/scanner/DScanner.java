package scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.*;
import scanner.Token;


public class DScanner {
    public static void main(String[] args) {
    // Regex("main() -> void {\n" +
          //  "print(\"Hello world!\\n\");\n" +
          //  "\n" +
          //  "}");
    }

    public static List<String> Regex(String program){
        //Pattern pattern = Pattern.compile("Class Program|\\{| }|\\[|]|,|;|=|-|\\+|-=|!|<|>|<=|>=|==|!=|\\+=|\\*|/|&&|\\|\\||%|//|\"|\'|\\\\|\'|\"|\n|\t|\\(|\\)|int|boolran|if|for|return|break|continue|callout|true|false|void|else|0[x|X][\\w|\\d]+|\\d+|[\\w][\\w\\d_]+|[\\W]+ ");
        //Matcher matcher = pattern.matcher(program);
        //System.out.println(matcher.toString());

        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile("Class Program|\\{| }|\\[|]|,|;|=|-|\\+|-=|!|<|>|<=|>=|==|!=|\\+=|\\*|/|&&|\\|\\||%|//|\"|\'|\\\\|\'|\"|\n|\t|\\(|\\)|main|int|boolean|if|for|return|break|continue|callout|true|false|void|else|0[x|X][\\w|\\d]+|\\d+|[\\w][\\w\\d_]+|[\\W]+ | \\w").matcher(program);
        while (m.find()) {
            allMatches.add(m.group());
        }

        System.out.println(allMatches);
        return allMatches;
    }

    public void TokenAssignment( List<String> toMatch){
        //hex literal
    Pattern a = Pattern.compile("0[x|X][\\w|\\d]+ ");
    // decimal literal
    Pattern b = Pattern.compile("\\d+");
    //char literal
    Pattern c = Pattern.compile("\\w");
    // string literal
    Pattern d = Pattern.compile("(\\w|_)(\\d|\\w|_)*");

    // count line number
        int count = 0;

        // Token

        String Token = "";
        String Tokentype ="";


        Token tokenize [] =new Token[40];

        for(int i =0 ; i< toMatch.size(); i++ ){
            Matcher e = a.matcher(toMatch.get(i));
            Matcher f = b.matcher(toMatch.get(i));
            Matcher g = c.matcher(toMatch.get(i));
            Matcher h = d.matcher(toMatch.get(i));

            boolean j = e.matches();// hex literal
            boolean k = f.matches();// decimal literal
            boolean l = g.matches();// char literal
            boolean m = h.matches();// string literal


            if(!toMatch.get(i).equals("\n") || !toMatch.get(i).equals("\t")){
                if(toMatch.get(i).equals("true")){

                    Token = "true";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);

                }else if (toMatch.get(i).equals("false")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("=")){
                    Token = "equals";
                    Tokentype = "assign_op";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(j){ // hex literal
                    Token = "";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(k){ // decimal literal
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(l){ // char literal
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(m){ // string literal
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("+=")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("-=")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("int")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("boolean")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("callout")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("void")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("if")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("else")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("for")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("return")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("break")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("continue")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("(")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals(")")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("[")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("]")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("{")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("}")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("!")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals(";")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("*")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("+")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("-")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("%")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("/")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("||")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("&&")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("<")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals(">")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("<=")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals(">+")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("==")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else if(toMatch.get(i).equals("!=")){
                    Token = "false";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }else{
                    Token = "main";
                    Tokentype = "bool_literal";
                    tokenize[count]=new Token(Token, Tokentype,toMatch.get(i),count);
                }
                count +=1;

            }

        }

        for(int i = 0; i<tokenize.length; i++) {
            tokenize[i].display();
            System.out.println(" ");
        }

    }

}

//java Compiler test.decaf -target scan

