package excepciones;

import java.io.IOException;

import javax.swing.JOptionPane;


public class VectorFueraDeRangoException extends IOException {
		public VectorFueraDeRangoException(){
			super();
			JOptionPane.showMessageDialog(null, "vector fuera de rango");
		}
		
	
}
