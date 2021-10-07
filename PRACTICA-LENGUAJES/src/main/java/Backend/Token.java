package Backend;



public class Token {
    public String tipo;
    public String lexema;
    public int Posicion;

    public Token(String tipo, String lexema, int Posicion) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.Posicion = Posicion;
    }

    @Override
    public String toString() {
        return "Token{" + "tipo=" + tipo + ", lexema=" + lexema + ", Posicion=" + Posicion + '}';
    }
        
}
