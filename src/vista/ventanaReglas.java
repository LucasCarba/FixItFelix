package vista;

import java.awt.EventQueue;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ventanaReglas implements ActionListener {

	private JFrame frameReglas;
	// --------Componenetes frame reglas

	private JButton btnVolverReglas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaReglas window = new ventanaReglas();
					window.frameReglas.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ventanaReglas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// --------------------------------------------------FRAME DE
		// REGLAS------------------------------------------------------------------------------------

		frameReglas = new JFrame();
		frameReglas.setType(Type.POPUP);
		frameReglas.setBounds(100, 100, 862, 576);
		frameReglas.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frameReglas.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel(new ImageIcon(this.getClass().getResource("/img/reglas.png")));
		lblNewLabel.setBounds(10, -26, 862, 513);
		frameReglas.getContentPane().add(lblNewLabel);

		btnVolverReglas = new JButton("volver");
		btnVolverReglas.setBounds(619, 498, 157, 23);
		frameReglas.getContentPane().add(btnVolverReglas);
		frameReglas.setVisible(false);

		btnVolverReglas.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// -------------------------------------Reglas del juego
		if (e.getSource() == btnVolverReglas) {
			frameReglas.setVisible(false);
		}

	}

	public void setVisible(boolean valor) {
		frameReglas.setVisible(valor);
	}

}
