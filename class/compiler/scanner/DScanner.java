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

        for(int i =0 ; i< toMatch.size(); i++ ){

            if(!toMatch.get(i).equals("\n") || !toMatch.get(i).equals("\t")){
                if(toMatch.get(i).equals("true")){

                }else if (toMatch.get(i).equals("false")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else if(toMatch.get(i).equals("")){

                }else{

                }


            }

        }

    }

}

//java Compiler test.decaf -target scan

