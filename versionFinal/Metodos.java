package endolls_solars;

import java.util.ArrayList;
public class Metodos {

    /* AÑADIR UNA CASA:
       1. Comprobar numero de parametros: si se usan 4 paramentros seguimos. Si no error paarametros.
       2. Comprobamos si la casa ya existe, es decir, que ya hay una casa registrada con ese nif.
        Para ello llamamos al metodo casa encontrada que devuleve null si no existe o el objeto casa si existe. Si ya existe mostrar error indicandolo.
       3. Si no hay ninguna casa registrada con ese nif, creamos instacia de la casa (dentro del contructor de CASA se comprueba que la superficie
        sea mayor que 10, si no es mayor muestra error indicandolo. Si  es mayor que 10, añadimos la casa a al Arrayulist de casas.
     */
    public static void addCasa(String[] dades, ArrayList<Casa> casas) {
        if (dades.length == 4) {
            String nif = dades[1]; String nom = dades[2]; String superficie = dades[3];
            if (casaEncontrada(casas, nif) == null) {
                Casa casa = new Casa(nif, nom, Integer.parseInt(superficie));
                casas.add(casa);
                System.out.println(Constantes.OK_CASA_ADD);
            } else System.out.println(Constantes.ERROR_CASA_EXISTENT);
        } else {
            System.out.println(Constantes.ERROR_N_PARAMETROS);
            System.out.println(Constantes.US_ADDCASA);}
    }



    /* COMANDA ADDPLACA
        1. Comprobamos que los parametros sean correctos. Si no error parametros.
        2. Comporbamos que la lista de casas tenga algun registro, si no hay ninguna casa registrada nos da un error indicandolo. Si hay casas...
        3. Guardamos en la variable houseFound el resultado del metodo casaEncontrada (null o objeto casa).
        4. Comprobamos si hay alguna casa ya registrada con el nif especificado, llamando al metodo casaEncontrada.
        Si la hay seguimos, si no error no hay casas registradas con ese NIF.
        5. Una vez localizada la casa donde queremos añadir la placa, creamos instancia de placa.
        En el constructor comprueba que el precio y la superficie sea mayor que 0. Si alguna de la dos no se cumple muestra un mensaje de error indicandolo.
        si todo esta correcto se crea la intancia de la placa.
        6. Comprobamos si cabe la placa en el tejado de la casa con el método cabePlaca. Si cabe registra la placa en la casa, si no muestra error.
     */

    public static void addPlaca(String[] dades, ArrayList<Casa> casas){
        if (dades.length == 5) {
            String nif = dades[1]; String superficie = dades[2]; String preu = dades[3]; String potencia = dades[4];
            if (casas.size() > 0) {
                Casa houseFound =  Metodos.casaEncontrada(casas, nif);
                if (houseFound != null) {
                    Placa placa = new Placa(Integer.parseInt(superficie), Float.parseFloat(preu), Integer.parseInt(potencia));
                    if (houseFound.cabePlaca(placa)) {
                        houseFound.addPanel(placa);
                        System.out.println(Constantes.OK_PLACA_ADD);
                    } else System.out.println(Constantes.ERROR_ESPACIO_PLACA);
                } else System.out.println(Constantes.ERROR_NIFCASA_COINCIDENT);
            } else System.out.println(Constantes.ERROR_NO_CASAS);
        } else {System.out.println(Constantes.ERROR_N_PARAMETROS); System.out.println(Constantes.US_ADDPLACA);}}


    /* COMANDA ADDAPARELL:
      1. Comprobar numero de parametros: si se usan 4 paramentros seguimos. Si no error paarametros.
      2. Comporbamos que la lista de casas tenga algun registro, si no hay ninguna casa registrada nos da un error indicandolo. Si hay casas...
      3. Guardamos en la variable houseFound el resultado del metodo casaEncontrada (null o objeto casa).
      4. Comprobamos si hay alguna casa ya registrada con ese nif llamando al metodo casaEncontrada. Si la hay seguimos, si no error no hay casas registradas.
      5. Una vez localizada la casa donde queremos añadir el aparell, creamos instancia de aparell.
      En el constructor comprueba que la potencia/consum sea mayor que 0. Si no se cumple muestra un mensaje de error indicandolo.
      Si todo esta correcto se crea la intancia del aparato.
      6. Miramos si el aparato que queremos añadir ya existe en la lista de aparatos de la casa especificada con el metodos aparellEncontrado.
      Si ya existe nos muestra un error indicandolo, si no existe...
      7. Añadimos el aparato a la lista de aparatos de la casa con el metodo de la clase CASA addPanel.
    */
    public static void addAparell(String[] dades, ArrayList<Casa> casas) {
        if (dades.length == 4) {
            String nif = dades[1];String nomAparell = dades[2];String consum = dades[3];
            if (casas.size() > 0) {
                Casa houseFound = Metodos.casaEncontrada(casas, nif);
                if (houseFound != null) {
                    Aparell aparell = new Aparell(nomAparell, Integer.parseInt(consum));
                    if (Metodos.aparellEncontrado(houseFound, nomAparell) == null) {
                        houseFound.addDevice(aparell);
                        System.out.println(Constantes.OK_APARELL_ADD);
                    } else System.out.println(Constantes.ERROR_APERELL_EXISTENT);
                } else System.out.println(Constantes.ERROR_NIFCASA_COINCIDENT);
            } else System.out.println(Constantes.ERROR_NO_CASAS);
        } else{ System.out.println(Constantes.ERROR_N_PARAMETROS); System.out.println(Constantes.US_ADDAPARELL);}
    }

