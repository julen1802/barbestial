package packInterfaz;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juegoProyecto.Partida;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;

import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaConfig extends JFrame {

	private static VentanaConfig miVentanaConfig;
	private JPanel contentPane;
	private JTextField nJugadores;
	private JTextField nIAs;
	private boolean funcionando = true;

	public boolean getFuncionando() {
		return funcionando;
	}
	public VentanaConfig() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaConfig.class.getResource("/packInterfaz/portada.jpg")));
		setTitle("Configuracion");
		funcionando = true;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize(); //Tamaño del frame actual (ancho x alto)
		if (frameSize.height > screenSize.height) {
		frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
		frameSize.width = screenSize.width;
		}
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		
		JLabel lblNewLabel = new JLabel("Bar Bestial");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(140, 0, 148, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNjugadores = new JLabel("Jugadores IA");
		lblNjugadores.setBounds(20, 100, 80, 20);
		contentPane.add(lblNjugadores);
		
		JLabel lblJugadoresEnLa = new JLabel("Jugadores en la partida");
		lblJugadoresEnLa.setBounds(20, 70, 148, 20);
		contentPane.add(lblJugadoresEnLa);
		
		nJugadores = new JTextField();
		nJugadores.setBounds(167, 70, 86, 20);
		contentPane.add(nJugadores);
		nJugadores.setColumns(10);
		
		JLabel lblErrorAlgunoDe = new JLabel("Error. Alguno de los campos no cumple los requisitos");
		lblErrorAlgunoDe.setBounds(84, 330, 300, 14);
		contentPane.add(lblErrorAlgunoDe);
		lblErrorAlgunoDe.setVisible(false);
		
		nIAs = new JTextField();
		nIAs.setBounds(167, 100, 86, 20);
		contentPane.add(nIAs);
		nIAs.setColumns(10);
		
	
		
		JLabel lblTiposDePartida = new JLabel("Tipos de Partida ");
		lblTiposDePartida.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTiposDePartida.setBounds(20, 142, 171, 33);
		contentPane.add(lblTiposDePartida);
		
		JTextPane panelDescripcion = new JTextPane();
		panelDescripcion.setText("Partida Normal 2-10 jugadores.");
		panelDescripcion.setBounds(40, 196, 320, 120);
		contentPane.add(panelDescripcion);
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object eleccion = comboBox.getSelectedItem();
				System.out.println(eleccion.toString());
				if(eleccion.toString().equals("Partida Normal")){
					panelDescripcion.setText("2-10 jugadores. Se reparten 12 cartas a cada jugador." + " El jugador que mas cartas de su color introduzca en el Bar ganará la partida. En caso de empate ganará aquel que la suma de las fuerzas de sus cartas sea el menor número.");
				}
				else if(eleccion.toString().equals("Partida Mundial")){
					panelDescripcion.setText("10-12 jugadores. Se reparten 12 cartas a cada jugador. Esta partida es una de las partidas mas largas." + " El jugador que mas cartas de su color introduzca en el Bar ganará la partida. En caso de empate ganará aquel que la suma de fuerzas de sus cartas sea el menor número.");
				}
				else if(eleccion.toString().equals("Partida de Eleccion")){
					panelDescripcion.setText("2-10 jugadores. Se eligen 4 de las 12 cartas, las cuales serán descartadas. De este modo, el juego comenzará con 8 cartas en el mazo de cada jugador." + " El jugador que mas cartas de su color introduzca en el Bar ganará la partida. En caso de empate ganará aquel que la suma de fuerzas de sus cartas sea el menor número.");
				}
				else if(eleccion.toString().equals("Partida Cortocircuito")){
					panelDescripcion.setText("2-10 jugadores. Se reparten 12 cartas a cada jugador. Esta vez controlaras al jugador de tu izquierda pero debes intentar que pierda." + " El jugador que mas cartas de su color introduzca en el Bar ganará la partida. En caso de empate ganará aquel que la suma de fuerzas de sus cartas sea el menor número.");
				}
				else if(eleccion.toString().equals("Partida Eterna")){
					panelDescripcion.setText("2-6 jugadores. Se reparten 24 cartas a cada jugador, es decir, 2 veces cada carta. Esta vez controlaras al jugador de tu izquierda pero debes intentar que pierda." + " El jugador que mas cartas de su color introduzca en el Bar ganará la partida. En caso de empate ganará aquel que la suma de fuerzas de sus cartas sea el menor número.");
				}
				
			}
		});
		
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		JButton Comenzar = new JButton("Comenzar Partida");
		Comenzar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int jugs = Integer.parseInt(nJugadores.getText());
				int ias = Integer.parseInt(nIAs.getText());
				if(comboBox.getSelectedItem().toString().equals("Partida Normal")){
					//panelDescripcion.setText("2-12 jugadores. Se reparten 12 cartas a cada jugador." + " El jugador que mas cartas de su color introduzca en el Bar ganará la partida. En caso de empate ganará aquel que la suma de fuerzas de sus cartas se el numero menor.");
					if((12>=jugs && jugs>=2) && (jugs>=ias) && (ias>=0)){
						System.out.println("Funciona bien");
						lblErrorAlgunoDe.setVisible(false);
						setVisible(false);
						Partida.getPartida().inicializarTipoPartida(0);
						Partida.getPartida().crearIAs(jugs, ias);
						jugs = jugs - ias;
						if(jugs>0) {
							IniciarSesion.getIniciarSesion().iniciarUsuarios(jugs);
						}
						else {
							Partida.getPartida().prepararMesa();
						}
					}
					else {
						lblErrorAlgunoDe.setVisible(true);
					}
				}
				else if(comboBox.getSelectedItem().toString().equals("Partida de Eleccion")){
					//panelDescripcion.setText("2-10 jugadores. Se eligen 4 de las 12 cartas, las cuales serán descartadas. De este modo, el juego comenzará con 8 cartas en el mazo de cada jugador." + " El jugador que mas cartas de su color introduzca en el Bar ganará la partida. En caso de empate ganará aquel que la suma de fuerzas de sus cartas se el numero menor.");
					if((10>=jugs && jugs>=2) && (jugs>=ias) && (ias>=0)){
						System.out.println("Funciona bien");
						lblErrorAlgunoDe.setVisible(false);
						setVisible(false);
						Partida.getPartida().inicializarTipoPartida(1);
						Partida.getPartida().crearIAs(jugs, ias);
						jugs = jugs- ias;
						if(jugs>0) {
							IniciarSesion.getIniciarSesion().iniciarUsuarios(jugs);
						}
						else {
							Partida.getPartida().prepararMesa();
						}					}
					else {
						lblErrorAlgunoDe.setVisible(true);
					}
				}
				else if(comboBox.getSelectedItem().toString().equals("Partida Mundial")){
					//panelDescripcion.setText("10-12 jugadores. Se reparten 12 cartas a cada jugador. Esta partida es una de las partidas mas largas." + " El jugador que mas cartas de su color introduzca en el Bar ganará la partida. En caso de empate ganará aquel que la suma de fuerzas de sus cartas se el numero menor.");
					if((12>=jugs && jugs>=10) && (jugs>=ias) && (ias>=0)){
						System.out.println("Funciona bien");
						lblErrorAlgunoDe.setVisible(false);
						setVisible(false);
						Partida.getPartida().inicializarTipoPartida(2);

						Partida.getPartida().crearIAs(jugs, ias);
						jugs = jugs- ias;
						if(jugs>0) {
							IniciarSesion.getIniciarSesion().iniciarUsuarios(jugs);
						}
						else {
							Partida.getPartida().prepararMesa();
						}
					}
					else {
						lblErrorAlgunoDe.setVisible(true);
					}
				}
				
				else if(comboBox.getSelectedItem().toString().equals("Partida Cortocircuito")){
					//panelDescripcion.setText("2-10 jugadores. Se reparten 12 cartas a cada jugador. Esta vez controlaras al jugador de tu izquierda pero debes intentar que pierda." + " El jugador que mas cartas de su color introduzca en el Bar ganará la partida. En caso de empate ganará aquel que la suma de fuerzas de sus cartas se el numero menor.");
					if((10>=jugs && jugs>=2) && (jugs>=ias) && (ias>=0)){
						System.out.println("Funciona bien");
						lblErrorAlgunoDe.setVisible(false);
						setVisible(false);
						Partida.getPartida().inicializarTipoPartida(3);

						Partida.getPartida().crearIAs(jugs, ias);
						jugs = jugs- ias;
						if(jugs>0) {
							IniciarSesion.getIniciarSesion().iniciarUsuarios(jugs);
						}
						else {
							Partida.getPartida().prepararMesa();
						}					}
					else {
						lblErrorAlgunoDe.setVisible(true);
					}
				}
			}
		});
		
		Comenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Partida Normal", "Partida de Eleccion", "Partida Mundial", "Partida Eterna", "Partida Cortocircuito"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(201, 151, 159, 23);
		contentPane.add(comboBox);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(20, 176, 86, 14);
		contentPane.add(lblDescripcion);
		
		JLabel lblMax = new JLabel("Max. 12");
		lblMax.setBounds(267, 73, 46, 14);
		contentPane.add(lblMax);
		
		JLabel label = new JLabel("Max. 12");
		label.setBounds(267, 103, 46, 14);
		contentPane.add(label);
		Comenzar.setBounds(134, 350, 150, 25);
		contentPane.add(Comenzar);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(VentanaConfig.class.getResource("/packInterfaz/human.png")));
		label_1.setBounds(320, 60, 30, 30);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(VentanaConfig.class.getResource("/packInterfaz/ia.png")));
		label_2.setBounds(320, 95, 30, 30);
		contentPane.add(label_2);

		

	}
	public static VentanaConfig getVentanaConfig() {
		if(miVentanaConfig==null) {
			miVentanaConfig = new VentanaConfig();
		}
		return miVentanaConfig;
	}
	public void iniciar() {
		setVisible(true);
	}
}
