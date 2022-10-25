package modelo;
import java.awt.Point;


public class Ladrillo {


	//-------------------------------------------------------------ATRIBUTOS----------------------------------------------------------------//	
	
	private Point posicion;
	private int velocidad;
	
	//------------------------------------------------------------CONSTRUCTOR----------------------------------------------------------------//	
	
	public Ladrillo(int Velocidad) {
		setVelocidad(Velocidad);
		}
	
	//---------------------------------------------------------------METODOS----------------------------------------------------------------//

	
	/**
	 * Decremento la posicion en 1.
	 *           
	 */

	public void caer () {
		posicion.setLocation(posicion.getX(),posicion.getY()+1); 		}
	
	/**
	 * Incremento la velocidad (no aplicamos el 10 % porque si llega al nivel 10 se rompe)
	 *           
	 */

	 public void subirVelocidad() {
		 setVelocidad(getVelocidad() + 1);
	 }
	 
	 
	 
	//----------------------------------------------------GETTER/SETTERS----------------------------------------------------------------//
	 
	public void setPosicion(Point posicion) {
		this.posicion = posicion;
	}
	
	
		 public Point getPosicion() {
				return posicion;
			}

		public int getVelocidad() {
			return velocidad;
		}

		public void setVelocidad(int velocidad) {
			this.velocidad = velocidad;
		}
	}
