package packInterfaz;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juegoProyecto.Fichero;
import juegoProyecto.Partida;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;

public class VentanaPortada extends JFrame{
	private static VentanaPortada miPortada;
	private JPanel contentPane;

	private VentanaPortada() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 493);
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
		
		JButton BotonIniciarJuego = new JButton("Jugar Partida");
		BotonIniciarJuego.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				Fichero.getFichero().cargarJugadoresDesdeFichero();
				Partida.getPartida().iniciarInterfazConfig();
			}
		});
		BotonIniciarJuego.setBounds(50, 220, 170, 25);
		contentPane.add(BotonIniciarJuego);
		
		JButton BotonSalir = new JButton("Salir");
		BotonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		BotonSalir.setBounds(50, 290, 170, 25);
		contentPane.add(BotonSalir);
		
		JButton BotonRanking = new JButton("Visualizar Ranking");
		BotonRanking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RankingPartida.getRankingPartida().verRanking();
			}
		});
		BotonRanking.setBounds(50, 254, 170, 25);
		contentPane.add(BotonRanking);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(5, 0, 445, 456);
		lblNewLabel.setIcon(new ImageIcon(VentanaPortada.class.getResource("/packInterfaz/portada.jpg")));
		contentPane.add(lblNewLabel);
		
		//Cargamos la lista de jugadores
		Fichero.getFichero().cargarJugadoresDesdeFichero();
	}
	public static VentanaPortada getVentanaPortada() {
		if(miPortada==null) {
			miPortada = new VentanaPortada();
		}
		return miPortada;
	}
	public void iniciar() {
		setVisible(true);		
	}
}
