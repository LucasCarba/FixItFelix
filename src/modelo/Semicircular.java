package modelo;
import java.util.Random;
public class Semicircular extends Ventana {
	
	
	//------------------------------------------------------------CONSTRUCTOR----------------------------------------------------------------	
	public Semicircular( ) {
		
			super ();

			hojaIzquierda=false;
			hojaDerecha=false;
			cerrada=false;
			paneles=new Panel[8];
				for (int i=0; i<8; i++) {
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
		int i=7;
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
			selec = rnd.nextInt(8);
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
		while(estanRotos && i<8) {
			estanRotos=paneles[i].estaRoto();
			i++;
		}
		return estanRotos;
	}

	
	

}
