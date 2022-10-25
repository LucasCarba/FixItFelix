/**
 * 
 */
package modelo;

import java.awt.Point;


/**
 * @author Matias
 *
 */
public class Niceland {
	//-------------------------------------------------------------ATRIBUTOS----------------------------------------------------------------	

	private int seccionFelix;
	private Seccion secciones[];
	private Juego manager;
	private int cantVentanasRotasInical=16;

	
	//------------------------------------------------------------CONSTRUCTOR----------------------------------------------------------------//	

	public Niceland(Juego manager) {
		this.manager=manager;
		seccionFelix=0;
		secciones = new Seccion[3];
		secciones[0]=new Seccion(cantVentanasRotasInical);
		secciones[1]=new Seccion(cantVentanasRotasInical);
		secciones[2]=new Seccion(cantVentanasRotasInical);
		
		secciones[0].inicializarPlantaBaja();
		secciones[1].inicializarPiso();
		secciones[2].inicializarPiso();
		
		
	}
	
	//---------------------------------------------------------------METODOS----------------------------------------------------------------//

	/**
	 * 
	 * Le envia a una ventana la orden de arreglarse, y le da a felix puntos dependiendo si arreglo una seccion entera o solo una ventana
	 * 
	 * @param posicion es la posicion de la ventana que debe arreglarse
	 * 				
	 * @return  retorna la cantidad de puntos que se gana al arreglar
	 *           
	 */    
	public int  arreglar(Point posicion) {
		
		
		int puntos=secciones[seccionFelix].arreglar(posicion.x, posicion.y);
		
		
		if(secciones[seccionFelix].seccionReparada()) {
			if(seccionFelix==2) {
				manager.subirNivel();
				puntos=500;
			}
			else {
					seccionFelix++;
					manager.reposicionarPersonajes();
					puntos=500;
				}
		}
		return puntos;
	}
	
	
	/**
	 * nos comunica si se puede o no acceder a una ventana
	 * 
	 * @param posicionAcc es la posicion de la ventana  a la que se quiere acceder
	 * 		  posicionAct es la posicion desde la que se quiere acceder a la ventana
	 * 				
	 * @return  true si se puede acceder, false en caso contrario
	 *           
	 */    
	public boolean accesible(Point posicionAct,String direccion) {
			
			return secciones[seccionFelix].accesible(posicionAct.x, posicionAct.y,direccion) ;
		
	}
	
	
	/**
	 * 
	 * Sube el nivel de la seccion y tambien se lo inicializa nuevamente 
	 * 
	 *           
	 */    
	public void subirNivel() {
		secciones[0].subirNivel();
		secciones[1].subirNivel();
		secciones[2].subirNivel();
		
		
		secciones[0].inicializarPlantaBaja();
		secciones[1].inicializarPiso();
		secciones[2].inicializarPiso();
		
	}

	public Seccion[] getSecciones() {
		return secciones;
	}
	
	public void subirSeccion(){
		seccionFelix++;
	}
	
	

}
