package modelo;
import java.util.Random;
public class Seccion {
	
	//-------------------------------------------------------------ATRIBUTOS----------------------------------------------------------------	

	private int cantVentanasRotas;
	private int sanas;
	private Ventana ventanas[][];

	private int nivelAzar=16;
	
	//------------------------------------------------------------CONSTRUCTOR----------------------------------------------------------------	

	public Seccion(int cantVentanasRotas) {
		sanas=0;
		ventanas = new Ventana[5][4];
		this.cantVentanasRotas=cantVentanasRotas;
		
		}
	
	//---------------------------------------------------------------METODOS----------------------------------------------------------------

	
	/**
	 * 
	 * Inicializa una seccion totalmente conformada por ventanas de tipo comun
	 *           
	 */    
	public void inicializarPiso () {
		
		for(int x=4;x>-1;x--) {
			for(int y = 3; y > 0; y--) {
				ventanas[x][y]=azarComun();
			}
		}
		for(int p=0;p<5;p++)
			ventanas[p][0]=new Comun();
		
		romper();
		
	}
	
	
	/**
	 * 
	 * Inicializa una seccion con una puerta y una ventana semicircular en su correspondiente posicion y el resto se inicializa
	 * con ventanas de tipo comun
	 *           
	 */    
	public void inicializarPlantaBaja () {
		
		for(int x=4;x>-1;x--) {
			for(int y=3;y>0;y--) {
				if(x==2 && y==3)ventanas[x][y]=new Puerta();
				else if(x==2 && y==2)ventanas[x][y]=new Semicircular();
				else ventanas[x][y]=azarComun();
				
			}
		}
		for(int p=0;p<5;p++)
			ventanas[p][0]=new Comun();
		
		romper();
		
	}
		
	
	/**
	 * 
	 * rompen ventanas al azar, si ya estan rotas se elige otra
	 * la cantidad de ventanas que se rompen depende del nivel 
	 * al inicio se rompen una cantidad ya establecida de ventanas
	 *           
	 */    
	private void romper() {
		
		int rotas=0;
		Random rnd = new Random();
		int fila,columna ;
		boolean rompio;
		
		
		//No se deben romper las ventanas donde se mueve ralph, es decir la fila 4
		while(rotas!=cantVentanasRotas) {
			columna= 4-rnd.nextInt(4);
			fila= 3-rnd.nextInt(3);
			rompio=ventanas[columna][fila].romper();
			if(rompio)rotas++;
		}
	}
	
	
	/**
	 * 
	 * 
	 * @param x fila de la seccion a arreglar
	 * 		  y columna de la seccion a arreglar
	 * 				
	 * @return  el puntaje que se gana al arreglar
	 *           
	 */    
	public int arreglar(int x,int y) {
		int aux=ventanas[x][y].arreglarse();
		if(aux!=0) {
			sanas++;
			if(sanas==cantVentanasRotas)return 500;
			else return aux;
		}
		return 0;
	}
	
	
	/**
	 * 
	 * crea una ventana con propiedades  al azar
	 *           
	 */    
	private Ventana azarComun() {

		Comun ventana=new Comun();
		Random rnd = new Random();
		int dir= rnd.nextInt(nivelAzar);
		switch (dir) {
        case 1:ventana.ponerMoldura();  break;
        case 2:ventana.ponerFlorero();  break;
        case 3:ventana.ponerCerrada(); break;
        case 4:ventana.ponerHojaDerecha();  break;
        case 5:ventana.ponerHojaIzquierda();  break;
		}
		return ventana;
		
	}
	
	
	/**
	 * 
	 * 
	 * @param  x fila de la seccion que se quiere acceder
	 * 		   y columna de la seccion que se quiere acceder
	 * 		   direccion la direccion a la que se quiere acceder
	 * 				
	 * @return  true si la ventana el la seccion correspondiente se puede acceder, false en caso contrario
	 *           
	 */    
	public  boolean accesible (int x,int y,String direccion) {

	
		if(direccion.equals("ARRIBA")){
			return (y>1 && !ventanas[x][y-1].isFlorero() && (!ventanas[x][y].isMoldura()) &&  (!ventanas[x][y-1].isCerrada()));
		}
		if(direccion.equals("ABAJO")){
			return (y<3 && !ventanas[x][y].isFlorero() && (!ventanas[x][y+1].isMoldura()) &&  (!ventanas[x][y+1].isCerrada()));		
				}
		if(direccion.equals("IZQUIERDA")){
			return (x>0 && !ventanas[x][y].isHojaIzquierda() && (!ventanas[x-1][y].isHojaDerecha()) &&  (!ventanas[x-1][y].isCerrada()));
		}
		if(direccion.equals("DERECHA")){
			return (x<4 && !ventanas[x+1][y].isHojaIzquierda() && (!ventanas[x][y].isHojaDerecha()) &&  (!ventanas[x+1][y].isCerrada()));
		}
					
			
		return false;
	}
	
	
	
	/**
	 * 
	 * Nos comunica si en la seccion estan todos los paneles totalmente sanos 
	 * 				
	 * @return  true si todos los paneles de la seccion estaen sanos
	 * 			false en caso contrario
	 *           
	 */    
	public boolean seccionReparada() {
		boolean sana=true;
		int x=0;
		int y =0;
		while(sana & x<5) {
			while(sana & y<4) {
				sana=ventanas[x][y].getSano();
				y++;
			}
			x++;
		}
		return sana;
	}
	
	
	
	/**
	 * 
	 * sube el nivel de la seccion
	 *           
	 */    
	public void subirNivel(){
		//baja el nivel de azar, es decir sube la probabilidad de que se cree obstaculo
		nivelAzar-=nivelAzar*0.1;
		
		//aumenta la cantidad de ventanas rotas
		cantVentanasRotas+=cantVentanasRotas*0.1;
	}

	public Ventana[][] getSeccion() {
		return ventanas;
	}
	
	
	}
