

import java.util.Scanner;

public class Compiler {
    public static void main(String[] args) {
        int argCount = args.length;
        String filename="";
        String param=""; //[option]
        String paramflag=""; //[option] <outname>, <stage>, etc.
        if (argCount==0) {
            CLImenu();
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            String[] stringArray = input.split(" ");
            for (int i = 0; i < stringArray.length; i++) {
                if(i==0){
                    param=stringArray[i];
                    if (stringArray.length==1){
                        paramflag="scan"; // scan is the default target for now
                    }
                }
                if (i==1){
                    paramflag=stringArray[i].toString();
                }
            }

        }
        else {
            for (int i = 0; i < args.length; i++) {
                if(i==0){
                    filename=args[i];
                }
                if (i==1){
                    param=args[i].toString();
                }
                if (i==2){
                    paramflag=args[i].toString();
                }
            }
        }

        switch (param){
            case "-o":
                break;
            case "-target":
                switch (paramflag){
                    case "scan":
                        System.out.println("stage: scanning");
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
            System.out.println("Possible options include:\n"+
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