    /*  COMANDA ENCENDER UNA CASA
        1. Comprobamos que el número de parametros sea correcto. Si no lo es muestra mensaje de error.
        2. Creamos variable de tipo Casa donde guardamos el resultado del método casaEncontrada, que devuelve la casa coincidente
        con el NIF especificado o null en caso que no haya ninguna casa con es NIF.
        3. Comprobamos el resultado del método, si es null mostrará mensaje de error.
        4. Si no es null, comprobamos si el interruptor de la casa está encendido, si no lo está encendemos
        el interruptor de la casa llamando al método de la clase CASA onInterruptor.
        5. Si el interruptor ya está encendido muestra error.*/
    public static void onCasa(ArrayList<Casa> casas, String[] dades) {
        if (dades.length == 2) {
            String nif = dades[1];
            if (casas.size() > 0) {
                Casa houseFound = casaEncontrada(casas, nif);
                if (houseFound != null) {
                    if (!houseFound.isInterruptor()) {
                        houseFound.onInterruptor();
                        System.out.println(Constantes.OK_ON_CASA);
                    } else System.out.println(Constantes.ERROR_CASA_ON);
                } else System.out.println(Constantes.ERROR_NIFCASA_COINCIDENT);
            }else System.out.println(Constantes.ERROR_NO_CASAS);
        } else {System.out.println(Constantes.ERROR_N_PARAMETROS); System.out.println(Constantes.US_ONCASA);}
    }
    /*  COMANDA APAGAR UNA CASA
        1. Comprobamos que el número de parametros sea correcto. Si no lo es muestra mensaje de error.
        2. Creamos variable de tipo Casa donde guardamos el resultado del método casaEncontrada, que devuelve la casa coincidente
        con el NIF especificado o null en caso que no haya ninguna casa con es NIF.
        3. Comprobamos el resultado del método, si es null mostrará mensaje de error.
        4. Si no es null, comprobamos si el interruptor de la casa está encendido, si lo está apagamos
        el interruptor de la casa llamando al método de la clase CASA offInterruptor.
        5. Si el interruptor ya está apagado muestra error.
    */
    public static void offCasa(ArrayList<Casa> casas, String[] dades) {
        if (dades.length == 2) {
            String nif = dades[1];
            if (casas.size() > 0) {
                Casa houseFound = casaEncontrada(casas, nif);
                if (houseFound != null) {
                    if (houseFound.isInterruptor()) {
                        houseFound.offInterruptor();
                        System.out.println(Constantes.OK_OFF_CASA);
                    } else System.out.println(Constantes.ERROR_CASA_OFF);
                }else System.out.println(Constantes.ERROR_NIFCASA_COINCIDENT);
            }else System.out.println(Constantes.ERROR_NO_CASAS);
        } else {System.out.println(Constantes.ERROR_N_PARAMETROS); System.out.println(Constantes.US_OFCASA);}
    }

