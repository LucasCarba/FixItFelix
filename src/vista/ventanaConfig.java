package vista;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controlador.Control;

public class ventanaConfig implements ActionListener {

	private JFrame frameConfig;
	private Control control;
	private int nivel;
	// --------componentes de frame Config

	private JButton btnEnviar;
	private JComboBox<String> selecNivel;

	public ventanaConfig(Control control) {
		nivel = 0;
		this.control = control;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// ---------------------------------------------------------------------------------------FRAME
		// CONFIGURACION--------------------------------------------------------

		frameConfig = new JFrame();
		frameConfig.setType(Type.POPUP);
		frameConfig.setBounds(100, 100, 221, 266);
		frameConfig.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frameConfig.getContentPane().setLayout(null);
		frameConfig.setVisible(false);

		JLabel lblNivel = new JLabel("Nivel :");
		lblNivel.setBounds(10, 75, 52, 23);
		frameConfig.getContentPane().add(lblNivel);

		btnEnviar = new JButton("ENVIAR");
		btnEnviar.setBounds(10, 139, 168, 61);
		frameConfig.getContentPane().add(btnEnviar);
		btnEnviar.addActionListener(this);

		selecNivel = new JComboBox<String>();
		selecNivel.setBounds(53, 75, 125, 20);
		frameConfig.getContentPane().add(selecNivel);

		selecNivel.setModel(
				new DefaultComboBoxModel<String>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		selecNivel.setMaximumRowCount(30);
		selecNivel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ----------------------------------------Config

		if (e.getSource() == btnEnviar) {
			control.selecionarNivel(nivel);
			frameConfig.setVisible(false);
		}

		if (e.getSource() == selecNivel) {
			nivel = Integer.parseInt(selecNivel.getSelectedItem().toString());

		}

	}

	public void setVisible(boolean valor) {
		frameConfig.setVisible(valor);
	}

}
