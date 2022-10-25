package vistaGame;

import java.awt.*;
import javax.swing.*;
import controlador.Control;

public class GPato {

	protected JLabel mGrafico;
	protected int mWidth;
	protected int mHeight;

	// felix en reposo en 0-------felix moviendose en 1-----felix martillando en
	// 2------felix muere en 3
	protected Icon imagenes[];
	protected Point posicion;
	protected Control control;
	protected mJuego juego;
	private int mov;
	private String moverDirec;

	public GPato(Control control, Point p, mJuego juego) {
		moverDirec = "IZQUIERDA";
		mov = 1;
		this.juego = juego;
		this.control = control;
		mWidth = 34;
		mHeight = 23;
		posicion = new Point();
		posicion.x = 20 + (p.x * 54);
		posicion.y = 14 + (p.y * 90);

		imagenes = new Icon[4];

		// IZQUIERDA
		imagenes[0] = new ImageIcon((this.getClass().getResource("/img/patoI1.png")));
		imagenes[1] = new ImageIcon((this.getClass().getResource("/img/patoI2.png")));
		// DERECHA
		imagenes[2] = new ImageIcon((this.getClass().getResource("/img/patoD1.png")));
		imagenes[3] = new ImageIcon((this.getClass().getResource("/img/patoD2.png")));

		mGrafico = new JLabel(imagenes[0]);
		mGrafico.setBounds(posicion.x, posicion.y, mWidth, mHeight);

	}

	/////////////////////////////////////////////////

	public void mover() {
		int direccion = 3;

		if (moverDirec.equals("IZQUIERDA")) {
			if (posicion.x < -108) {
				direccion = 2;
				moverDirec = "DERECHA";
			} else
				direccion = 0;
		} else if (moverDirec.equals("DERECHA")) {
			if (posicion.x > 378) {
				direccion = 0;
				moverDirec = "IZQUIERDA";
			} else
				direccion = 2;
		}
		moverPos();
		mGrafico.setIcon(imagenes[mov + direccion]);
		if (mov == 1)
			mov--;
		else
			mov++;

		mWidth = 34;
		mHeight = 23;
		mGrafico.setBounds(posicion.x, posicion.y, mWidth, mHeight);

	}

	private void moverPos() {
		if (moverDirec.equals("IZQUIERDA"))
			posicion.setLocation(posicion.getX() - 54, posicion.getY());
		else
			posicion.setLocation(posicion.getX() + 54, posicion.getY());
	}


	// retorna la etiqueta con la imagen actual de nuestro personaje
	public JLabel getGrafico() {
		return this.mGrafico;
	}

	public Point getPosicion() {
		return posicion;
	}
	
	public void borrar() {
		ImageIcon iconNada = new ImageIcon((this.getClass().getResource("/img/nada.png")));

		mGrafico.setIcon(iconNada);
		mGrafico.setBounds(posicion.x, posicion.y, mWidth, mHeight);
	}

}