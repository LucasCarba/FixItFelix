package vistaGame;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


import modelo.*;

public class GVentana {

	
	protected final int mWidth = 54;
	protected final int mHeight = 90;
	protected ImageIcon imagen;
	protected JLabel ventanaGrafico;

	// '''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''

	protected Ventana ventana;
	protected GPanel gPaneles[];
	protected Panel paneles[];
	protected Point posicion;
	
	public GVentana(Point p, Ventana v) {
		

	posicion=p;
		ventana = v;
		// ----------------------------------------------------------------

		this.paneles = v.getPaneles();
		gPaneles = new GPanel[paneles.length];

		if (paneles.length == 2) {

			
			if(ventana.isFlorero()) {
				 imagen = new ImageIcon((this.getClass().getResource("/img/macetero.png")));	
			}else 
				if(ventana.isMoldura())
					{imagen = new ImageIcon((this.getClass().getResource("/img/moldura.png")));	}
					else	
						if(ventana.isHojaIzquierda()) {
							imagen = new ImageIcon((this.getClass().getResource("/img/comunHI.png")));
						}
						else 
							if(ventana.isHojaDerecha()) {
								imagen = new ImageIcon((this.getClass().getResource("/img/comunHD.png")));
							}
							else 
								if(ventana.isCerrada()) {
									imagen = new ImageIcon((this.getClass().getResource("/img/comunCerrada.png")));
								}
								else imagen = new ImageIcon((this.getClass().getResource("/img/comun.png")));
			
			ventanaGrafico = new JLabel(imagen);
			
			ventanaGrafico.setBounds(p.x, p.y, this.mWidth, this.mHeight);
			
			
			gPaneles[0] = new GPanel(paneles[0], new Point(17, 26), 20, 16);
			gPaneles[1] = new GPanel(paneles[1], new Point(17, 46), 20, 16);

			if(!ventana.isCerrada()) {
			ventanaGrafico.add(gPaneles[0].getGrafico());
			ventanaGrafico.add(gPaneles[1].getGrafico());}
			
		} else if (paneles.length == 4) {

			imagen = new ImageIcon((this.getClass().getResource("/img/puerta.png")));

			ventanaGrafico = new JLabel(imagen);
			ventanaGrafico.setBounds(p.x, p.y, this.mWidth, this.mHeight);
			
			gPaneles[0] = new GPanel(paneles[0], new Point(11, 48), 14, 14);
			gPaneles[1] = new GPanel(paneles[1], new Point(31, 48), 14, 14);
			gPaneles[2] = new GPanel(paneles[2], new Point(11, 68), 14, 14);
			gPaneles[3] = new GPanel(paneles[3], new Point(31, 68), 14, 14);

			ventanaGrafico.add(gPaneles[0].getGrafico());
			ventanaGrafico.add(gPaneles[1].getGrafico());
			ventanaGrafico.add(gPaneles[2].getGrafico());
			ventanaGrafico.add(gPaneles[3].getGrafico());

		} else if (paneles.length == 8) {

			imagen = new ImageIcon((this.getClass().getResource("/img/semicircular.png")));

			ventanaGrafico = new JLabel(imagen);
			ventanaGrafico.setBounds(p.x, p.y, this.mWidth, this.mHeight);

			gPaneles[0] = new GPanel(paneles[0], new Point(7, 44), 8, 8);
			gPaneles[1] = new GPanel(paneles[1], new Point(16, 44), 8, 8);
			gPaneles[2] = new GPanel(paneles[2], new Point(29, 44), 8, 8);
			gPaneles[3] = new GPanel(paneles[3], new Point(39, 44), 8, 8);
			gPaneles[4] = new GPanel(paneles[4], new Point(7, 57), 8, 8);
			gPaneles[5] = new GPanel(paneles[5], new Point(16, 57), 8, 8);
			gPaneles[6] = new GPanel(paneles[6], new Point(29, 57), 8, 8);
			gPaneles[7] = new GPanel(paneles[7], new Point(39, 57), 8, 8);


			ventanaGrafico.add(gPaneles[0].getGrafico());
			ventanaGrafico.add(gPaneles[1].getGrafico());
			ventanaGrafico.add(gPaneles[2].getGrafico());
			ventanaGrafico.add(gPaneles[3].getGrafico());
			ventanaGrafico.add(gPaneles[4].getGrafico());
			ventanaGrafico.add(gPaneles[5].getGrafico());
			ventanaGrafico.add(gPaneles[6].getGrafico());
			ventanaGrafico.add(gPaneles[7].getGrafico());

		}
	}

	
	public JLabel getGrafico() {
		return ventanaGrafico;
	}
	
	public void refrescar() {
		
		int i=gPaneles.length-1;
			while( i!=-1) {
				
				gPaneles[i].refrescar();
				i--;
			}
			
	}
	
	public void borrar() {

		// ----------------------------------------------------------------
		ImageIcon imagenNada = new ImageIcon((this.getClass().getResource("/img/nada.png")));
		ventanaGrafico.setIcon(imagenNada);
		ventanaGrafico.setBounds(posicion.x, posicion.y, this.mWidth, this.mHeight);
		
		if (paneles.length == 2) {
			
			
			gPaneles[0].borrar();
			gPaneles[1].borrar();

			if(!ventana.isCerrada()) {
			ventanaGrafico.add(gPaneles[0].getGrafico());
			ventanaGrafico.add(gPaneles[1].getGrafico());}
			
		} else if (paneles.length == 4) {

			gPaneles[0].borrar();
			gPaneles[1].borrar();
			gPaneles[2].borrar();
			gPaneles[3].borrar();

			ventanaGrafico.add(gPaneles[0].getGrafico());
			ventanaGrafico.add(gPaneles[1].getGrafico());
			ventanaGrafico.add(gPaneles[2].getGrafico());
			ventanaGrafico.add(gPaneles[3].getGrafico());

		} else if (paneles.length == 8) {

			gPaneles[0].borrar();
			gPaneles[1].borrar();
			gPaneles[2].borrar();
			gPaneles[3].borrar();
			gPaneles[4].borrar();
			gPaneles[5].borrar();
			gPaneles[6].borrar();
			gPaneles[7].borrar();


			ventanaGrafico.add(gPaneles[0].getGrafico());
			ventanaGrafico.add(gPaneles[1].getGrafico());
			ventanaGrafico.add(gPaneles[2].getGrafico());
			ventanaGrafico.add(gPaneles[3].getGrafico());
			ventanaGrafico.add(gPaneles[4].getGrafico());
			ventanaGrafico.add(gPaneles[5].getGrafico());
			ventanaGrafico.add(gPaneles[6].getGrafico());
			ventanaGrafico.add(gPaneles[7].getGrafico());

		}
	}
	
}
	
	
	




