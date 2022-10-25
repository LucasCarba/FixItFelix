package vistaGame;

import java.awt.*;
import javax.swing.*;
import controlador.Control;
import modelo.Ralph;

public class GRalph {

	protected JLabel mGrafico;
	protected int mWidth;
	protected int mHeight;

	// felix en reposo en 0-------felix moviendose en 1-----felix martillando en
	// 2------felix muere en 3
	protected Icon imagenes[];
	protected Control control;
	protected mJuego juego;
	private int mov;
	protected Ralph ralph;
	// -----------------------------------------------------------------------

	public GRalph(Control control, Ralph ralph, mJuego juego) {

		mov = 1;
		this.juego = juego;
		this.control = control;
		mWidth = 70;
		mHeight = 84;
		this.ralph = ralph;

		imagenes = new Icon[7];
		// REPOSO
		imagenes[0] = new ImageIcon((this.getClass().getResource("/img/RalphReposo.png")));
		// IZQUIERDA
		imagenes[1] = new ImageIcon((this.getClass().getResource("/img/Izquierda1.png")));
		imagenes[2] = new ImageIcon((this.getClass().getResource("/img/Izquierda2.png")));
		// DERECHA
		imagenes[3] = new ImageIcon((this.getClass().getResource("/img/derecha1.png")));
		imagenes[4] = new ImageIcon((this.getClass().getResource("/img/derecha2.png")));

		// GOLPEAR

		imagenes[5] = new ImageIcon((this.getClass().getResource("/img/golpea1.png")));
		imagenes[6] = new ImageIcon((this.getClass().getResource("/img/golpea2.png")));

		mGrafico = new JLabel(imagenes[0]);
		mGrafico.setBounds((ralph.getPosicion().x * 54) + 20, (ralph.getPosicion().y *90) + 14, mWidth, mHeight);

	}

	/////////////////////////////////////////////////
	public void reposo() {
		mWidth = 70;
		mHeight = 84;
		mGrafico.setIcon(imagenes[0]);
		mGrafico.setBounds((ralph.getPosicion().x * 54) + 20, (ralph.getPosicion().y *90) + 14, mWidth, mHeight);
	}

	/////////////////////////////////////////////////

	public void mover() {

		mGrafico.setIcon(imagenes[1 + mov]);
		if (mov == 1)
			mov--;
		else
			mov++;
			mWidth = 66;
			mHeight = 85;
			mGrafico.setBounds((ralph.getPosicion().x * 54) + 20, (ralph.getPosicion().y *90) + 14, mWidth, mHeight);
		
	}

	

	// retorna la etiqueta con la imagen actual de nuestro personaje
	public JLabel getGrafico() {
		return this.mGrafico;
	}

	public GLadrillo golpear() {
		mGrafico.setIcon(imagenes[5 + mov]);
		if (mov == 1)
			mov--;
		else
			mov++;
		mWidth = 100;
		mHeight = 89;
		mGrafico.setBounds((ralph.getPosicion().x * 54) + 20, (ralph.getPosicion().y *90) + 14, mWidth, mHeight);
		control.ralphGolpea();
		return new GLadrillo(control, new Point((ralph.getPosicion().x * 54) + 20, (ralph.getPosicion().y *90) + 14), juego);
	}
	

}
