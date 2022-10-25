package modelo;

public class Panel {
	//-------------------------------------------------------------ATRIBUTOS----------------------------------------------------------------	

 private State estado;
 
 
 
 
	//------------------------------------------------------------CONSTRUCTOR----------------------------------------------------------------//	

 public Panel() {
		this.estado = new Sano(this);
	}
 
	//---------------------------------------------------------------METODOS----------------------------------------------------------------//

	/**
	 * 
	 * 
	 * @param 
	 *           
	 */    
	public void setEstado(State estado) {
	this.estado = estado;
}

	
	/**
	 * 
	 * 				
	 * @return  true si puede arreglarse en panel, false en caso contrario
	 *           
	 */    
	public boolean arreglarse () {	
		return estado.arreglarse();
		}
	
	/**
	 * 
	 * rompe un panel
	 * 				
	 * @return  true si puede romperse el panel
	 * 			false en caso contrario
	 *           
	 */    
	public boolean romper() {return estado.romper();}	
	
	
	/**
	 * 	comunica si el panel esta totalmente roto	
	 * @return  true si el panel esta totalmente roto, false en caso contrario
	 *           
	 */    
	public boolean estaRoto() {return estado.estaRoto();}

	
	/**
	 * 
	 * 	comunica si el panel esta totalmente reparado
	 * @return  true si el panel esta sano
	 * 			false en caso contrario 
	 *           
	 */    
	public boolean isSano() {
		return estado.isSano();
	}

	
	/**
	 * 
	 *           
	 */    
	public void setSano(boolean sano) {
	}
	
	
}
