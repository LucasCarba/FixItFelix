package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class ventanaPuntajes implements ActionListener {

	private JFrame framePuntajes;

	// -------componentes puntajes

	private JButton btnVolverPuntajes;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaPuntajes window = new ventanaPuntajes();
					window.framePuntajes.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ventanaPuntajes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// ----------------------------------------------FRAME PUNTAJES
		// -----------------------------------------------------------------------------------

		framePuntajes = new JFrame();
		framePuntajes.setVisible(false);
		framePuntajes.setBounds(100, 100, 775, 320);
		framePuntajes.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		framePuntajes.getContentPane().setLayout(null);

		btnVolverPuntajes = new JButton("volver");
		btnVolverPuntajes.setBounds(330, 241, 124, 29);
		framePuntajes.getContentPane().add(btnVolverPuntajes);

		table = new JTable();
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);

		table.setModel(
				new DefaultTableModel(
						new Object[][] { { "Posicion", "Jugador", "Puntajes" }, { "1", 0, 0 }, { "2", 0, 0 },
								{ "3", 0, 0 }, { "4", 0, 0 }, { "5", 0, 0 }, },
						new String[] { "Posicion", "Jugador", "Puntaje" }) {

					private static final long serialVersionUID = 1L;
					Class[] columnTypes = new Class[] { String.class, String.class, String.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});

		table.getColumnModel().getColumn(0).setResizable(false);
		table.setBounds(103, 70, 592, 96);
		framePuntajes.getContentPane().add(table);

		btnVolverPuntajes.addActionListener(this);

	}

	public JTable getTabla() {
		return table;
	}

	public void setVisible(boolean valor) {
		framePuntajes.setVisible(valor);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// //-------------------------------------Puntajes
		if (e.getSource() == btnVolverPuntajes) {
			framePuntajes.setVisible(false);
		}

	}

}
