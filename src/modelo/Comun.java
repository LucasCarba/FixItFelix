package modelo;
import java.util.Random;
public class Comun extends Ventana{
	
	//-------------------------------------------------------------ATRIBUTOS----------------------------------------------------------------	

	private boolean hojaIzquierda;
	private boolean hojaDerecha;
	private boolean cerrada;
	private	boolean pastel;

	
	//------------------------------------------------------------CONSTRUCTOR----------------------------------------------------------------	

	public Comun( ) {
		super ();
		paneles=new Panel[2];
			for (int i=0; i<2; i++) {
				paneles[i]=new Panel();
			}
	}
	
	
	//---------------------------------------------------------------METODOS----------------------------------------------------------------

	//public void asomar () {}

	/**
	 * arregla los paneles si estan rotos, primero lo paneles inferiores y luego los superiores
	 * En la lista de paneles se ubican primero los sumeriores y luego los inferiores
	 * 				
	 * @return  0 si no arreglo el panel, 
	 * 			100 en caso contrario
	 *           
	 */    
	public int arreglarse () {
		boolean arreglo=false;
		
		int i=1;
		
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
	 * @return  true si pudo romperse un panel
	 * 			false en caso contrario
	 *           
	 */    
	public boolean romper() {
		if(cerrada)return false;
		Random rnd = new Random();
		int selec;
		boolean roto=false;
		if(!todosRotos()) {
		while(!roto) {
			selec = rnd.nextInt(2);
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
		while(estanRotos && i<2) {
			estanRotos=paneles[i].estaRoto();
			i++;
		}
		return estanRotos;
	}
	
	

	

	/**
	 * 
	 * cierra la ventana para poder accederse a ella
	 *           
	 */    
	public void ponerCerrada() {cerrada=true;}
	
	/**
	 * 
	 * 
	 *           
	 */    
	public void dejarPastel() {
		 pastel = true;
	}
	
	
	/**
	 * 
	 * 
	 *           
	 */    
	public boolean hayPastel () {
	
		return pastel;
	}
	
	/**
	 * 
	 * 
	 *           
	 */    
	public void comioPastel ()
	{
		pastel= false;
	}


}
