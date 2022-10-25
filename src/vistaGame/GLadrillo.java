package vistaGame;

import java.awt.*;

import javax.swing.*;

import controlador.Control;

public class GLadrillo {

	protected JLabel mGrafico;
	protected int mWidth;
	protected int mHeight;

	protected Icon imagenes[];
	protected Point posicion;
	protected Control control;
	protected mJuego juego;
	private int mov;

	public GLadrillo(Control control, Point p, mJuego juego) {
		mov = 1;
		this.juego = juego;
		this.control = control;
		mWidth = 20;
		mHeight = 13;
		posicion = new Point();
		posicion.x = 20 + p.x;
		posicion.y = p.y;

		imagenes = new Icon[2];

		// IZQUIERDA
		imagenes[0] = new ImageIcon((this.getClass().getResource("/img/ladrillo1.png")));

		// DERECHA
		imagenes[1] = new ImageIcon((this.getClass().getResource("/img/ladrillo2.png")));

		mGrafico = new JLabel(imagenes[0]);
		mGrafico.setBounds(posicion.x, posicion.y, mWidth, mHeight);

	}

	/////////////////////////////////////////////////

	public void mover() {
		moverPos();
		mGrafico.setIcon(imagenes[mov]);
		if (mov == 1)
			mov--;
		else
			mov++;

		mWidth = 20;
		mHeight = 13;
		mGrafico.setBounds(posicion.x, posicion.y, mWidth, mHeight);

	}

	private void moverPos() {

		posicion.setLocation(posicion.getX(), posicion.getY() + 90);
	}

	// retorna la etiqueta con la imagen actual de nuestro personaje
	public JLabel getGrafico() {
		return this.mGrafico;
	}

	public Point getPosicion() {
		return posicion;
	}


}