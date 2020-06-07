package packInterfaz;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juegoProyecto.Partida;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class FinTurno extends JDialog implements Observer{
	private static FinTurno miFinTurno;
	private JPanel panelLlena;
	private final JPanel contentPanel = new JPanel();
	private JLabel cartaJ;
	private JPanel colorJ;
	private JLabel cartaBar1;
	private JPanel colorB1;
	private JLabel cartaBar2;
	private JLabel cartaFuera;
	private JPanel colorF;
	private JPanel colorB2;


	private FinTurno() {
		setBounds(100, 100, 581, 298);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setVisible(false);
		
		Partida.getPartida().addObserver(this);
		
		JButton BotonTurno = new JButton("Pasar Turno");
		BotonTurno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				Partida.getPartida().cambiarTurno();
			}
		});
		BotonTurno.setBounds(211, 216, 138, 32);
		contentPanel.add(BotonTurno);
		
		JLabel lblElJugadorActual = new JLabel("El jugador actual ha jugado:");
		lblElJugadorActual.setForeground(Color.WHITE);
		lblElJugadorActual.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblElJugadorActual.setBounds(10, 11, 208, 37);
		contentPanel.add(lblElJugadorActual);
		
		colorJ = new JPanel();
		colorJ.setLayout(null);
		colorJ.setBackground(Color.WHITE);
		colorJ.setBounds(31, 47, 100, 150);
		contentPanel.add(colorJ);
		
		cartaJ = new JLabel("");
		cartaJ.setBounds(5, 5, 90, 140);
		colorJ.add(cartaJ);
		
		panelLlena = new JPanel();
		panelLlena.setBounds(162, 11, 403, 202);
		contentPanel.add(panelLlena);
		panelLlena.setLayout(null);
		
		JLabel lblHanRecibidoUna = new JLabel("Han recibido una patada:");
		lblHanRecibidoUna.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHanRecibidoUna.setForeground(Color.WHITE);
		lblHanRecibidoUna.setBounds(239, 8, 164, 27);
		panelLlena.add(lblHanRecibidoUna);
		
		colorB2 = new JPanel();
		colorB2.setBounds(130, 33, 100, 150);
		colorB2.setLayout(null);
		colorB2.setBackground(Color.WHITE);
		panelLlena.add(colorB2);

		
		cartaBar2 = new JLabel("");
		cartaBar2.setBounds(5, 5, 90, 140);
		colorB2.add(cartaBar2);
		
		colorF = new JPanel();
		colorF.setBounds(275, 33, 100, 150);
		colorF.setLayout(null);
		colorF.setBackground(Color.WHITE);
		panelLlena.add(colorF);

		
		cartaFuera = new JLabel("");
		cartaFuera.setBounds(5, 5, 90, 140);
		colorF.add(cartaFuera);
		
		colorB1 = new JPanel();
		colorB1.setBounds(15, 33, 100, 150);
		panelLlena.add(colorB1);
		colorB1.setLayout(null);
		colorB1.setBackground(Color.WHITE);
		
		cartaBar1 = new JLabel("");
		cartaBar1.setBounds(5, 5, 90, 140);
		colorB1.add(cartaBar1);
		
		JLabel lblAlBarHan = new JLabel("Al Bar han entrado:");
		lblAlBarHan.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAlBarHan.setForeground(Color.WHITE);
		lblAlBarHan.setBounds(39, 0, 190, 27);
		panelLlena.add(lblAlBarHan);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FinTurno.class.getResource("/packInterfaz/rank.jpg")));
		label.setBounds(-162, -12, 565, 260);
		panelLlena.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FinTurno.class.getResource("/packInterfaz/rank.jpg")));
		lblNewLabel.setBounds(0, 0, 565, 259);
		contentPanel.add(lblNewLabel);
	}

	@Override
	public void update(Observable o, Object datos) {
		String[] partes = ((String) datos).split(" ");
		if(partes[0].equals("turnofinalizado")) {
			if(partes!=null) {
				setVisible(true);
				setImagenes(partes);
				panelLlena.setVisible(true);
				this.toFront();
				setLocation(0,0);
			}
		}
	}
	public Icon getImagenAnimal(String animal) {
		Icon icono = null;
		if(animal.equals("camaleon")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Camaleon.png"));
		} else if(animal.equals("canguro")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Canguro.png"));
		} else if(animal.equals("cebra")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Cebra.png"));
		} else if(animal.equals("cocodrilo")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Cocodrilo.png"));
		} else if(animal.equals("foca")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Foca.png"));
		} else if(animal.equals("hipopotamo")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Hipopotamo.png"));
		} else if(animal.equals("jirafa")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Jirafa.png"));
		} else if(animal.equals("leon")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Leon.png"));
		} else if(animal.equals("loro")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Loro.png"));
		} else if(animal.equals("mofeta")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Mofeta.png"));
		} else if(animal.equals("mono")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Mono.png"));
		} else if(animal.equals("serpiente")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Serpiente.png"));
		}
		return icono;
	}
	public Color devolverColor(String color) {
		Color c = null;
		if(color.equals("rojo")) {
			 return Color.red;
		}
		else if(color.equals("azul")) {
			return Color.blue;
		}
		else if(color.equals("verde")) {
			return Color.green;
		}
		else if(color.equals("amarillo")) {
			return Color.yellow;
		}
		else if(color.equals("rosa")) {
			return Color.pink;
		} //Podriamos seguir
		else if(color.equals("naranja")) {
			return Color.orange;
		}
		else if(color.equals("gris")) {
			return Color.gray;
		}
		else if(color.equals("negro")) {
			return Color.black;
		} else {
			return c;	

		}
	}
	private void setImagenes(String[] n) {
		Icon icono = null;
		Color color = null;
		icono = getImagenAnimal(n[1]);
		color = devolverColor(n[2]);
		cartaJ.setIcon(icono);
		colorJ.setBackground(color);
		if(n[3].equals("llena")) {
			icono = getImagenAnimal(n[4]);
			color = devolverColor(n[5]);
			cartaBar1.setIcon(icono);
			colorB1.setBackground(color);
			icono = getImagenAnimal(n[6]);
			color = devolverColor(n[7]);
			cartaBar2.setIcon(icono);
			colorB2.setBackground(color);
			icono = getImagenAnimal(n[8]);
			color = devolverColor(n[9]);
			cartaFuera.setIcon(icono);
			colorF.setBackground(color);	
		}
		else {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Patada.png"));
			color = devolverColor("negro");
			cartaBar1.setIcon(icono);
			colorB1.setBackground(color);
			cartaBar2.setIcon(icono);
			colorB2.setBackground(color);
			cartaFuera.setIcon(icono);
			colorF.setBackground(color);	
		}
	}

	public static FinTurno getFinTurno() {
		if(miFinTurno==null) {
			miFinTurno = new FinTurno();
		}
		return miFinTurno;		
	}
}
