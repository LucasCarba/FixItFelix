package vistaGame;


import java.awt.*;
import javax.swing.*;
import controlador.Control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends javax.swing.JFrame implements ActionListener {

	// --------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int puntos;

	// ----------------------------------------------
	private JFrame panelGeneral;
	private JTextField EtiquetaNomJug;
	private String nombreJug;
	private JPanel panelPuntos;
	private static Control control;
	private JButton btnEnviarNombre;
	private boolean gano;

	/**
	 * Create the application.
	 */
	public GUI(Control control, boolean gano) {
		this.gano = gano;
		GUI.control = control;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// ------------------------------------------------------------creacion del
		// panel principal
		panelGeneral = new JFrame();
		panelGeneral.setVisible(false);
		panelGeneral.setResizable(false);
		panelGeneral.setAutoRequestFocus(false);
		panelGeneral.setBounds(0, 0, 403, 443);
		panelGeneral.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		panelGeneral.getContentPane().setLayout(null);

		// --------------------------------------------------------panel igreso de
		// puntos, Se usa para igresar los puntos que el jugador obtuvo y chequear que
		// el sistema funcione correctamente

		JPanel panelIngresoPuntos = new JPanel();
		panelIngresoPuntos.setBackground(Color.DARK_GRAY);
		panelIngresoPuntos.setBounds(76, 11, 229, 147);
		panelGeneral.getContentPane().add(panelIngresoPuntos);
		panelIngresoPuntos.setLayout(null);

		panelPuntos = new JPanel();
		panelPuntos.setBounds(0, 69, 229, 179);
		panelIngresoPuntos.add(panelPuntos);
		panelPuntos.setVisible(true);
		panelPuntos.setBackground(Color.RED);
		panelPuntos.setLayout(null);

		EtiquetaNomJug = new JTextField();
		EtiquetaNomJug.setFont(new Font("Consolas", Font.PLAIN, 11));
		EtiquetaNomJug.setText("");
		EtiquetaNomJug.setBounds(21, 2, 188, 28);
		panelPuntos.add(EtiquetaNomJug);
		EtiquetaNomJug.setColumns(10);

		btnEnviarNombre = new JButton("ENVIAR");
		btnEnviarNombre.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnEnviarNombre.addActionListener(this);
		btnEnviarNombre.setBounds(21, 41, 188, 23);
		panelPuntos.add(btnEnviarNombre);

		JLabel IMGpTS = new JLabel("");
		IMGpTS.setIcon(new ImageIcon(GUI.class.getResource("/img/edificio.png")));
		IMGpTS.setBounds(-42, 2, 284, 275);
		panelPuntos.add(IMGpTS);

		JLabel lblEstasEnEl = new JLabel("ESTAS EN EL TOP FIVE");
		lblEstasEnEl.setBounds(20, 11, 191, 35);
		panelIngresoPuntos.add(lblEstasEnEl);
		lblEstasEnEl.setForeground(Color.WHITE);
		lblEstasEnEl.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblEstasEnEl.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel lblIngreseSuNick = new JLabel("INGRESE SU NICK");
		lblIngreseSuNick.setBounds(20, 38, 191, 25);
		panelIngresoPuntos.add(lblIngreseSuNick);
		lblIngreseSuNick.setForeground(Color.WHITE);
		lblIngreseSuNick.setBackground(Color.WHITE);
		lblIngreseSuNick.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblIngreseSuNick.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblFelicitacionesTerminasteEl = new JLabel("FELICITACIONES TERMINASTE EL JUEGO");
		lblFelicitacionesTerminasteEl.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblFelicitacionesTerminasteEl.setForeground(Color.WHITE);
		lblFelicitacionesTerminasteEl.setHorizontalAlignment(SwingConstants.CENTER);
		lblFelicitacionesTerminasteEl.setBounds(0, 169, 397, 41);
		panelGeneral.getContentPane().add(lblFelicitacionesTerminasteEl);
		lblFelicitacionesTerminasteEl.setVisible(gano);
		
		JLabel labelFestejo = new JLabel("");
		labelFestejo.setIcon(new ImageIcon(GUI.class.getResource("/img/festejo.gif")));
		labelFestejo.setBounds(0, 169, 400, 240);
		panelGeneral.getContentPane().add(labelFestejo);
		labelFestejo.setVisible(gano);
		// -----------------------------------------------------------------------------------------------

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setIcon(new ImageIcon(GUI.class.getResource("/img/fondoJuego.png")));
		lblNewLabel.setBounds(0, 0, 400, 414);
		panelGeneral.getContentPane().add(lblNewLabel);
	}

	public void setVisible() {
		panelGeneral.setVisible(true);
	}

	public void setNombreJug(String nombreJug) {
		this.nombreJug = nombreJug;
	}

	// --------------------------------------------------------------------Action
	// performed para GUI
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnEnviarNombre) {

			nombreJug = EtiquetaNomJug.getText();
			if (control.checkNombre(nombreJug)) {
				control.setNombreJugador(nombreJug);
				control.puntajes(puntos);
				control.setVisibleMenu();
				panelGeneral.setVisible(false);
				panelPuntos.setVisible(false);
			} else {
				EtiquetaNomJug.setText("ERROR");
			}
		}

	}

	public void setPuntos(int p) {
		puntos = p;
	}
}