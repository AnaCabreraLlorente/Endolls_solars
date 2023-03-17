package endolls_solars;
		import java.util.ArrayList;
		import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws InstantiationError {
		boolean salir = false; // creamos variable boolean y iniciamos en false
		ArrayList<Casa> casas = new ArrayList<>(); // creamos un array de casas
		Scanner sc = new Scanner(System.in);
		do {
			try{
				System.out.print(">");
				String comanda = sc.nextLine();
				String[] dades = comanda.split(" ");
				if (dades.length > 0) {
					switch (dades[0].toLowerCase()) {
						case "quit": salir = true; break;
						case "addcasa": Metodos.addCasa(dades, casas); break;
						case "addplaca": Metodos.addPlaca(dades, casas); break;
						case "addaparell": Metodos.addAparell(dades, casas); break;
						case "oncasa": Metodos.onCasa(casas, dades);break;
						case "offcasa": Metodos.offCasa(casas, dades); break;
						case "onaparell": Metodos.onAparell(dades, casas); break;
						case "offaparell": Metodos.offAparell(dades, casas); break;
						case "list": Metodos.list(casas, dades); break;
						case "info": Metodos.info(casas, dades); break;
						default: System.out.println(Constantes.ERROR_COMANDA);}
				}
			}catch (InstantiationError ex){
				System.out.println(ex.getMessage());}
		}while (!salir) ;


	}
}




