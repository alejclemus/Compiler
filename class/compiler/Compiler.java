
public class CLI{
    public static  void main(String[] args){
        Scanner scan = new Scanner(System.in);
        CLImenu();
    }
}
public static void CLImenu() {
    boolean out = false;
    int hValue;

    while(!out){
        System.out.println("-o <outname>\n"+
                "-target <target>\n"+
                "-opt <opt_stage>\n"+
                "-debug <stage>\n"+
                "-quit");
}

