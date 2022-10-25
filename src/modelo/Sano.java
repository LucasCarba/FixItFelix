package modelo;
public class Sano extends State{

	public Sano(Panel miPanel) {
		super(miPanel);
		miPanel.setSano(true);
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
		return false;}
	
	
	
	/**
	 * 
	 * 
	 * @param 
	 * 				
	 * @return  
	 *           
	 */    
	public boolean romper() {
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
		return true;
	};
}
