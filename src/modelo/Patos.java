package modelo;
import java.awt.Point;
public class Patos {
	
	//-------------------------------------------------------------ATRIBUTOS----------------------------------------------------------------//	

	private Point posicion;
	private int velocidad;
	private String moverDirec;
	//------------------------------------------------------------CONSTRUCTOR----------------------------------------------------------------//	
	
	public Patos(int Velocidad) {
		setVelocidad(Velocidad);
		moverDirec="IZQUIERDA";
		
	}
	
	//---------------------------------------------------------------METODOS----------------------------------------------------------------//
	
	
	/**
	 * Dependiendo de la direccion se movera a izquierda(1) o derecha(2)
	 *
	 * @param  direccion
	 * 		        indica direccion a mover 
	 */
	public void mover ()
	{	//2 es derecha
		//1 es izquierda
		int direccion=0;
		
		
		if(moverDirec.equals("IZQUIERDA")) {
			if(posicion.x<-2 ) {
				direccion=2;
				moverDirec="DERECHA";}
			else direccion=1;
		}else
			if(moverDirec.equals("DERECHA")) {
				if(posicion.x>7 ) {
					direccion=1;
					moverDirec="IZQUIERDA";}
				else direccion=2;
			}
		
		switch (direccion) {
        case 1: posicion.setLocation(posicion.getX()-1,posicion.getY()); break;
        case 2: posicion.setLocation(posicion.getX()+1,posicion.getY()); break;
        
		}
	}
	
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
