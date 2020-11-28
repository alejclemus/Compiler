package scanner;

public class Token {
        public String tipo;
        public String valor;


        public Token(String tipo, String valor){
            this.tipo = tipo;
            this.valor = valor;

        }
        public void setTipo(String Token){
            this.tipo =Token;
        }
        public void setValor(String Tokentype){
            this.valor =Tokentype;
        }

    @Override
    public String toString() {
        return tipo;
    }
}
