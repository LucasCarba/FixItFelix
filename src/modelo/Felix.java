package modelo;
import java.awt.Point;



public class Felix {
	
//-------------------------------------------------------------ATRIBUTOS----------------------------------------------------------------	
	
	private int puntos;
	private Point posicion;
	private int cantVidas;
	private Juego manager;
	private boolean inmune;

//------------------------------------------------------------CONSTRUCTOR----------------------------------------------------------------	
	
	public Felix(Point posicion,Juego manager ) {
		this.manager=manager;
		puntos=0;
		this.posicion= posicion;
		cantVidas=1;
		inmune=false;
	}
		
//---------------------------------------------------------------METODOS----------------------------------------------------------------
	
	/**
	 * Mueve a izquierda si es 1, a derecha si es 2, abajo si es 3, arriba  si es 4.
	 * 
	 * @param direccion
	 * 				 indica que direccion debe moverse
	 *           
	 */

	public void  mover (String direccion )
	{
	switch (direccion) {
        case "IZQUIERDA": posicion.setLocation(posicion.getX()-1,posicion.getY()); break;
        case "DERECHA": posicion.setLocation(posicion.getX()+1,posicion.getY()); break;
        case "ARRIBA": posicion.setLocation(posicion.getX(),posicion.getY()-1); break;
        case "ABAJO": posicion.setLocation(posicion.getX(),posicion.getY()+1); break;
		}
	
	//PARA PRIMER ENTREGA
						/*switch (direccion) {
					    case 1: System.out.println("Felix Jr. se desplaza a la IZQUIERDA ");  break;
					    case 2: System.out.println("Felix Jr. se desplaza a la DERECHA "); break;
					    case 3: System.out.println("Felix Jr. se desplaza a la ABAJO "); break;
					    case 4: System.out.println("Felix Jr. se desplaza a la ARRIBA "); break;
						}*/
					
	}
	
	
	/**
	 * Manda al Manager del juego que arregle la ventana que se encuentra en  la posicion actual.
	 *           
	 */
	public void arreglar () {
		manager.arreglar();
		//PARA PRIMER ENTREGA
		//System.out.println("Felix Jr. da un martillazo ");
		
		}
	
	/**
	 * Activa su inmunidad.
	 *           
	 */
	
	public void activarInmunidad() {
		inmune=true;
	}
	
	/**
	 * Desactiva su inmunidad.
	 *           
	 */
	public void desactivarInmunidad() {		inmune=false;	}
	
	/**
	 * Suma a la cantidad de puntos actual, la cantidad de puntos que se pasa por parametro
	 *   
	 * @param puntos 
	 * 			son los puntos que gano felix al arreglar     
	 */
	public void sumarPuntos (int puntos) {	this.puntos+= puntos;	}
	
	
	/**
	 * Cuando se termina de reparar por completo una seccion, felix cambia su posicion a la posicion  pasada por parametro.
	 *  
	 * @param posicion
	 * 			es la posicion a la que se debe reubicar felix          
	 */

	public void cambiarPosicion( int x,int y) {	
		this.posicion.x=x;
		this.posicion.y=y;
		
		}
	
	/**
	 * Felix decrementa una vida
	 *          
	 */

	public void morir() {
		//PARA PRIMER ENTREGA
		//System.out.println("Felix Jr. pierde una vida ");
		cantVidas--;
		if(cantVidas<=0) {
			//PARA PRIMER ENTREGA
			//System.out.println("Felix Jr. perdio todas sus vidas");
			//manager.puntajes(puntos);
			
		}
	}
	
	
	
	
	
//----------------------------------------------------GETTER/SETTERS----------------------------------------------------------------
	public Point getPosicion () {
		
		return posicion;
	}
	
	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getCantVidas() {
		return cantVidas;
	}

	public void setCantVidas(int cantVidas) {
		this.cantVidas = cantVidas;
	}

	public boolean isInmune() {
		return inmune;
	}



}
