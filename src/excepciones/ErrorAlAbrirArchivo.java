package excepciones;

import javax.swing.JOptionPane;

public class ErrorAlAbrirArchivo extends Exception{

	public ErrorAlAbrirArchivo(String msg) {
		super(msg);
		JOptionPane.showMessageDialog(null, "error al abrir archivo");
		
		
	}


}
