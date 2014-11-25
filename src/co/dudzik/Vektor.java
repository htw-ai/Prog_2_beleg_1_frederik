package co.dudzik;
import java.util.Arrays;

/**
 * @author      Frederik Dudzik
 * @version     0.0.0
 * @since       2014-11-7
 */
public class Vektor {
    /**
     * the vektorraum of the vektor with max 6 dimensions
     */
    private double[] raum; //= new double[5];

    /**
     * constructor sets the raum of the Vektor
     *
     * @param  vektorraum which is a double
     */
    public Vektor (double[] vektorraum){
        this.raum = vektorraum;
    }

    /**
     * validates a vektor for its demensions
     * <p>
     * thorws a VektorValidationException if validation fails
     * <p>
     *
     * @param  dimensionMax max dimension of the vector in int
     * @param  dimensionMin max dimension of the vector in int
     * @return throws VektorValidationException
     */
    public void validate(int dimensionMax, int dimensionMin) throws VektorValidationException {
        validateDimensionMax(dimensionMax);
        validateDimensionMin(dimensionMin);
    }

    /**
     * validates a vektor for its demensions and demensions of another vektor
     *
     * @param  dimensionMax max dimension of the vector in int
     * @param  dimensionMin max dimension of the vector in int
     * @param  dimensionsEquals checks if another vektor has the same dimension
     * @return throws VektorValidationException if validation fails
     */
    public void validate(int dimensionMax, int dimensionMin, Vektor dimensionsEquals) throws VektorValidationException {
        validateDimensionMax(dimensionMax);
        validateDimensionMin(dimensionMin);
        validateDimensionEquals(dimensionsEquals);
    }

    /**
     * validates a vektor for its demensions and demensions of another vektor
     *
     * @param  dimensionMax max dimension of the vector in int
     * @param  dimensionMin max dimension of the vector in int
     * @param  dimensionsEquals checks if each element in vektor array has the same dimension as this vektor
     * @return throws VektorValidationException if validation fails
     */
    public void validate(int dimensionMax, int dimensionMin, Vektor[] dimensionsEquals) throws VektorValidationException {
        validateDimensionMax(dimensionMax);
        validateDimensionMin(dimensionMin);
        validateDimensionEquals(dimensionsEquals);
    }

    /**
     * validates if a vektor has max x dimension
     *
     * @param  dimension the max dimensions the vektor has
     * @return throws VektorValidationException if validation fails
     */
    public void validateDimensionMax(int dimension) throws VektorValidationException {
        if(this.hasDimensionOf() > (dimension)){
            throw new VektorValidationException("vektor ist zu lang mit einer dimension von "+ this.hasDimensionOf() +". sollte maximal "+ dimension+" sein");
        }
    }

    /**
     * validates if a vektor has min x dimension
     *
     * @param  dimension the min dimensions the vektor has
     * @return throws VektorValidationException if validation fails
     */
    public void validateDimensionMin(int dimension) throws VektorValidationException {
        if(this.hasDimensionOf() < (dimension)){
            throw new VektorValidationException("vektor ist zu kurz mit einer dimension von "+ this.hasDimensionOf() +". sollte zumindest"+ dimension+" sein");
        }
    }

    /**
     * validates if a vektor has same dimension as another vektor
     *
     * @param  vektor an Vektor instance
     * @return throws VektorValidationException if validation fails
     */
    public void validateDimensionEquals(Vektor vektor) throws VektorValidationException {
        if(this.hasDimensionOf() != vektor.hasDimensionOf()){
            throw new VektorValidationException("vektors doesnt have the same dimensions");
        }
    }

    /**
     * validates if a vektor has same dimension as another each element in Vektor Array
     *
     * @param  vektor an Vektor[] instance
     * @return throws VektorValidationException if validation fails
     */
    public void validateDimensionEquals(Vektor[] vektor) throws VektorValidationException {
        for (int i = 0; i <= this.hasDimensionOf(); i++) {
            if(this.hasDimensionOf() != vektor[i].hasDimensionOf()){
                throw new VektorValidationException("vektors doesnt have the same dimensions");
            }
        }
    }

