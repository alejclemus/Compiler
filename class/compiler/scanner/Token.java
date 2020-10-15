package scanner;

public class Token {
    public String Token;
    public String Tokentype;


    public Token(String Token, String Tokentype, String getToken, int line){
        this.Token = Token;
        this.Tokentype = Tokentype;

    }
    public void setToken(String Token){
        this.Token=Token;
    }
    public void setTokentype(String Tokentype){
        this.Tokentype=Tokentype;
    }

    public void display(){
        System.out.println(this.Token);
        System.out.println(this.Tokentype);

    }

}
