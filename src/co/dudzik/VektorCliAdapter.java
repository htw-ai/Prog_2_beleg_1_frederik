package co.dudzik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author      Frederik Dudzik
 * @version     0.0.0
 * @since       2014-11-8
 */
class VektorCliAdapter {
    /**
     * a list of all the Vektor methods which can be accessed by the user from the cli
     */
    private static String[] methods = { "länge" , "summe", "differenz", "skalarprodukt", "einheitsvektor", "vektorprodukt", "spatprodukt"};
    /**
     * a list of all the Vektor methods as enums
     */
    public static enum eMethods {
        LÄNGE , SUMME, DIFFERENZ, SKALARPRODUKT, EINHEITSVEKTOR, VEKTORPRODUKT, SPATPRODUKT
    }

    /**
     * the return value of Eingabe
     */
    private String returnValue;

    /**
     * gives the user the possebilety to interact with the Vektor class from the command line
     *
     * @return void
     */
    public void Eingabe() {
            try {
                System.out.println("Methoden:");
                System.out.println(methodsToString());

                String method = readLine("Geben sie die Methode ein die Sie anwenden möchten");

                Vektor vektor;
                Vektor vektor1;
                Vektor vektor2;

                eMethods eMethod = eMethods.valueOf(method.toUpperCase());

                switch (eMethod) {
                    case EINHEITSVEKTOR:
                        vektor = convert(readLine("Geben sie einen Vektor in der Haskell list notation ein: x:xs , max 6  dimensionen"));
                        vektor.validate(6, 1);
                        this.returnValue = vektor.einheitsvektor().toString();
                        break;
                    case LÄNGE:
                        vektor = convert(readLine("Geben sie einen Vektor in der Haskell list notation ein: x:xs , max 6  dimensionen"));
                        vektor.validate(6, 1);
                        this.returnValue = String.valueOf(vektor.länge());
                        break;
                    case SUMME:
                        vektor = convert(readLine("Geben sie einen Vektor in der Haskell list notation ein: x:xs , max 6  dimensionen"));
                        vektor1 = convert(readLine("Geben sie einen  zweiten Vektor in der Haskell list notation ein: x:xs , max 6  dimensionen"));
                        vektor.validate(6, 1, vektor1);
                        this.returnValue = (vektor.summe(vektor1).toString());
                        break;
                    case DIFFERENZ:
                        vektor = convert(readLine("Geben sie einen Vektor in der Haskell list notation ein: x:xs , max 6  dimensionen"));
                        vektor1 = convert(readLine("Geben sie einen  zweiten Vektor in der Haskell list notation ein: x:xs , max 6  dimensionen"));
                        vektor.validate(6, 1, vektor1);
                        this.returnValue = (vektor.differenz(vektor1).toString());
                        break;
                    case SKALARPRODUKT:
                        vektor = convert(readLine("Geben sie einen Vektor in der Haskell list notation ein: x:xs , max 6  dimensionen"));
                        vektor1 = convert(readLine("Geben sie einen  zweiten Vektor in der Haskell list notation ein: x:xs , max 6  dimensionen"));
                        vektor.validate(6, 1, vektor1);
                        this.returnValue = (String.valueOf(vektor.skalarprodukt(vektor1)));
                        break;
                    case VEKTORPRODUKT:
                        vektor = convert(readLine("Geben sie einen Vektor in der Haskell list notation ein: x:xs , max 3  dimensionen"));
                        vektor1 = convert(readLine("Geben sie einen Vektor in der Haskell list notation ein: x:xs , max 3  dimensionen"));
                        vektor.validate(3, 1, vektor1);
                        this.returnValue = (vektor.vektorprodukt(vektor1).toString());
                        break;
                    case SPATPRODUKT:
                        vektor = convert(readLine("Geben sie einen Vektor in der Haskell list notation ein: x:xs , max 3  dimensionen"));
                        vektor1 = convert(readLine("Geben sie einen zweiten Vektor in der Haskell list notation ein: x:xs , max 3  dimensionen"));
                        vektor2 = convert(readLine("Geben sie einen dritten Vektor in der Haskell list notation ein: x:xs , max 3  dimensionen"));
                        Vektor[] aVektor = { vektor1, vektor2 };
                        vektor.validate(6, 1, vektor1);
                        vektor.validate(6, 1, vektor2);
                        this.returnValue = (String.valueOf(vektor.spatprodukt(vektor1.vektorprodukt(vektor2))));
                        break;
                    default:
                        this.returnValue = ("Diese methode existiert nicht. Versuchen sie es nochmal.");
                }
            } catch(VektorValidationException e){
                this.returnValue = e.toString();
            } catch(NumberFormatException e) {
                this.returnValue = "Nur Nummern in der Java double notation erlaubt";
            } catch(IllegalArgumentException e) {
                this.returnValue = "Diese methode existiert nicht. Versuchen sie es nochmal.";
            } catch(Exception e) {
                this.returnValue = "IOException: "+e.getClass();
            }
    }

   
    /**
     * convert instance method methods to a String
     *
     * @return a representation of the instance variable methods as a string
     */
    public static String methodsToString(){
        String foo = "";
        for (int i = 0; i < methods.length; i++) {
            foo += methods[i] + "\n";
        }
        return foo;
    }

    /**
     * takes an string in the haskel list notation and turns it into a double[]
     *
     * @param  to_convert is a string in the haskel list notation
     * @return an double[] build from to_convert
     */
    public static Vektor convert(String to_convert){
        String[] ls;
        String[] a_to_convert = to_convert.split(":");
        int to_convert_length = a_to_convert.length;
        double[] d = new double[to_convert_length];
        for(int i=0;i<to_convert_length;i++)
        {
            d[i] = Double.parseDouble(a_to_convert[i]);
        }
        return new Vektor(d);
    }

    /**
     * prints result of Eingabe to the console
     *
     * @return void
     */
    public void Ausgabe() {
        System.out.println(this.returnValue);
    }

    /**
     * promts the user to enter somthing into the console and returns its value
     *
     * @param to_print String which is printed before the line is read
     * @return string from console
     */
    public static String readLine(String to_print) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(to_print);
        return br.readLine();
    }
}
