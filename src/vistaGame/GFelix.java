package vistaGame;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.*;

import controlador.Control;
import modelo.Felix;

public class GFelix {

	protected JLabel mGrafico;
	protected int mWidth;
	protected int mHeight;

	// felix en reposo en 0-------felix moviendose en 1-----felix martillando en
	// 2------felix muere en 3
	protected Icon imagenes[];
	protected Control control;
	protected mJuego juego;
	protected Felix felix;

	// ---------------------------------------
	private AudioClip sonidoMover;
	private AudioClip sonidoMartillar;

	public GFelix(Control control, Felix felix, mJuego juego) {
		sonidoMover = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/mover.wav"));

		sonidoMartillar = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/martillar.wav"));

		this.juego = juego;
		this.control = control;
		mWidth = 24;
		mHeight = 53;
		this.felix=felix;
		

		imagenes = new Icon[4];
		// REPOSO
		imagenes[0] = new ImageIcon((this.getClass().getResource("/img/reposo.png")));
		// MOVIMIENTO
		imagenes[1] = new ImageIcon((this.getClass().getResource("/img/mover.png")));
		// MARTILLAZO
		imagenes[2] = new ImageIcon((this.getClass().getResource("/img/martillar.png")));
		// MUERTE
		imagenes[3] = new ImageIcon((this.getClass().getResource("/img/muerto.png")));

		mGrafico = new JLabel(imagenes[0]);
		mGrafico.setBounds(20 + (felix.getPosicion().x * 54), 26 + (felix.getPosicion().y * 90) , mWidth, mHeight);

	}

	// -----------------------------------------METODOS DE ACCIONES DE
	// FELIX-------------------------------------
	public void reposo() {
		mWidth = 24;
		mHeight = 53;
		mGrafico.setIcon(imagenes[0]);
		mGrafico.setBounds(20 + (felix.getPosicion().x * 54), 26 + (felix.getPosicion().y * 90) , mWidth, mHeight);
	}
	
	
	public void mover(int dir) {
		int direc=-1;
		switch (dir) {
		case KeyEvent.VK_LEFT:
			direc = 1;
			break;
		case KeyEvent.VK_RIGHT:
			direc = 2;
			break;
		case KeyEvent.VK_DOWN:
			direc = 3;
			break;
		case KeyEvent.VK_UP:
			direc = 4;
			break;
		}
		control.moverFelix(direc);
		sonidoMover.play();
		mWidth = 39;
		mHeight = 54;
		mGrafico.setIcon(imagenes[1]);
		mGrafico.setBounds((20 + (felix.getPosicion().x * 54)),( 26 + (felix.getPosicion().y * 90)) , mWidth, mHeight);

	}



	public int martillar() {
		int ret = control.arreglar();
		mWidth = 54;
		mHeight = 51;
		mGrafico.setIcon(imagenes[2]);
		mGrafico.setBounds((felix.getPosicion().x*54)+20, (felix.getPosicion().y*90)+14, mWidth, mHeight);		
		sonidoMartillar.play();
		return ret;
	}

	public void morir() {
		mWidth = 41;
		mHeight = 25;
		mGrafico.setIcon(imagenes[3]);
		mGrafico.setBounds(20 + (felix.getPosicion().x * 54), 50 + (felix.getPosicion().y * 90) , mWidth, mHeight);
		
	}

	// ----------------------------------------------retorna la etiqueta con la
	// imagen actual de nuestro personaje
	public JLabel getGrafico() {
		return this.mGrafico;
	}
	


}
