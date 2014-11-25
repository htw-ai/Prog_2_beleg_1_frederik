package co.dudzik;

import java.io.IOException;

/**
 * @author      Frederik Dudzik
 * @version     0.0.0
 * @since       2014-11-7
 */
public class Main {
    /**
     * Starts the programm
     * <p>
     * It wraps VektorCliAdapter into a loop which the user can break when prompted
     * <p>
     *
     * @param  args input arguments, but are not used
     * @return void
     */
    public static void main(String[] args) {
        String again = null;
        while(true) {
            try {
                VektorCliAdapter vektor = new VektorCliAdapter();
                vektor.Eingabe();
                vektor.Ausgabe();
                again = VektorCliAdapter.readLine(": J/[N]");
                if (!again.equals("J")) break;
            }catch(NullPointerException e){
                System.err.println("getötet");
            }catch(IOException e){
                System.err.println("Knotrolieren Sie ihre schreibweise");
            }
        }
    }
}