    /* COMANDA ENCENDER UN APARATO:
     1. Comprobamos que el número de parametros sea correcto. Si no lo es muestra mensaje de error.
     2. Creamos variable de tipo Casa donde guardamos el resultado del método casaEncontrada, que devuelve la casa coincidente
    con el NIF especificado o null en caso que no haya ninguna casa con es NIF.
     3. Comprobamos el resultado del método, si es null mostrará mensaje de error.
     4. Si no es null, guardamos en una variable de tipo aparell null o el aparell coincidente
     con el nombre especificado si lo hay usando el métdodo aparellEncontrado.
     5. Comprobamos si el método ha devuleto null o el aparato, si es null muestra error. Si no es null..
     6. Comprueba si el interruptor de la casa está encendido, si es así encendemos el interruptor del aparell con el método onInterruptor de la clase APARELL.
     7. Una vez encendido comprobamos si la casa tiene sufuciente energia para que no salten los plomos (método ploms) que devuelve true o false.
     8. Si es true muestra mensaje confirmando que se ha encendio el aparell.
     9. Si es false, saltan los plomos (mensaje de error) apagamos el interruptor general de la casa (método offInterruptor)
       y llamamos al método apagarTotsElsAparells para apagarlo todos los aparells de la casa.
    */
    public static void onAparell(String[] dades, ArrayList<Casa> casas) {
        if (dades.length == 3) {
            String nif = dades[1]; String nomAparell = dades[2];
            Casa houseFound = Metodos.casaEncontrada(casas, nif);
            if (houseFound != null) {
                Aparell aparellFound = Metodos.aparellEncontrado(houseFound, nomAparell);
                if (aparellFound != null) {
                    if (houseFound.isInterruptor()) {
                        if (!aparellFound.isInterruptor()) {
                            aparellFound.onInterruptor();
                            if (houseFound.ploms()) {
                                System.out.println(Constantes.OK_APARELL_ON);
                            } else {
                                System.out.println(Constantes.ERROR_PLOMS);
                                houseFound.offInterruptor();
                                houseFound.apagarTotsElsAparells();}
                        }else System.out.println(Constantes.ERROR_APARELL_ON);
                    } else System.out.println(Constantes.ERROR_A_CASA_OFF);
                } else System.out.println(Constantes.ERROR_APARELL_COINCIDENT);
            } else System.out.println(Constantes.ERROR_NIFCASA_COINCIDENT);
        } else{ System.out.println(Constantes.ERROR_N_PARAMETROS);System.out.println(Constantes.US_ONAPARELL);}
    }

    /* COMANDA APAGAR UN APARATO:
  1. Comprobar numero de parametros: si se usan 3 paramentros seguimos. Si no error parametros.
  2. Comprobamos si la casa ya existe, es decir, que ya hay una casa registrada.
   Para ello llamamos al metodo casa encontrada que devuleve null si no existe o el objeto casa si existe. Si ya existe muestra error indicandolo.
  3. Comprobamos si el aparato ya existe en la lista de aparatos de la casa, para ello llamamos al metodo aparellEncontrado
   que devuleve null si no existe o el objeto Aparell si existe.
   4. Si existe, comprobamos si el interruptor general de la casa está encendido, si está apagado nos muestra error indicandolo.
   5. Si está encendido, comprobamos si el interruptor del aparell está enecendido.
   6. Si está encendido, apagamos el interruptor del aparell con el método offInterruptor de la clase APARELL.
   7. Si está apagado mostramos error indicandolo.
*/
    public static void offAparell(String[] dades, ArrayList<Casa> casas){
        if (dades.length == 3) {
            String nif = dades[1]; String nomAparell = dades[2];
            Casa houseFound = Metodos.casaEncontrada(casas, nif);
            if (houseFound != null){
                Aparell aparellFound = Metodos.aparellEncontrado(houseFound, nomAparell);
                if (aparellFound != null) {
                    if (houseFound.isInterruptor()) {
                        if (aparellFound.isInterruptor()) {
                            aparellFound.offInterruptor();
                            System.out.println(Constantes.OK_APARELL_OFF);
                        } else System.out.println(Constantes.ERROR_APARELL_OFF);
                    }else System.out.println(Constantes.ERROR_A_CASA_OFF);
                }else System.out.println(Constantes.ERROR_APARELL_COINCIDENT);
            } else System.out.println(Constantes.ERROR_NIFCASA_COINCIDENT);
        } else {System.out.println(Constantes.ERROR_N_PARAMETROS); System.out.println(Constantes.US_OFFAPARELL);}}