    /**
     * returns the length(Bzw. Betrag) of the vektor
     *
     * @return double representing the length of the vektor
     */
    public double länge() {
        double sum = 0;
        int length = this.raum.length;
        for(int i=0; i<length; i++){
            // is the same as this.raum[i]^2 but this cant be written because ^ doesnt support double
            sum += this.raum[i] * this.raum[i];
        }
        return Math.sqrt(sum);
    }

    /**
     * adds another Vektor to this Vektor
     *
     * @param  vektor to add to our vektor
     * @return a new Vektor which is the result of the addition
     */
    public Vektor summe(Vektor vektor) {
        double[] vektorraum = vektor.Ausgabe();
        int length = this.raum.length;
        double[] newVektorraum = new double[length];
        for(int i=0; i<length; i++){
            newVektorraum[i] = this.raum[i] + vektorraum[i];
        }
        return new Vektor(newVektorraum);
    }

    /**
     * getter of Raum
     *
     * @return this.raum
     */
    public double[] Ausgabe(){
        return this.raum;
    }

    /**
     * substracts a Vektor from this Vektor
     *
     * @param  vektor to substract from our vektor
     * @return a new Vektor which is the result of the substraction
     */
    public Vektor differenz(Vektor vektor) {
        double[] vektorraum = vektor.Ausgabe();
        int length = this.raum.length;
        double[] newVektorraum = new double[length];
        for(int i=0; i<length; i++){
            newVektorraum[i] = this.raum[i] - vektorraum[i];
        }
        return new Vektor(newVektorraum);
    }

    /**
     * computes the skalarprodukt of our vektor
     *
     * @param  vektor which is used to compued the skalarprodukt
     * @return a double representing a skalarprodukt
    */
    public double skalarprodukt(Vektor vektor) {
        int length = this.raum.length;
        double skalarprodukt = 0.0;
        double[] vektorraum = vektor.Ausgabe();
        for(int i=0; i<length; i++){
            skalarprodukt += this.raum[i] * vektorraum[i];
        }
        return skalarprodukt;
    }

    /**
     * computes the einheitsvektor of this veltor
     *
     * @return a new Vektor as the Einheitsvektor
     */
    public Vektor einheitsvektor() {
        double länge = 1 / this.länge();
        int length = this.raum.length;
        double[] newVektorraum = new double[length];
        for(int i=0; i<length; i++){
            //TODO refactor to double
            newVektorraum[i] = this.raum[i] * länge;
        }
        return new Vektor(newVektorraum);
    }

    /**
     * computes a vektorproduct
     * <p>
     *     min/max 3rd dimension.
     * </p>
     *
     * @param  vektor
     * @return a new Vektor
     */
    public Vektor vektorprodukt(Vektor vektor) {
        double[] vektorraum = vektor.Ausgabe();
        return new Vektor(new double[]{
                this.raum[1] * vektorraum[2] - this.raum[2] * vektorraum[1],
                this.raum[2] * vektorraum[0] - this.raum[0] * vektorraum[2],
                this.raum[0] * vektorraum[1] - this.raum[1] * vektorraum[0]
        });
    }

    /**
     * computes a spatprodukt
     *
     * @param  kreuzprodukt
     * @return a new Vektor which is the result of the computation
     */
    public double spatprodukt(Vektor kreuzprodukt) {
            double[] kreuzraum = kreuzprodukt.Ausgabe();
            double newVektorraum = 0.0;
            for(int i=0; i<3; i++){
                newVektorraum += this.raum[i] * kreuzraum[i];
            }
            return Math.abs(newVektorraum);
    }

    /**
     * Check if this Vektor has the dimension of the provided dimension
     *
     * @param  dimension to test against
     * @return Boolean if the dimension of this raum matches the param dimension
     */
    public boolean isOfDimension(int dimension){
        return hasDimensionOf() == dimension;
    }

    /**
     * get the dimension of this.raum
     * @return raum length as an int
     */
    public int hasDimensionOf(){
        return this.raum.length;
    }

    /**
     * converts this.raum into a String representation
     *
     * @return this.raum as a String
     */
    public String toString(){
        String s = Arrays.toString(this.raum);

        return s;
    }
}

