package principal;

import java.awt.EventQueue;

import controlador.Control;
import excepciones.ErrorAlAbrirArchivo;
import modelo.Juego;
import vista.Menu;

public class Principal {

	private static Menu menu;
	private static Control control;
	private static Juego logica;

	
	public static void main(String[] args) throws ErrorAlAbrirArchivo {
		
		
		logica=new Juego();
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					control=new Control(menu,logica);	
					Menu menu = new Menu(control);
					control.setMenu(menu);
					menu.getFramePrincipal().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		

	}

}
