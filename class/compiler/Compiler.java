import scanner.DScanner;

import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

public class Compiler {
    public String filename;
    public static void main(String[] args) {
        String param=""; //[option]
        String paramflag=""; //[option] <outname>, <stage>, etc.
        CLI(args,param,paramflag);

    }

    public static String readFile(String filename){
        String FinalString="";
        try {
            File stringFile = new File(filename);
            Scanner in = new Scanner(stringFile);
            while (in.hasNextLine()) {
                FinalString += in.nextLine();
            }
            in.close();
        } catch (FileNotFoundException error) {
            System.out.println("An error occurred: ");
            error.printStackTrace();
        }
        return FinalString;
    }

    static void CLI(String[] args, String param, String paramflag){
        String filename="";
        int argCount = args.length;
        if (argCount==0) {
            CLImenu();
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            String[] stringArray = input.split(" ");
            for (int i = 0; i < stringArray.length; i++) {
                if(i==2){
                    filename+=stringArray[i];
                    if (stringArray.length==3){
                        param="-target";
                        paramflag="scan"; // scan is the default target for now
                    }
                }
                if (i==3){
                    filename+=stringArray[2];
                    param=stringArray[i];
                    if (param == "-target"){
                        paramflag="scan"; // scan is the default target for now
                    }
                }
                if (i==4){
                    filename+=stringArray[2];
                    param=stringArray[3];
                    paramflag=stringArray[4];
                }
            }

        }
        if (argCount==1){
            filename+=args[0];
            param="-target";
            paramflag="scan"; // scan is the default target for now
        }
        if (argCount >=2) {
            for (int i = 0; i < args.length; i++) {
                if(i==0){
                    filename+=args[i];
                }
                if (i==1){
                    param=args[i];
                }
                if (i==2){
                    paramflag=args[i];
                }
            }
        }

        String Scanstring=readFile(filename);
        DScanner scanner = new DScanner();

        switch (param){
            case "-o":
                System.out.println("Output is in "+paramflag);
                break;
            case "-target":
                switch (paramflag){
                    case "scan":
                        System.out.println("stage: scanning");
                        scanner.TokenAssignment(scanner.Regex(Scanstring));

                        break;
                    case "parse":
                        System.out.println("stage: scanning");
                        System.out.println("stage: parsing");
                        break;
                    case "ast":
                        System.out.println("stage: scanning");
                        System.out.println("stage: parsing");
                        System.out.println("stage: ast");
                        break;
                    case "semantic":
                        System.out.println("stage: scanning");
                        System.out.println("stage: parsing");
                        System.out.println("stage: ast");
                        System.out.println("stage: semantic");
                        break;
                    case "irt":
                        System.out.println("stage: scanning");
                        System.out.println("stage: parsing");
                        System.out.println("stage: ast");
                        System.out.println("stage: semantic");
                        System.out.println("stage: irt");
                        break;
                    case "codegen":
                        System.out.println("stage: scanning");
                        System.out.println("stage: parsing");
                        System.out.println("stage: ast");
                        System.out.println("stage: semantic");
                        System.out.println("stage: irt");
                        System.out.println("stage: codegen");
                        break;
                }
                break;
            case "-opt":
                switch (paramflag){
                    case "constant":
                        System.out.println("optimizing: constant folding");
                        break;
                    case "algebraic":
                        System.out.println("optimizing: algebraic simplification");
                        break;
                }
                break;
            case "-debug":
                System.out.println("Debugging "+paramflag);
                break;
        }
    }


    static void CLImenu() {
            System.out.println("Usage: java Compiler <filename> [option]\n"
                    +"Possible options include:\n"+
                    "-o <outname>\n" +
                    "-target <stage>\n" +
                    "\t scan" +
                    "\t\t parse" +
                    "\t\t ast" +
                    "\t\t semantic" +
                    "\t\t irt" +
                    "\t\t codegen\n" +
                    "-opt <opt_stage>\n" +
                    "\t constant" +
                    "\t\t algebraic\n" +
                    "-debug <stage>\n You can add more than one stage with ':'\n" +
                    "\t scan" +
                    "\t\t parse" +
                    "\t\t ast" +
                    "\t\t semantic" +
                    "\t\t irt" +
                    "\t\t codegen\n");
    }
}


