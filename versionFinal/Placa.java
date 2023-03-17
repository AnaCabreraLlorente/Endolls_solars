package endolls_solars;

public class Placa {
    private int superficie;
    private float preu;
    private int potencia;

    /* CONSTRUCTOR
     Comprobamos si la superficie y el precio es menor o igual a 0, si es así lanzamos una excepción*/
    public Placa(int superficie, float preu, int potencia) throws InstantiationError {
        if (superficie <= 0){
            throw new InstantiationError(Constantes.ERROR_SUP_PLACA);}
        if (preu <= 0){
           throw new InstantiationError(Constantes.ERROR_PREU);}
        this.superficie = superficie;
        this.preu = preu;
        this.potencia = potencia;
    }

    /* GETTERS AND SETTERS */
    public int getSuperficie() {
        return superficie;
    }

    public int getPotencia() {
        return potencia;
    }

    public float getPreu() {
        return preu;
    }
}


