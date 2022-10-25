package modelo;



public abstract class Ventana {
	
	//-------------------------------------------------------------ATRIBUTOS----------------------------------------------------------------	

	protected State estado;
	protected boolean moldura;
	protected boolean florero;
	protected boolean sano;
	protected boolean hojaIzquierda;
	protected boolean hojaDerecha;
	protected boolean cerrada;
	protected Panel paneles[];
	
	
	
	//------------------------------------------------------------CONSTRUCTOR----------------------------------------------------------------	

	public Ventana() {
		
		moldura = false;
		florero = false;

	}
	
	
	//---------------------------------------------------------------METODOS----------------------------------------------------------------

	
	
	/**
	 * Toma un panel al azar de la ventana y lo rompe
	 * de no poder romper ningun panel por que estan todos rotos dara un false
	 * 
	 * @return true si rompio un panel, false en caso contrario
	 * 
	 */
	public abstract boolean romper ();
	
	/**
	 * Arregla un panel dependiendo del estado de la ventana, y se reparan de los paneles inferiores a los superiores
	 * 
	 *           
	 */
	public abstract int arreglarse ();

	
	/**
	 * coloca una moldura a la ventana
	 *           
	 */
	public void ponerMoldura() {moldura=true;}
	
	/**
	 * coloca un florero a la ventana
	 *           
	 */
	public void ponerFlorero() {florero=true;}

	/**
	 * 
	 * coloca una hoja derecha a la ventana
	 *           
	 */    
	public void ponerHojaDerecha() {hojaDerecha=true;}
	
	
	/**
	 * 
	 * Pone una hoja izquierda a la ventana
	 *           
	 */    
	public void ponerHojaIzquierda() {hojaIzquierda=true;}
	
	
	public void estaSano() {sano=true;}
	public boolean getSano() {return sano;}

//-----------------------------------------------------------------
	public Panel[] getPaneles() {
		return paneles;
	}


	public boolean isMoldura() {
		return moldura;
	}


	public boolean isFlorero() {
		return florero;
	}


	public boolean isHojaIzquierda() {
		return hojaIzquierda;
	}


	public boolean isHojaDerecha() {
		return hojaDerecha;
	}


	public boolean isCerrada() {
		return cerrada;
	}
	
	
	

}
