package endolls_solars;

import java.security.PublicKey;

public class Constantes {

    /* CONSTANTES TEXTOS OK */
    public static final String OK_CASA_ADD = "OK: Casa registrada.";
    public static final String OK_ON_CASA = "OK: Interruptor general activat.";
    public static final String OK_OFF_CASA = "OK: Interruptor general apagat.";
    public static final String OK_PLACA_ADD = "OK: Placa registrada a la casa.";

    public static final String OK_APARELL_ADD = "OK: Aparell registrat a la casa.";
    public static final String OK_APARELL_ON = "OK: Aparell encès.";
    public static final String OK_APARELL_OFF = "OK: Aparell apagat.";
    public static final String ERROR_COMANDA = "ERROR: Comanda incorrecta.";

    /* CONSTANTE ERROR EN EL NUMEROS DE PARAMETROS*/
    public static final String ERROR_N_PARAMETROS = "ERROR: Numero de parametres incorrecte.";

    /* CONSTANTES TEXTOS USO DE PARAMETROS */
    public static final String US_ADDCASA = "Ús: addCasa [nif] [nom] [superficie]";
    public static final String US_ADDPLACA = "Ús: addPlaca [nif] [superficie] [preu] [potència]";
    public static final String US_ADDAPARELL = "Ús: addAparell [nif] [descripció] [potència]";
    public static final String US_ONCASA = "Ús: onCasa [nif]";
    public static final String US_OFCASA = "Ús: offCasa [nif]";
    public static final String US_ONAPARELL = "Ús: onAparell [nif] [descripció]";
    public static final String US_OFFAPARELL = "Ús: offAparell [nif] [descripció]";
    public static final String US_INFO = "Ús: info [nif]";
    public static final String US_LIST = "Ús: list";


    /*CONSTANTES TEXTOS ERRORES DE VALORES EN PARAMETROS DE ENTRADA*/
    public static final String ERROR_SUP_CASA = "ERROR: Superficie incorrecta. Ha de ser més gran de 10.";
    public static final String ERROR_SUP_PLACA = "ERROR: Superficie incorrecta. Ha de ser més gran de 0.";
    public static final String ERROR_PREU = "ERROR: Preu incorrecte. Ha de ser més gran de 0.";
    public static final String ERROR_APARELL_POTENCIA = "ERROR: Potència incorrecta. Ha de ser més gran de 0.";
    public static final String ERROR_ESPACIO_PLACA = "ERROR: No hi ha espai disponible per a instal·lar aquesta placa.";

    /* CONSTANTES TEXTOS ERRORES YA EXISTE O NO EXISTE*/
    public static final String ERROR_NIFCASA_COINCIDENT = "ERROR: No hi ha cap casa registrada amb aquest nif.";
    public static final String ERROR_CASA_EXISTENT = "ERROR: Ja hi ha una casa registrada amb aquest nif.";
    public static final String ERROR_APARELL_COINCIDENT = "ERROR: No hi ha cap aparell registrat amb aquesta descripció a la casa indicada.";
    public static final String ERROR_APERELL_EXISTENT = "ERROR: Ja existeix un aparell amb aquesta descripció a la casa indicada.";
    public static final String ERROR_NO_CASAS = "ERROR: No hi cap casa registrada.";

    /* CONSTANTES TEXTOS ERRORES ON/OF */
    public static final String ERROR_APARELL_ON = "ERROR: L'aparell ja està encès.";
    public static final String ERROR_APARELL_OFF = "ERROR: L'aparell ja està apagat.";
    public static final String ERROR_CASA_ON = "ERROR: L'interruptor general ja está encés.";
    public static final String ERROR_CASA_OFF = "ERROR: L'interruptor general ja está apagat.";
    public static final String ERROR_A_CASA_OFF = "ERROR: No es pot encendre l'aparell. L'interruptor general està apagat.";


    public static final String ERROR_PLOMS = "Han saltat els ploms. La casa ha quedat completament apagada.";

    // MENSAJES DE SALIDA DE INFO
    public static final String MSG_ENCES = "Interruptor general encès.";
    public static final String MSG_APAGAT = "Interruptor general apagat.";
    public static final String MSG_NO_APARELLS_REGISTRATS = "No té cap aparell elèctric registrat.";
    public static final String MSG_NO_PLAQUES_REGISTRADES = "No té plaques solars instal·lades.";

}
