package juegoProyecto;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Fichero {

	private static Fichero miFichero = null;
	private static String filename = "listajugadores.txt";

	//Constructora
	private Fichero(){}

	// Singleton
	public static Fichero getFichero(){
		if(miFichero == null){
			miFichero = new Fichero();
		}

		return miFichero;
	}

	//metodos
	public void cargarJugadoresDesdeFichero(){ //no hay try/catch en el ejemplo
		try{
			InputStream fich = Partida.class.getResourceAsStream(this.filename);

			Scanner sc;
			sc = new Scanner(fich);
			while (sc.hasNextLine()){
				String linea = sc.nextLine();
				String[] texto = linea.split(" ");
				String username = texto[0];
				String contraseina = texto[1];
				String spGanadas = texto[2];
				int pGanadas = Integer.parseInt(spGanadas);
				String spJugadas = texto[3];
				int pJugadas = Integer.parseInt(spJugadas);
				String spCartas = texto[4];
				int cartasMetidas = Integer.parseInt(spCartas);
				String spPuntos = texto[5];
				int puntos = Integer.parseInt(spPuntos);
				if(!contraseina.equals("null")){
					Humano j = new Humano(username, pGanadas, pJugadas, cartasMetidas, puntos, contraseina);
					ListaJugadores.getListaJugadores().anadirJug(j);
				}else{
					IaUsuario j = new IaUsuario(username, pGanadas, pJugadas, cartasMetidas, puntos);
					ListaJugadores.getListaJugadores().anadirJug(j);
				}
				//System.out.println(linea); //para escribirlos por pantalla
		}
		sc.close();	
		} catch (Exception e){
			System.out.println("Error de lectura en el fichero");
		}
	}
	
	
	public void guardarPartida(){
		File arc = new File("src/"+ this.filename);
		try {
			// Eliminamos el archivo para que luego sobreesciba la partida
			if(arc.exists()){
				arc.delete();
			}
			FileWriter archivo = new FileWriter(arc, true);
			Jugador j = null;
			ArrayList<Jugador> lista = ListaJugadores.getListaJugadores().convertirHashMap();
			for (int x=0;x<lista.size();x++){ // TODO
				j = lista.get(x);//ListaJugadores.getListaJugadores().getJugador(x);
				archivo.write(j.imprimirGuardadoJug());
				archivo.write("\n");
			}
			archivo.close();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error al escribir en el fichero");
		}
	}
	
}