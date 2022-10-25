package vistaGame;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import modelo.*;

public class GPanel {

	protected JLabel mGrafico;

	protected ImageIcon iRoto;
	protected ImageIcon iSemiroto;
	protected ImageIcon iSano;

	protected final int mWidth;
	protected final int mHeight;

	protected Panel panel;
	protected Point pos;

	public GPanel(Panel panel, Point p, int mWidth, int mHeight) {

		this.panel = panel;
		pos = p;
		this.mWidth = mWidth;
		this.mHeight = mHeight;

		iRoto = new ImageIcon(this.getClass().getResource("/img/Rota.png"));
		iSemiroto = new ImageIcon(this.getClass().getResource("/img/SemiRota.png"));
		iSano = new ImageIcon((this.getClass().getResource("/img/sano.png")));

		// +++++++++++++++++++++++++++

		/*
		 * if (mGrafico==null) { mGrafico = new JLabel(iSano); mGrafico.setBounds(pos.x,
		 * pos.y, mWidth, mHeight);}
		 */
		// +++++++++++++++++++++++++++++++

		asignarImg();

	}

	public void asignarImg() {

		if (panel.isSano()) {
			if (mGrafico == null) {

				mGrafico = new JLabel(iSano);
				mGrafico.setBounds(pos.x, pos.y, mWidth, mHeight);
			}
		} else if (panel.estaRoto()) {

			if (mGrafico == null) {
				mGrafico = new JLabel(iRoto);
				mGrafico.setBounds(pos.x, pos.y, mWidth, mHeight);
			}
		} else {

			if (mGrafico == null) {
				mGrafico = new JLabel(iSemiroto);
				mGrafico.setBounds(pos.x, pos.y, mWidth, mHeight);
			}
		}

	}

	public JLabel getGrafico() {
		return this.mGrafico;
	}

	public void refrescar() {

		if (panel.isSano()) {

			mGrafico.setIcon(iSano);
			mGrafico.setBounds(pos.x, pos.y, mWidth, mHeight);

		} else if (panel.estaRoto()) {

			mGrafico.setIcon(iRoto);
			mGrafico.setBounds(pos.x, pos.y, mWidth, mHeight);

		} else {

			mGrafico.setIcon(iSemiroto);
			mGrafico.setBounds(pos.x, pos.y, mWidth, mHeight);

		}

	}

	public void setVisible(boolean b) {
		mGrafico.setVisible(b);
	}
	
	
	public void borrar() {

		// ----------------------------------------------------------------
		ImageIcon imagenNada = new ImageIcon((this.getClass().getResource("/img/nada.png")));
		mGrafico.setIcon(imagenNada);
		mGrafico.setBounds(pos.x, pos.y, this.mWidth, this.mHeight);
	

	}

}
