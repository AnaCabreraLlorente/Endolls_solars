package endolls_solars;

import java.util.ArrayList;

public class Casa {
    private String nif;
    private String nom;
    private int superficie;

    private int superficieDisponible;

    private boolean interruptor;

    private ArrayList<Placa> listaPlacas;

    private ArrayList<Aparell> listaAparell;

    /* CONSTRUCTOR
    1. Creamos exception de intancia: si la superficie en menor o igual a 10 lanzamos un error.*/
    public Casa(String nif, String nom, int superficie) throws InstantiationError{
        if (superficie <= 10){
            throw new InstantiationError(Constantes.ERROR_SUP_CASA);
        }
        this.nif = nif;
        this.nom = nom;
        this.superficie = superficie;
        this.superficieDisponible = superficie;
        this.interruptor = true;
        this.listaPlacas = new ArrayList<>();
        this.listaAparell = new ArrayList<>();}

    /* ENCENDER INTERRUPTOR */
    public void onInterruptor() {
        interruptor = true;
    }
    /* APAGAR INTERRUPTOR */
    public void offInterruptor() {
        interruptor = false;
    }

    /*  COMPROBAR SI LA PLACA CABE
        1. Guardamos en la variable supCasa la superficie disponible de la casa y en supPlaca la superficie de la placa.
        2. Comprobamos si la superfície de la casa es mayor o igual que la superficie de la placa. Si es así, modificamos la superficie disponible de la casa
        restando la superficie de la casa menos la superficie de la placa y retorna true, si no retorna false.*/
    public boolean cabePlaca (Placa placa){
        int supCasa = getSuperficieDisponible();
        int supPlaca = placa.getSuperficie();
        if (supCasa >= supPlaca) {
            setSuperficieDisponible(supCasa - supPlaca);
            return true;
        }return false;
    }
    /* AÑADIR PLACA */
    public void addPanel(Placa placa){
        listaPlacas.add(placa);
    }
    /* AÑADIR APARELL */
    public void addDevice (Aparell aparell){
        listaAparell.add(aparell);
    }

    /* CALCULAR POTENCIA TOTAL DE LA CASA (Suma potecia placas) */
    public int potenciaTotal(){
        int potenciaTotal = 0;
        for (int i = 0; i < listaPlacas.size(); i++){
            potenciaTotal = potenciaTotal + getListaPlacas().get(i).getPotencia();
        }
        return potenciaTotal;
    }
    /* CALCULAR INVERSION TOTAL DE LA CASA (Suma precio placas) */
    public float inversioTotal(){
        float inversioTotal = 0;
        for (int i = 0; i < listaPlacas.size(); i++){
            inversioTotal = inversioTotal + listaPlacas.get(i).getPreu();

        }return inversioTotal;
    }
    /* CALCULAR EL CONSUMO TOTAL DE LA CASA (Suma consumo de los aparatos) */
    public int consum() {
        int consumAparells = 0;
        for (int j = 0; j < listaAparell.size(); j++) {
            if ((listaAparell.get(j).isInterruptor())) {
                consumAparells = consumAparells + listaAparell.get(j).getConsum();}}
        return consumAparells;}

    /* COMPROBAR SI SALTAN LOS PLOMOS
     1. Comprobamos si la potencia total de la casa es mayor o igual que el cosumo, para ello usamos los dmetodos de la clase CASA
     potenciaTotal y cosum.*/
    public boolean ploms() {
        if (potenciaTotal() >= consum()){
            return true;
        }return false;}
    /* APAGAR TODOS LOS APARELLS */
    public void apagarTotsElsAparells(){
        for (int i = 0; i < listaAparell.size(); i++) {
            listaAparell.get(i).offInterruptor();}
    }

    /* GETTERS AND SETTERS */
    public boolean isInterruptor() {
        return interruptor;
    }
    public String getNif() {
        return nif;
    }
    public String getNom() {
        return nom;
    }
    public int getSuperficieDisponible() {
        return superficieDisponible;
    }
    public void setSuperficieDisponible(int superficieDisponible) {
        this.superficieDisponible = superficieDisponible;
    }
    public ArrayList<Aparell> getListaAparell() {
        return listaAparell;
    }

    public ArrayList<Placa> getListaPlacas() {
        return listaPlacas;
    }

    public int getSuperficie() {
        return superficie;
    }

}






