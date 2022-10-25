package vista;



import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import controlador.Control;
import excepciones.ErrorAlAbrirArchivo;
import excepciones.VectorFueraDeRangoException;
import vistaGame.Edificio;
import java.awt.Cursor;
import java.applet.AudioClip;
import java.awt.Color;
import javax.swing.JLabel;

import java.awt.Font;

public class Menu extends javax.swing.JFrame   implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private  AudioClip sonido;
	
	//----------------------------------------------
	private ventanaReglas frameReglas; 
	private ventanaPuntajes framePuntajes;
	private ventanaConfig frameConfig;
	private Edificio edificio;	
	private  JFrame framePrincipal;	
	private static Control control;

	//---------botones menu
	
	private JButton btnQuieroJugar;
	private JButton btnTop5;
	private JButton btnReglasDelJuego;
	private JButton btnConfig;
	
	public Menu(Control control) {
		
		Menu.control=control;
		
		
		
		
	}

	/**
	 * Inicializador de los frames y sus contenidos
	 */
	public void initialize() {
		
		
		sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Sonidos/Musica.wav"));
		sonido.play();
		sonido.loop();
		
		
		//------------------------------------------------------------------------------------------------------------------------------------------------------
		frameReglas=new ventanaReglas(); 
		framePuntajes=new ventanaPuntajes();
		frameConfig=new ventanaConfig(control);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------

		framePrincipal = new JFrame();
		framePrincipal.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		framePrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));			
		framePrincipal.setBounds(100, 100, 775, 320);
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipal.getContentPane().setLayout(null);

		
		

		// ----------------------------------------------------------------BOTON REGLAS DEL JUEGO----------------------------------------------------------------------------

		
		btnReglasDelJuego = new JButton("Reglas del juego");
		btnReglasDelJuego.setForeground(Color.WHITE);
		btnReglasDelJuego.setFont(new Font("Consolas", Font.PLAIN, 20));
		btnReglasDelJuego.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReglasDelJuego.setRolloverSelectedIcon(new ImageIcon(Menu.class.getResource("/img/blue_button01.png")));
		btnReglasDelJuego.setHorizontalTextPosition(SwingConstants.CENTER);
		btnReglasDelJuego.setOpaque(false);
		btnReglasDelJuego.setName("");
		btnReglasDelJuego.setToolTipText("");
		btnReglasDelJuego.setActionCommand("");
		btnReglasDelJuego.setContentAreaFilled(false);
		btnReglasDelJuego.setBackground(Color.WHITE);
		btnReglasDelJuego.setDefaultCapable(false);
		btnReglasDelJuego.setFocusTraversalKeysEnabled(false);
		btnReglasDelJuego.setBorderPainted(false);
		btnReglasDelJuego.setFocusable(false);
		btnReglasDelJuego.setRolloverEnabled(false);
		btnReglasDelJuego.setRequestFocusEnabled(false);
		btnReglasDelJuego.setRolloverIcon(new ImageIcon(Menu.class.getResource("/img/blue_button01.png")));
		btnReglasDelJuego.setIcon(new ImageIcon(Menu.class.getResource("/img/blue_button00.png")));
		btnReglasDelJuego.setDisabledSelectedIcon(new ImageIcon(Menu.class.getResource("/img/blue_button01.png")));
		btnReglasDelJuego.setDisabledIcon(new ImageIcon(Menu.class.getResource("/img/blue_button00.png")));
		btnReglasDelJuego.addActionListener(this);
		btnReglasDelJuego.setBounds(240, 100, 250, 60);
		framePrincipal.getContentPane().add(btnReglasDelJuego);

		// --------------------------------------------------------------------------------------BOTON QUIERO JUGAR-------------------------------------------------------------------

		btnQuieroJugar = new JButton("Quiero Jugar!");
		btnQuieroJugar.setForeground(Color.WHITE);
		btnQuieroJugar.setFont(new Font("Consolas", Font.PLAIN, 20));
		btnQuieroJugar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuieroJugar.setBorderPainted(false);
		btnQuieroJugar.setContentAreaFilled(false);
		btnQuieroJugar.setDefaultCapable(false);
		btnQuieroJugar.setFocusTraversalKeysEnabled(false);
		btnQuieroJugar.setFocusable(false);

		btnQuieroJugar.setRolloverIcon(new ImageIcon(Menu.class.getResource("/img/green_button01.png")));
		btnQuieroJugar.setOpaque(false);
		btnQuieroJugar.setRequestFocusEnabled(false);
		btnQuieroJugar.setRolloverEnabled(false);

		btnQuieroJugar.setRolloverSelectedIcon(new ImageIcon(Menu.class.getResource("/img/green_button01.png")));
		btnQuieroJugar.setPressedIcon(new ImageIcon(Menu.class.getResource("/img/green_button01.png")));
		btnQuieroJugar.setIcon(new ImageIcon(Menu.class.getResource("/img/green_button00.png")));
		btnQuieroJugar.setHorizontalTextPosition(SwingConstants.CENTER);
		
		btnQuieroJugar.setBounds(240, 20, 250, 60);
		framePrincipal.getContentPane().add(btnQuieroJugar);
		
		
		btnQuieroJugar.addActionListener(this);

		// -----------------------------------------------------------------------------------TOP 5--------------------------------------------------------------------------------

		 btnTop5 = new JButton("Top 5!");

		btnTop5.setForeground(Color.WHITE);
		btnTop5.setFont(new Font("Consolas", Font.PLAIN, 20));
		btnTop5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTop5.setBorderPainted(false);
		btnTop5.setContentAreaFilled(false);
		btnTop5.setDefaultCapable(false);
		btnTop5.setFocusTraversalKeysEnabled(false);
		btnTop5.setFocusable(false);
		btnTop5.setRolloverIcon(new ImageIcon(Menu.class.getResource("/img/yellow_button01.png")));
		btnTop5.setOpaque(false);
		btnTop5.setForeground(Color.WHITE);
		btnTop5.setFont(new Font("Consolas", Font.PLAIN, 20));
		btnTop5.setFocusable(false);
		btnTop5.setFocusTraversalKeysEnabled(false);
		btnTop5.setDefaultCapable(false);
		btnTop5.setContentAreaFilled(false);
		btnTop5.setBorderPainted(false);

		btnTop5.setOpaque(false);
		btnTop5.setRequestFocusEnabled(false);
		btnTop5.setRolloverEnabled(false);
		btnTop5.setRolloverSelectedIcon(new ImageIcon(Menu.class.getResource("/img/yellow_button01.png")));
		btnTop5.setPressedIcon(new ImageIcon(Menu.class.getResource("/img/yellow_button01.png")));
		btnTop5.setIcon(new ImageIcon(Menu.class.getResource("/img/yellow_button00.png")));
		btnTop5.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTop5.addActionListener(this);
		btnTop5.setBounds(240, 180, 250, 60);
		framePrincipal.getContentPane().add(btnTop5);

		// ------------------------------------------------------------------------------------CONFIGURACION--------------------------------------------------------------------------
		
		
		btnConfig = new JButton("");
		btnConfig.setIcon(new ImageIcon(Menu.class.getResource("/img/config0.png")));
		btnConfig.setBounds(684, 190, 50, 50);
		framePrincipal.getContentPane().add(btnConfig);

		btnConfig.setForeground(Color.WHITE);
		btnConfig.setFont(new Font("Consolas", Font.PLAIN, 20));
		btnConfig.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfig.setBorderPainted(false);
		btnConfig.setContentAreaFilled(false);
		btnConfig.setDefaultCapable(false);
		btnConfig.setFocusTraversalKeysEnabled(false);
		btnConfig.setFocusable(false);

		btnConfig.setRolloverIcon(new ImageIcon(Menu.class.getResource("/img/config1.png")));
		btnConfig.setOpaque(false);
		btnConfig.setRequestFocusEnabled(false);
		btnConfig.setRolloverEnabled(false);

		btnConfig.setRolloverSelectedIcon(new ImageIcon(Menu.class.getResource("/img/config1.png")));
		btnConfig.setPressedIcon(new ImageIcon(Menu.class.getResource("/img/config1.png")));
		btnConfig.setIcon(new ImageIcon(Menu.class.getResource("/img/config1.png")));
		btnConfig.setHorizontalTextPosition(SwingConstants.CENTER);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Menu.class.getResource("/img/fondo menu.png")));
		label.setBounds(0, 0, 764, 282);
		framePrincipal.getContentPane().add(label);

		btnConfig.addActionListener(this);
	}
	
	
	//--------------------------------------------------------------------------------------GETTERS------------------------------------------------------------------------------------

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnQuieroJugar) {		
			sonido.stop();
			edificio=new Edificio(control);
			framePrincipal.setVisible(false);
			setVisibleJuego();
		}
		
		if(e.getSource()==btnReglasDelJuego) {
			frameReglas.setVisible(true);
		}
		
		if(e.getSource()==btnTop5) {
			try {
				control.cargarDatos(framePuntajes.getTabla());
			} catch (VectorFueraDeRangoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ErrorAlAbrirArchivo e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			framePuntajes.setVisible(true);
		}
		

		if(e.getSource()==btnConfig ) {
			frameConfig.setVisible(true);
		}		
				
		
	}
	public Edificio getEdificio () {
		return edificio;
	}
	
	public JFrame getFramePrincipal() {
		return framePrincipal;}

	public void setVisibleJuego() {
		edificio.setVisible();
		
	}
	
	public void setVisible() {
		sonido.play();
		sonido.loop();
		framePrincipal.setVisible(true);
	}
}
	
