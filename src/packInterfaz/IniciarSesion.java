package packInterfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juegoProyecto.ListaJugadores;
import juegoProyecto.Partida;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IniciarSesion extends JFrame {

	private static IniciarSesion miIniciarSesion;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private String[] usuarios;
	private int nJugadores;
	
	private IniciarSesion() {
		nJugadores = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre De Usuario");
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreDeUsuario.setBounds(10, 24, 160, 36);
		contentPane.add(lblNombreDeUsuario);
		
		JLabel Contr = new JLabel("Contrase\u00F1a");
		Contr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Contr.setBounds(10, 69, 125, 14);
		contentPane.add(Contr);
		
		textField = new JTextField();
		textField.setBounds(145, 31, 168, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(145, 68, 168, 21);
		contentPane.add(passwordField);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setBounds(123, 127, 125, 23);
		contentPane.add(btnIniciarSesion);
		
		JLabel lblNewLabel = new JLabel("Nombre de usuario o contrasena incorrectos. Intentalo de nuevo.");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setVisible(false);
		lblNewLabel.setBounds(33, 94, 328, 26);
		contentPane.add(lblNewLabel);
			btnIniciarSesion.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					lblNewLabel.setVisible(false);
					String usuario = textField.getText();
					char[] contrasena = passwordField.getPassword();
					String cont ="";
					for(int ind = 0; ind<contrasena.length;ind++) {
						cont = cont + (Character.toString(contrasena[ind]));
					}
					boolean iniciado = ListaJugadores.getListaJugadores().iniciarSesion(usuario,cont);
					if(iniciado) {
						lblNewLabel.setVisible(true);
						lblNewLabel.setText("Sesion Iniciada");
						lblNewLabel.setForeground(new Color(0, 255, 0));
						usuarios[nJugadores] = usuario;
						nJugadores++;
						textField.setText("");
						passwordField.setText("");
						
					} else {
						
						lblNewLabel.setVisible(true);
						lblNewLabel.setText("Contrasena incorrectA. Intentalo de nuevo.");
						lblNewLabel.setForeground(new Color(255, 0, 0));
						passwordField.setText("");
					}
					
					if(nJugadores>= usuarios.length) {
						setVisible(false);
						Partida.getPartida().crearHumanos(usuarios);
					}
				}
			});
		
	}

	public void iniciarUsuarios(int jugadores) {
		nJugadores = 0;
		usuarios = new String[jugadores];
		setVisible(true);
		
	}

	public static IniciarSesion getIniciarSesion() {
		if(miIniciarSesion==null) {
			miIniciarSesion = new IniciarSesion();
		}
		return miIniciarSesion;
	}

	public void iniciar() {
		setVisible(true);
	}
}
