package endolls_solars;

public class Aparell {
    private String descripcio;
    private int consum;

    private boolean interruptor;

    /* CONSTRUCTOR
    Comprobamos si la superficie y el precio es menor o igual a 0, si es así lanzamos una excepción*/
    public Aparell(String descripcio, int consum) throws InstantiationError {
        if (consum <= 0){
            throw new InstantiationError(Constantes.ERROR_APARELL_POTENCIA);
        }
        this.descripcio = descripcio;
        this.consum = consum;
        this.interruptor = false;
    }
    /* ENCENDER INTERRUPTOR */
    public void onInterruptor() {
        interruptor = true;
        }
    /* APAGAR INTERRUPTOR */
    public void offInterruptor() {
        interruptor = false;
        }
    /* GETTERS AND SETTERS */
    public String getDescripcio() {
        return descripcio;
    }

    public boolean isInterruptor() {
        return interruptor;
    }

    public int getConsum() {
        return consum;
    }
}
