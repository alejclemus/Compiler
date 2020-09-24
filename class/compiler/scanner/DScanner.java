package scanner;
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.*;


public class DScanner {
    public static void main(String[] args) {
    Regex("main() -> void {\n" +
            "print(\"Hello world!\\n\");\n" +
            "\n" +
            "}");
    }

    static String Regex(String program){
        Pattern pattern = Pattern.compile("Class Program|\\{| }|\\[|]|,|;|=|-|\\+|-=|!|<|>|<=|>=|==|!=|\\+=|\\*|/|&&|\\|\\||%|//|\"|\'|\\\\|\'|\"|\n|\t|\\(|\\)|int|boolran|if|for|return|break|continue|callout|true|false|void|else|0[x|X][\\w|\\d]+|\\d+|[\\w][\\w\\d_]+|[\\W]+ ");
        Matcher matcher = pattern.matcher(program);

    }





}

