package modelo;

public abstract class State {
	protected Panel miPanel;
	public State(Panel miPanel) {
		this.miPanel=miPanel;
	}
	
	/**
	 * 
	 * 
	 * @param 
	 * 				
	 * @return  
	 *           
	 */    
	public abstract boolean arreglarse () ;
	
	/**
	 * 
	 * 
	 * @param 
	 * 				
	 * @return  
	 *           
	 */    
	public abstract boolean romper();
	
	
	/**
	 * 
	 * 
	 * @param 
	 * 				
	 * @return  
	 *           
	 */    
	public abstract boolean estaRoto();
	/**
	 * 
	 * 
	 * @param 
	 * 				
	 * @return  
	 *           
	 */    
	public abstract boolean isSano () ;
}
