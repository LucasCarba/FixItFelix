package modelo;
import java.util.Random;


public class Puerta extends Ventana{

	//------------------------------------------------------------CONSTRUCTOR----------------------------------------------------------------	

	public Puerta( ) {
				
		super ();
		

		hojaIzquierda=false;
		hojaDerecha=false;
		cerrada=false;
		paneles=new Panel[4];
			for (int i=0; i<4; i++) {
				paneles[i]=new Panel();
			}
	}
	
	
	//---------------------------------------------------------------METODOS----------------------------------------------------------------

	
	/**
	 * 
	 * 
	 * @param 
	 * 				
	 * @return  
	 *           
	 */    
	public int arreglarse () {
		boolean arreglo=false;
		
		int i=3;
			while(!arreglo && i!=-1) {
				arreglo=paneles[i].arreglarse();
				i--;
			}
			
			if(!arreglo)return 0;
			return 100;
		}



	
	/**
	 * 
	 * 
	 * @param 
	 * 				
	 * @return  
	 *           
	 */    
	public boolean romper() {
		Random rnd = new Random();
		int selec;
		boolean roto=false;
		if(!todosRotos()) {
		while(!roto) {
			selec = rnd.nextInt(4);
			roto=paneles[selec].romper();	
		}
		return true;
		}
		return false;
		
	}
	
	
	/**
	 * Nos comunica si todos los panes de la ventana estan totalmente rotos
	 * 
	 * @return  true si todos los paneles estan rotos, false en caso contrario
	 *           
	 */
	private boolean todosRotos() {
		boolean estanRotos=true;
		int i=0;
		while(estanRotos && i<4) {
			estanRotos=paneles[i].estaRoto();
			i++;
		}
		return estanRotos;
	}





}
