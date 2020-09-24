package scanner;

public class Token {
    public String Token;
    public String Tokentype;
    public String getToken;
    public int line;
    public Token(String Token, String Tokentype, String getToken, int line){
        this.Token = Token;
        this.Tokentype = Tokentype;
        this.getToken = getToken;
        this.line=line;
    }
    public void setToken(String Token){
        this.Token=Token;
    }
    public void setTokentype(String Tokentype){
        this.Tokentype=Tokentype;
    }
    public void setGetToken(String getToken){
        this.getToken=getToken;
    }
    public void setLine(int line){
        this.line=line;
    }
    public void display(){
        System.out.println(this.Token);
        System.out.println(this.Tokentype);
        System.out.println(this.getToken);
        System.out.println(this.line);
    }

}
