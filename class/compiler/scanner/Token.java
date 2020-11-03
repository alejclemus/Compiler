package compiler.scanner;

public class Token {
        public String tipo;
        public String valor;


        public Token(String tipo, String Tokentype){
            this.tipo = tipo;
            this.valor = Tokentype;

        }
        public void setTipo(String Token){
            this.tipo =Token;
        }
        public void setValor(String Tokentype){
            this.valor =Tokentype;
        }

        public void display(){
            System.out.println(this.tipo);
            System.out.println(this.valor);

        }
}
