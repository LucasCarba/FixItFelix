package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import excepciones.ErrorAlAbrirArchivo;

public class controladorArchivo {

	String[][] datos;
	private File archivo;
	public controladorArchivo() {
		archivo=new File("puntaje.txt");
			
	}
	
	
	public String[][] cargarDatos() throws  ErrorAlAbrirArchivo{
		if(archivo==null)throw new ErrorAlAbrirArchivo("no se encontro la ruta correspondiente");
		
		datos = new String[5][2];
		int i = 0;
		
		
		String cadena;
		
		
		
		if(archivo.exists()) {
		try {//----------------el archivo lo debo traer desde la parte logica
			
			FileReader fr = new FileReader(archivo);
			
			BufferedReader br = new BufferedReader(fr);
			while ((cadena = br.readLine()) != null) {
				String[] parts = cadena.split(" ");
				datos[i][0] = parts[0];
				datos[i][1] = parts[1];
				i++;

			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}}

		return datos;
	}
	
	
	public void modificarPuntajes(int puntos,String nombreJug) {
		boolean encontre = false;
		int i = 0;
		while (!encontre && i < 5 && datos[i][1]!=null) {

			if (Integer.parseInt(datos[i][1]) < puntos) {

				encontre = true;
				correr(i, datos);
				
				
				
				datos[i][0] = nombreJug;
				datos[i][1] = obtenerString(puntos);
			}
			i++;
		}
		
		if(i<5 && datos[i][1]==null) {
			datos[i][0] = nombreJug;
			datos[i][1] = obtenerString(puntos);
		}

		try {
			escribirArchivo(datos);
		} catch (ErrorAlAbrirArchivo e) {
			e.printStackTrace();
		}
	}
	
	
	

	private void escribirArchivo(String[][] datos) throws  ErrorAlAbrirArchivo{
		if(archivo==null)throw new ErrorAlAbrirArchivo("no se encontro la ruta correspondiente");
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(archivo);
			pw = new PrintWriter(fichero);

			int i = 0;
			while(i < 5 && datos[i][0]!=null) {
				pw.println(datos[i][0] + " " + datos[i][1]);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	private void correr(int i, String[][] datos) {
		int j = 4;
		while (j > i) {
			datos[j][0] = datos[j - 1][0];
			datos[j][1] = datos[j - 1][1];
			j--;
		}

	}

	private String obtenerString(int puntos) {
		return "" + puntos;
	}
}
