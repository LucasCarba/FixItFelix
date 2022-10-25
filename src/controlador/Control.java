package controlador;




import java.util.LinkedList;

import javax.swing.JTable;
import excepciones.*;
import modelo.*;
import vista.Menu;

public class Control {

	
	private Menu menu;
	private Juego logica;
	private controladorArchivo ctrlArch;
	
	public Control(Menu menu, Juego manager) {
		ctrlArch=new controladorArchivo();
		
		this.logica=manager;
		
	}
	
 public void setTurno () {
	 logica.actualizarTurno();
	 menu.getEdificio().actualizarPosiciones();
 }
	

	//-----------------------------------------------metodos de puntuacion del juego
	
	public boolean chequeoPuntos(int puntos){
		return logica.chequeoPuntos(puntos);
	}
	
	public void setNombreJugador(String nombreJug){
		logica.setNombreJugador(nombreJug);
	}


	public void puntajes(int puntos) {
		logica.getFelix().setPuntos(puntos);
		logica.puntajes(puntos);
		
	}
	
	
	public boolean checkNombre(String njUG){
		if(njUG.length()>2){
			
			if(njUG.length()>20) {
				njUG=njUG.substring(0,20);
			}
				
				for(int i=0;i<njUG.length();i++) {
					if(njUG.charAt(i)==' ') {
						return false;
					}
				}
			return true;
		}
		
		return false;
	}	

	
	public int  arreglar() {
		return logica.arreglar();
		
	}	
	
	public void matarFelix() {
		logica.matarFelix();
		
		
	}
		
	

	
	public void ralphGolpea() {
		logica.golpea();
	}
	//-------------------------------------------metodos para mover personajes/objetos en juego
	
	
	public boolean moverFelix(int dir) {
		return logica.moverFelix(dir);
	}
	
	public boolean moverRalph() {
		return logica.moverRalph();
	}
	
	
	public boolean moverLadrillos() {
		return logica.moverLadrillos();
			
		
	}
	
	public boolean moverPatos() {
		return logica.moverPatos();
	}
	//----------------------------------------Metodos para manejo de juego
	public void subirSeccion() {
		logica.subirSeccion();
	}
	public void abrirJuego() {
		menu.setVisibleJuego();
	}
	
	public void reiniciarJuego() {
		logica.reiniciar();
	}
	
	public void setVisibleMenu() {
		logica.reiniciar();
		menu.setVisible();
	}
	
	public void cargarDatos(JTable table) throws VectorFueraDeRangoException, ErrorAlAbrirArchivo  {
		
		String[][] datos = ctrlArch.cargarDatos();

		table.setValueAt(datos[0][0], 1, 1);
		table.setValueAt(datos[0][1], 1, 2);
		table.setValueAt(datos[1][0], 2, 1);
		table.setValueAt(datos[1][1], 2, 2);
		table.setValueAt(datos[2][0], 3, 1);
		table.setValueAt(datos[2][1], 3, 2);
		table.setValueAt(datos[3][0], 4, 1);
		table.setValueAt(datos[3][1], 4, 2);
		table.setValueAt(datos[4][0], 5, 1);
		table.setValueAt(datos[4][1], 5, 2);
	}
	
	
	
	public void selecionarNivel(int nivel) {
		logica.subirNivelEleccion(nivel);
		
	}
	

	
	//------------------------------------------------------------Getters-------
	
	public Seccion[] getSecciones() {
		return logica.getEdificio().getSecciones();
	}
	
	public Felix getFelix() {
		return logica.getFelix();
	}
	
	public Ralph getRalph() {
		return logica.getRalph();
	}
	
	public LinkedList<Patos> getPatos(){
		return logica.getPatos();
	}
	
	
	//-----------------------------------------------------------------SETTERS
	
	public void setMenu(Menu menu) {
		this.menu=menu;	
		menu.initialize();
	}
	
}
	
	
	
	
