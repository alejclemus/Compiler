package scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.*;


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

                }else if (toMatch.get(i).equals("false")){

                }else if(toMatch.get(i).equals("=")){

                }else if(j){ // hex literal

                }else if(k){ // decimal literal

                }else if(l){ // char literal

                }else if(m){ // string literal

                }else if(toMatch.get(i).equals("+=")){

                }else if(toMatch.get(i).equals("-=")){

                }else if(toMatch.get(i).equals("int")){

                }else if(toMatch.get(i).equals("boolean")){

                }else if(toMatch.get(i).equals("callout")){

                }else if(toMatch.get(i).equals("void")){

                }else if(toMatch.get(i).equals("if")){

                }else if(toMatch.get(i).equals("else")){

                }else if(toMatch.get(i).equals("for")){

                }else if(toMatch.get(i).equals("return")){

                }else if(toMatch.get(i).equals("break")){

                }else if(toMatch.get(i).equals("continue")){

                }else if(toMatch.get(i).equals("(")){

                }else if(toMatch.get(i).equals(")")){

                }else if(toMatch.get(i).equals("[")){

                }else if(toMatch.get(i).equals("]")){

                }else if(toMatch.get(i).equals("{")){

                }else if(toMatch.get(i).equals("}")){

                }else if(toMatch.get(i).equals("!")){

                }else if(toMatch.get(i).equals(";")){

                }else if(toMatch.get(i).equals("*")){

                }else if(toMatch.get(i).equals("+")){

                }else if(toMatch.get(i).equals("-")){

                }else if(toMatch.get(i).equals("%")){

                }else if(toMatch.get(i).equals("/")){

                }else if(toMatch.get(i).equals("||")){

                }else if(toMatch.get(i).equals("&&")){

                }else if(toMatch.get(i).equals("<")){

                }else if(toMatch.get(i).equals(">")){

                }else if(toMatch.get(i).equals("<=")){

                }else if(toMatch.get(i).equals(">+")){

                }else if(toMatch.get(i).equals("==")){

                }else if(toMatch.get(i).equals("!=")){

                }else{
                    //main

                }


            }

        }

    }

}

//java Compiler test.decaf -target scan

