package modelo;

public class Semiroto extends State{

	public Semiroto(Panel miPanel) {
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
		miPanel.setEstado(new Sano(miPanel));
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
	public boolean romper() {
		miPanel.setEstado(new Roto(miPanel));
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
	public boolean estaRoto() {
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
	public  boolean isSano () {
		return false;
	} 
}
