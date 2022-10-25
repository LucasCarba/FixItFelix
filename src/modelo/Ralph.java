package modelo;
import java.util.LinkedList;
import java.awt.Point;
public class Ralph {
	

	//-------------------------------------------------------------ATRIBUTOS----------------------------------------------------------------//
	
	private Point posicion;
	private int nivel;
	//private int cantLadrillos;
	private LinkedList <Ladrillo> ladrillos;
	
	
	//------------------------------------------------------------CONSTRUCTOR----------------------------------------------------------------//	

	public Ralph(Point posicion) {
		//cantLadrillos=40;
		this.posicion = posicion;
		setNivel(1);
		ladrillos = new LinkedList <Ladrillo> ();
		reinicioLadrillos();

		
	}
	
	
	//---------------------------------------------------------------METODOS----------------------------------------------------------------//

	/**
	 * Dependiendo de la direccion, Ralph se movera a izquierda(1) o derecha(2)
	 *
	 * @param  direccion
	 * 		        indica direccion a mover 
	 */

	public void mover (String direccion )
	
	{	double x=posicion.getX();
		double y=posicion.getY();
		switch (direccion) {
        case "IZQUIERDA": posicion.setLocation((x-1),y); break;
        case "DERECHA": posicion.setLocation((x+1),y); break;
        }
	}
	
	/**
	 * Cuando cambia de seccion la posicion se re ubica a la posicion pasada por parametro.
	 *
	 * @param  posicion
	 * 		        indica la posicion a la que se reubica
	 */
		public void cambiarPosicion( int x,int y) {	
			this.posicion.x=x;
			this.posicion.y=y;	}
		
	/**
	 *  elimina un ladrillo de su lista y lo devulve
	 *
	 */	
	public Ladrillo golpear () {
		//PARA PRIMER ENTREGA
		//System.out.println("Ralph tira una roca");
		Ladrillo aux=ladrillos.remove();
		aux.setPosicion(new Point(posicion.x,posicion.y));
		return aux;
		
	}
	
	/**
	 *  sube el nivel de Ralph y aumenta la cantidad de ladrillos 
	 *
	 */	
	public void subirNivel() {
		nivel++;
		//cantLadrillos+=(cantLadrillos*(0.1));
		reinicioLadrillos();
		
	}
	
	
	/**
	 *  reinia la cantidad de ladrillos a 40 nuevamente
	 *
	 */	
	private void reinicioLadrillos() {
		for(int i = ladrillos.size();i<40;i++) {
			ladrillos.add(new Ladrillo(nivel));
		}
		
		for(int j = 0;j<40;j++) {
			ladrillos.element().subirVelocidad();
		}
	}
	
	
	
	//----------------------------------------------------GETTER/SETTERS----------------------------------------------------------------

	public Point getPosicion() {
		return posicion;
	}
	public void setPosicion(Point posicion) {
		this.posicion = posicion;
	}


	public int getNivel() {
		return nivel;
	}


	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

}
