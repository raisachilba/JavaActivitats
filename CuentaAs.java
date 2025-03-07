package FuncioRecursiva;

public class CuentaAs {

    public static void main(String[] args) {

        String P = "PARAULA";
        cuentaAs(P);
        System.out.printf("La paraula %s té %d As.", P, cuentaAs(P));

    }
    public static int cuentaAs ( String P) {
        if ( P.length() == 1 ) {
            if( P.charAt(0) == 'A' ) {
                return 1 ;
            } else {
                return 0 ;
            }
        }
        else {
            String P1 = P.substring( 0, P.length()/2 );
            String P2 = P.substring( P.length()/2 , P.length() );
            return cuentaAs( P1 ) + cuentaAs( P2 );
        }
    }
}
