package modelo;

public class Roto extends State{


	public Roto(Panel miPanel) {
		super(miPanel);
	}
	
	/**
	 * 
	 * 
	 * @param 
	 * 				
	 * @return  
	 *           
	 */    
	public boolean arreglarse () {
		miPanel.setEstado(new Semiroto(miPanel));
		return true;
	}
	
	
	/**
	 * 
	 * 
	 * @param 
	 * 				
	 * @return  
	 *           
	 */    
	public boolean romper () {
		return false;
	}
	
	
	/**
	 * 
	 * 
	 * @param 
	 * 				
	 * @return  
	 *           
	 */    
	public boolean estaRoto() {
		return true;
	}
	/**
	 * 
	 * 
	 * @param 
	 * 				
	 * @return  
	 *           
	 */    
	public  boolean isSano() {
		return false;
	} ;

}