    /*  INFO -- MOSTRAMOS DATOS DE UNA CASA EN CONCRETO
        1. Comprobamos que los parametros dado sean correctos, si no muestra mensaje de error.
        2. Guardamos en una variable de tipo casa el resultado del método casaEnciontrada (null o casa coincidente con el nif especificado)
        3. Comprobamos el resultado del metodo, si no es null mostramos los datos de la casa (print).
        Dentro tenemos otra condición, si el consumo de la casa es mayor a 0, es decir, hay aparatos encencidos,
        recorremos la lista de aparells de la casa y mostramos los que hay encencidos.
        4. Si es null y no se encontró la casa coincidente con el nif muestra error.*/
    public static void info(ArrayList<Casa> casas, String[] dades){
        if (dades.length == 2) {
            String nif = dades[1];
            Casa houseFound = Metodos.casaEncontrada(casas, nif);
            if (houseFound != null){
                System.out.println("Client: " + houseFound.getNif() + " - " + houseFound.getNom());
                System.out.println("Plaques solars instal·lades: " + houseFound.getListaPlacas().size());
                System.out.println("Pòtencia total: " +  houseFound.potenciaTotal() + "W");
                System.out.println("Inversió total: " + houseFound.inversioTotal() + "€");
                System.out.println("Aparells registrats: " + houseFound.getListaAparell().size());
                System.out.println("Consum actual: " + houseFound.consum() + "W");
                if ( houseFound.consum() > 0) {
                    System.out.println("Aparells encesos:");
                    for (int i = 0; i < houseFound.getListaAparell().size(); i++) {
                    if ( houseFound.getListaAparell().get(i).isInterruptor()) {
                        System.out.println("- " + houseFound.getListaAparell().get(i).getDescripcio());}}
            }
        } else System.out.println(Constantes.ERROR_NIFCASA_COINCIDENT);
    }else {System.out.println(Constantes.ERROR_N_PARAMETROS); System.out.println(Constantes.US_INFO);}}

    /* LIST -- MOSTRAMOS LOS DATOS DE LAS CASAS REGISTRADAS
     1. Comprobamos que los parametros introducidos sean correctos, si no muestra error.
     2. Comprobamos si la lista de casa tiene alguna casa registrada, si no es asi muestra mensaje de error.
     3. Si tiene casas registradas mostramos (print) los datos de las casa registradas.
     4. Para ello hacemos un bucle de la longitud de registros de la lista de casas y sacamos los datos. */
    public static void list(ArrayList<Casa> casas, String[] dades){
        if (dades.length == 1){
            if (casas.size() > 0) {
                System.out.println("-----Endolls Solars, S.L.------");
                System.out.println("Cases registrades: " + casas.size() + "\n");
                for (int i = 0; i < casas.size(); i++) {
                    Casa casa = casas.get(i);
                    System.out.println("CASA " + (i + 1));
                    System.out.println("Client: " + casa.getNif() + " - " + casa.getNom());
                    System.out.println("Superfície de teulada: " + casa.getSuperficie());
                    System.out.println("Superfície disponible: " + casa.getSuperficieDisponible());
                    if (casa.isInterruptor()) {
                        System.out.println(Constantes.MSG_ENCES);
                    } else System.out.println(Constantes.MSG_APAGAT);
                    if (casa.getListaPlacas().size() > 0) {
                        System.out.println("Plaques solars instal·lades: " + casa.getListaPlacas().size());
                    } else System.out.println(Constantes.MSG_NO_PLAQUES_REGISTRADES);
                    if (casa.getListaAparell().size() > 0) {
                        System.out.println("Aparells registrats: " + casa.getListaAparell().size() + "\n");
                    } else System.out.println(Constantes.MSG_NO_APARELLS_REGISTRATS + "\n");
                }
            } else System.out.println(Constantes.ERROR_NO_CASAS);
        }else{ System.out.println(Constantes.ERROR_N_PARAMETROS); System.out.println(Constantes.US_LIST);}}

    /* BUSCAMOS CASA COINCIDENTE
    1. Método que busca por nif una casa dentro de la lista de casas y devuelve null si no hay ninguna con ese nif o la casa con el nif coincidente. */
    public static Casa casaEncontrada(ArrayList<Casa> casas, String nif) {
        Casa houseFound = null;
        for (int i = 0; i < casas.size(); i++) {
            Casa casa = casas.get(i);
            if (nif.equalsIgnoreCase(casa.getNif())) {
                houseFound = casa;}}
        return houseFound;
    }
    /* BUSCAMOS APARELL COINCIDENTE
     1. Método que busca por descripción un aparell dentro de la lista de aparells de una casa espefifica y
    devuelve null si no hay ninguno con esa descripción o el aparell con la descripción coincidente. */
    public static Aparell aparellEncontrado(Casa casa, String descripcioAparell) {
        Aparell aparellFound = null;
        for (int i = 0; i < casa.getListaAparell().size(); i++) {
            Aparell aparell = casa.getListaAparell().get(i);
            if (descripcioAparell.equalsIgnoreCase(aparell.getDescripcio())) {
                aparellFound = aparell;}}
        return aparellFound;
    }
}