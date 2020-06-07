package packInterfaz;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import juegoProyecto.Cola;
import juegoProyecto.Partida;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTextArea;

public class VentanaJuego extends JFrame implements java.util.Observer {

	private JPanel contentPane;
	private JPanel mano1;
	private JPanel mano2;
	private JPanel mano3;
	private JPanel mano4;
	private JPanel cola1;
	private JPanel cola2;
	private JPanel cola3;
	private JPanel cola4;
	private JPanel cola5;
	private JLabel cartaMano1;
	private JLabel cartaMano2;
	private JLabel cartaMano3;
	private JLabel cartaMano4;
	private JLabel cartaCola1;
	private JLabel cartaCola2;
	private JLabel cartaCola3;
	private JLabel cartaCola4;
	private JLabel cartaCola5;
	private JPanel panelSalto;
	private JLabel nombreJug;
	private JLabel texto;
	private boolean botonesCartasActivados;
	private boolean botonesCartasCola;

	private static VentanaJuego miJuego;
	private JLabel lblNewLabel;
	private JLabel cartaDesc;
	private JLabel lblDescripcion;
	private JTextArea desc;

	private VentanaJuego() {
		Partida.getPartida().addObserver(this);
		Cola.getCola().addObserver(this);
		setVisible(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1213, 694);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		botonesCartasActivados = false;
		botonesCartasCola = false;

		mano2 = new JPanel();
		mano2.setLayout(null);
		mano2.setBackground(Color.RED);
		mano2.setBounds(592, 450, 100, 150);
		contentPane.add(mano2);

		cartaMano2 = new JLabel("");
		cartaMano2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (botonesCartasActivados) {
					botonesCartasActivados = false;
					int decision = 2;
					decision = convertirDec(decision);
					Partida.getPartida().turnoJugador(decision);
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setDescripcion((ImageIcon) cartaMano2.getIcon());
			}
		});
		cartaMano2.setBounds(5, 5, 90, 140);
		mano2.add(cartaMano2);

		mano3 = new JPanel();
		mano3.setLayout(null);
		mano3.setBackground(Color.RED);
		mano3.setBounds(742, 450, 100, 150);
		contentPane.add(mano3);

		cartaMano3 = new JLabel("");
		cartaMano3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (botonesCartasActivados) {
					botonesCartasActivados = false;
					int decision = 3;
					decision = convertirDec(decision);
					Partida.getPartida().turnoJugador(decision);
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setDescripcion((ImageIcon) cartaMano3.getIcon());
			}
		});
		cartaMano3.setBounds(5, 5, 90, 140);
		mano3.add(cartaMano3);

		mano4 = new JPanel();
		mano4.setLayout(null);
		mano4.setBackground(Color.RED);
		mano4.setBounds(892, 450, 100, 150);
		contentPane.add(mano4);

		cartaMano4 = new JLabel("");
		cartaMano4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (botonesCartasActivados) {
					botonesCartasActivados = false;
					int decision = 4;
					decision = convertirDec(decision);
					Partida.getPartida().turnoJugador(decision);
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setDescripcion((ImageIcon) cartaMano4.getIcon());
			}
		});
		cartaMano4.setBounds(5, 5, 90, 140);
		mano4.add(cartaMano4);

		cola1 = new JPanel();
		cola1.setLayout(null);
		cola1.setBackground(Color.WHITE);
		cola1.setBounds(417, 200, 100, 150);
		contentPane.add(cola1);

		cartaCola1 = new JLabel("");
		cartaCola1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (botonesCartasCola) {
					if (cartaCola1.isEnabled()) {
						botonesCartasCola = false;
						int ind = 1;
						Partida.getPartida().animaladaI(ind);
					}
				}
			}
		});
		cartaCola1.setBounds(5, 5, 90, 140);
		cola1.add(cartaCola1);

		cola2 = new JPanel();
		cola2.setLayout(null);
		cola2.setBackground(Color.WHITE);
		cola2.setBounds(542, 200, 100, 150);
		contentPane.add(cola2);

		cartaCola2 = new JLabel("");
		cartaCola2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (botonesCartasCola) {
					if (cartaCola2.isEnabled()) {
						botonesCartasCola = false;
						int ind = 2;
						Partida.getPartida().animaladaI(ind);
					}
				}
			}
		});
		cartaCola2.setBounds(5, 5, 90, 140);
		cola2.add(cartaCola2);

		cola3 = new JPanel();
		cola3.setLayout(null);
		cola3.setBackground(Color.WHITE);
		cola3.setBounds(667, 200, 100, 150);
		contentPane.add(cola3);

		cartaCola3 = new JLabel("");
		cartaCola3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (botonesCartasCola) {
					if (cartaCola3.isEnabled()) {
						botonesCartasCola = false;
						int ind = 3;
						Partida.getPartida().animaladaI(ind);
					}
				}
			}
		});
		cartaCola3.setBounds(5, 5, 90, 140);
		cola3.add(cartaCola3);

		cola4 = new JPanel();
		cola4.setLayout(null);
		cola4.setBackground(Color.WHITE);
		cola4.setBounds(792, 200, 100, 150);
		contentPane.add(cola4);

		cartaCola4 = new JLabel("");
		cartaCola4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (botonesCartasCola) {
					if (cartaCola4.isEnabled()) {
						botonesCartasCola = false;
						int ind = 4;
						Partida.getPartida().animaladaI(ind);
					}
				}
			}
		});
		cartaCola4.setBounds(5, 5, 90, 140);
		cola4.add(cartaCola4);

		cola5 = new JPanel();
		cola5.setLayout(null);
		cola5.setBackground(Color.WHITE);
		cola5.setBounds(917, 200, 100, 150);
		contentPane.add(cola5);

		cartaCola5 = new JLabel("");
		cartaCola5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (botonesCartasCola) {
					if (cartaCola5.isEnabled()) {
						botonesCartasCola = false;
						int ind = 5;
						Partida.getPartida().animaladaI(ind);
					}
				}
			}
		});
		cartaCola5.setBounds(5, 5, 90, 140);
		cola5.add(cartaCola5);

		cartaCola1.setIcon(new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Patada.png")));
		cartaCola2.setIcon(new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Patada.png")));
		cartaCola3.setIcon(new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Patada.png")));
		cartaCola4.setIcon(new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Patada.png")));
		cartaCola5.setIcon(new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Patada.png")));

		JPanel mazo = new JPanel();
		mazo.setLayout(null);
		mazo.setBackground(Color.BLACK);
		mazo.setBounds(1042, 500, 100, 150);
		contentPane.add(mazo);

		JLabel mazoCarta = new JLabel("");
		mazoCarta.setBounds(5, 5, 90, 140);
		mazo.add(mazoCarta);
		mazoCarta.setIcon(new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/mazo.jpg")));


		JPanel entradaFuera = new JPanel();
		entradaFuera.setLayout(null);
		entradaFuera.setBackground(Color.black);
		entradaFuera.setBounds(1042, 200, 100, 150);
		contentPane.add(entradaFuera);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Fuera.png")));
		label_2.setBounds(5, 5, 90, 140);
		entradaFuera.add(label_2);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBackground(Color.ORANGE);
		panel.setBounds(10, 324, 280, 320);
		contentPane.add(panel);
		panel.setLayout(null);
		
		cartaDesc = new JLabel("");
		cartaDesc.setBounds(86, 11, 90, 140);
		panel.add(cartaDesc);
		
		lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDescripcion.setBounds(70, 157, 144, 28);
		panel.add(lblDescripcion);
		
		desc = new JTextArea("");
		desc.setLineWrap(true);
		desc.setRows(5);
		desc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		desc.setBounds(10, 194, 260, 115);
		desc.setWrapStyleWord(true);
		panel.add(desc);

		JPanel bar = new JPanel();
		bar.setLayout(null);
		bar.setBackground(Color.black);
		bar.setBounds(292, 25, 100, 150);
		contentPane.add(bar);

		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/GorilaSegurata.png")));
		label_8.setBounds(5, 5, 90, 140);
		bar.add(label_8);
		
				mano1 = new JPanel();
				mano1.setBackground(Color.RED);
				mano1.setBounds(442, 450, 100, 150);
				contentPane.add(mano1);
				mano1.setLayout(null);
				
						cartaMano1 = new JLabel("");
						cartaMano1.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								if (botonesCartasActivados) {
									botonesCartasActivados = false;
									int decision = 1;
									decision = convertirDec(decision);
									Partida.getPartida().turnoJugador(decision);
								}
							}
							@Override
							public void mouseEntered(MouseEvent arg0) {
								setDescripcion((ImageIcon) cartaMano1.getIcon());
							}
							
						});
						cartaMano1.setBounds(5, 5, 90, 140);
						mano1.add(cartaMano1);

		JPanel patada = new JPanel();
		patada.setLayout(null);
		patada.setBackground(Color.black);
		patada.setBounds(1042, 25, 100, 150);
		contentPane.add(patada);

		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/patada.png")));
		label_9.setBounds(5, 5, 90, 140);
		patada.add(label_9);

		JLabel lblBarBestial = new JLabel("Bar Bestial");
		lblBarBestial.setForeground(Color.YELLOW);
		lblBarBestial.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblBarBestial.setBounds(579, 11, 355, 77);
		contentPane.add(lblBarBestial);

		JPanel entradaBar = new JPanel();
		entradaBar.setLayout(null);
		entradaBar.setBackground(Color.black);
		entradaBar.setBounds(292, 200, 100, 150);
		contentPane.add(entradaBar);

		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Bar.png")));
		label_10.setBounds(5, 5, 90, 140);
		entradaBar.add(label_10);

		nombreJug = new JLabel("");
		nombreJug.setForeground(Color.YELLOW);
		nombreJug.setHorizontalAlignment(SwingConstants.CENTER);
		nombreJug.setFont(new Font("Tahoma", Font.PLAIN, 22));
		nombreJug.setBounds(877, 373, 314, 67);
		contentPane.add(nombreJug);

		panelSalto = new JPanel();
		panelSalto.setBackground(Color.ORANGE);
		panelSalto.setForeground(Color.ORANGE);
		panelSalto.setBounds(594, 86, 220, 103);
		contentPane.add(panelSalto);
		panelSalto.setLayout(null);

		panelSalto.setVisible(false);

		JLabel lblCuantasCasillasVas = new JLabel("\u00BFCuantas casillas vas a saltar?");
		lblCuantasCasillasVas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuantasCasillasVas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCuantasCasillasVas.setBounds(10, 11, 200, 24);
		panelSalto.add(lblCuantasCasillasVas);

		JButton una = new JButton("1");
		una.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int salto = 1;
				panelSalto.setVisible(false);
				Partida.getPartida().animaladaI(salto);
			}
		});
		una.setFont(new Font("Tahoma", Font.PLAIN, 16));
		una.setBounds(20, 32, 60, 60);
		panelSalto.add(una);

		JButton dos = new JButton("2");
		dos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int salto = 2;
				panelSalto.setVisible(false);

				Partida.getPartida().animaladaI(salto);
			}
		});
		dos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dos.setBounds(137, 32, 60, 60);
		panelSalto.add(dos);

		texto = new JLabel("New label");
		texto.setForeground(Color.YELLOW);
		texto.setFont(new Font("Tahoma", Font.PLAIN, 22));
		texto.setHorizontalAlignment(SwingConstants.CENTER);
		texto.setBounds(534, 361, 372, 66);
		contentPane.add(texto);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1197, 655);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/tablero.jpg")));
		panelSalto.setVisible(false);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize(); // Tamaño del frame actual (ancho x alto)
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		setLocation((screenSize.width - frameSize.width), (screenSize.height - frameSize.height));
	}

	public Color devolverColor(String color) {
		Color c = null;
		if (color.equals("rojo")) {
			return Color.red;
		} else if (color.equals("azul")) {
			return Color.blue;
		} else if (color.equals("verde")) {
			return Color.green;
		} else if (color.equals("amarillo")) {
			return Color.yellow;
		} else if (color.equals("rosa")) {
			return Color.pink;
		} else if (color.equals("naranja")) {
			return Color.orange;
		} else if (color.equals("grisclaro")) {
			return Color.lightGray;
		} else if (color.equals("grisoscuro")) {
			return Color.darkGray;
		}else if (color.equals("gris")) {
			return Color.gray;
		}else if (color.equals("cyan")) {
			return Color.cyan;
		}else if (color.equals("magenta")) {
			return Color.magenta;
		}else if (color.equals("negro")) {
			return Color.black;
		}else {
			return c;

		}
	}
	private void setDescripcion(ImageIcon icon) {
		cartaDesc.setIcon(icon);
		String s = obtenerInformacion(icon);
		if(s!=null) {
			desc.setText(s);
		}
		
	}

	private String obtenerInformacion(ImageIcon icon) {
		String des = null; 
		if(icon.getDescription().toString().equals(new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Mofeta.png")).getDescription().toString())) {
			des = "Elimina todas las cartas con las dos fuerzas mas grandes en la cola";
		} else if(icon.getDescription().toString().equals(new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Loro.png")).getDescription().toString())) {
			des = "Elimina la carta de la cola a tu eleccion";
		} else if(icon.getDescription().toString().equals(new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Canguro.png")).getDescription().toString())) {
			des = "Se coloca el ultimo en la cola. Pero dara un salto de 1 o 2 casillas. Tu lo eliges";
		} else if(icon.getDescription().toString().equals(new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Mono.png")).getDescription().toString())) {
			des = "Elimina todos los hipopotamos y cocodrilos que haya en la cola. Despues todos los monos avanzan a la primera posicion";	
		} else if(icon.getDescription().toString().equals(new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Camaleon.png")).getDescription().toString())) {
			des = "Se convierte en el animal de la cola a tu eleccion y ejecutara su efecto";
		} else if(icon.getDescription().toString().equals(new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Foca.png")).getDescription().toString())) {
			des = "Invierte el orden de la cola. Colocandose asi el primero";
		} else if(icon.getDescription().toString().equals(new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Cebra.png")).getDescription().toString())) {
			des = "Su efecto es permanente. No puede ser adelantado por ningun cocodrilo ni hipopotamo";
		} else if(icon.getDescription().toString().equals(new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Jirafa.png")).getDescription().toString())) {
			des = "Al finalizar el turno de cada jugador, la jirafa adelanta una posicion siempre que su fierza sea menor que 8";
		} else if(icon.getDescription().toString().equals(new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Serpiente.png")).getDescription().toString())) {
			des = "Ordena las cartas que hay en la cola por fuerza";
		} else if(icon.getDescription().toString().equals(new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Cocodrilo.png")).getDescription().toString())) {
			des = "Su efecto es permanente. Se come todas las cartas delante de ella que su fuerza sea menor que 10.";
		} else if(icon.getDescription().toString().equals(new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Hipopotamo.png")).getDescription().toString())) {
			des = "Su efecto es permanente. Adelanta todas las cartas delante de ella que su fuerza sea menor que 11.";
		} else if(icon.getDescription().toString().equals(new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Leon.png")).getDescription().toString())) {
			des = "Si hay otro Leon en juego se va directamente Fuera. Si no hay leones en la cola, este se coloca el primero y elimina todos los monos que haya en la cola";
		}
		int i = 0;
		String s = "";
		while(i<des.length()) {
			if(i+24<des.length()) {
				s = s + des.substring(i, i+24) + " \n ";
			}
			else {
				s = s + des.substring(i, des.length()-1);
			}
			i = i + 24;
		}
		return des;
	}

	public static VentanaJuego getVentanaJuego() {
		if (miJuego == null) {
			miJuego = new VentanaJuego();
		}
		return miJuego;
	}

	public void habilitarSalto() {
		panelSalto.setVisible(true);
		texto.setText("Elige el salto que deseas dar");

	}

	public Icon getImagenAnimal(String animal) {
		Icon icono = null;
		if (animal.equals("camaleon")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Camaleon.png"));
		} else if (animal.equals("canguro")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Canguro.png"));
		} else if (animal.equals("cebra")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Cebra.png"));
		} else if (animal.equals("cocodrilo")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Cocodrilo.png"));
		} else if (animal.equals("foca")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Foca.png"));
		} else if (animal.equals("hipopotamo")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Hipopotamo.png"));
		} else if (animal.equals("jirafa")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Jirafa.png"));
		} else if (animal.equals("leon")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Leon.png"));
		} else if (animal.equals("loro")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Loro.png"));
		} else if (animal.equals("mofeta")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Mofeta.png"));
		} else if (animal.equals("mono")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Mono.png"));
		} else if (animal.equals("serpiente")) {
			icono = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Serpiente.png"));
		}
		return icono;
	}

	public void imprimirListaCartasCola(String[] n) {
		int size = (n.length - 1) / 2;
		Icon icono = null;
		Color color = null;
		cartaCola1.setEnabled(false);
		cartaCola2.setEnabled(false);
		cartaCola3.setEnabled(false);
		cartaCola4.setEnabled(false);
		cartaCola5.setEnabled(false);
		if (size > 0) {
			icono = getImagenAnimal(n[1]);
			color = devolverColor(n[2]);
			cartaCola1.setIcon(icono);
			cola1.setBackground(color);
			cartaCola1.setEnabled(true);
			if (size > 1) {
				icono = getImagenAnimal(n[3]);
				color = devolverColor(n[4]);
				cartaCola2.setIcon(icono);
				cola2.setBackground(color);
				cartaCola2.setEnabled(true);

				if (size > 2) {
					icono = getImagenAnimal(n[5]);
					color = devolverColor(n[6]);
					cartaCola3.setIcon(icono);
					cola3.setBackground(color);
					cartaCola3.setEnabled(true);
					if (size > 3) {
						icono = getImagenAnimal(n[7]);
						color = devolverColor(n[8]);
						cartaCola4.setIcon(icono);
						cola4.setBackground(color);
						cartaCola4.setEnabled(true);
						if (size > 4) {
							icono = getImagenAnimal(n[9]);
							color = devolverColor(n[10]);
							cartaCola5.setIcon(icono);
							cola5.setBackground(color);
							cartaCola5.setEnabled(true);
						} else {
							vaciarCola(1);
						}
					} else {
						vaciarCola(2);
					}
				} else {
					vaciarCola(3);
				}
			} else {
				vaciarCola(4);
			}
		} else {
			vaciarCola(5);
		}
	}
	public int convertirDec(int i) {
		
		return i;
	}

	public void vaciarCola(int ind) {
		Icon iconoDetras = new ImageIcon(VentanaJuego.class.getResource("/packInterfaz/Patada.png"));// ("/packInterfaz/Detras.png"));
		if (ind > 0) {
			cartaCola5.setIcon(iconoDetras);
			cola5.setBackground(Color.WHITE);
			if (ind > 1) {
				cartaCola4.setIcon(iconoDetras);
				cola4.setBackground(Color.WHITE);
				if (ind > 2) {
					cartaCola3.setIcon(iconoDetras);
					cola3.setBackground(Color.WHITE);
					if (ind > 3) {
						cartaCola2.setIcon(iconoDetras);
						cola2.setBackground(Color.WHITE);
						if (ind > 4) {
							cartaCola1.setIcon(iconoDetras);
							cola1.setBackground(Color.WHITE);
						}
					}
				}
			}
		}
	}

	public void imprimirListaCartasJugador(String[] n) {
		String color = n[2];
		Color c = (devolverColor(color));
		int cantCartas = (n.length) - 3;
		nombreJug.setText(n[1]);
		nombreJug.setVisible(true);
		if (cantCartas == 4) {
			mano1.setBackground(c);
			mano2.setBackground(c);
			mano3.setBackground(c);
			mano4.setBackground(c);
			cartaMano1.setIcon(getImagenAnimal(n[3]));
			cartaMano2.setIcon(getImagenAnimal(n[4]));
			cartaMano3.setIcon(getImagenAnimal(n[5]));
			cartaMano4.setIcon(getImagenAnimal(n[6]));
		} else if (cantCartas == 3) {
			mano1.setBackground(c);
			mano2.setBackground(c);
			mano3.setBackground(c);
			mano4.setBackground(Color.WHITE);
			cartaMano1.setIcon(getImagenAnimal(n[3]));
			cartaMano2.setIcon(getImagenAnimal(n[4]));
			cartaMano3.setIcon(getImagenAnimal(n[5]));
			cartaMano4.setIcon(new ImageIcon());
		} else if (cantCartas == 2) {
			mano1.setBackground(Color.WHITE);
			mano2.setBackground(c);
			mano3.setBackground(c);
			mano4.setBackground(Color.WHITE);
			cartaMano1.setIcon(new ImageIcon());
			cartaMano2.setIcon(getImagenAnimal(n[3]));
			cartaMano3.setIcon(getImagenAnimal(n[4]));
			cartaMano4.setIcon(new ImageIcon());

		} else if (cantCartas == 1) {
			mano1.setBackground(Color.WHITE);
			mano2.setBackground(c);
			mano3.setBackground(Color.WHITE);
			mano4.setBackground(Color.WHITE);
			cartaMano1.setIcon(new ImageIcon());
			cartaMano2.setIcon(getImagenAnimal(n[3]));
			cartaMano3.setIcon(new ImageIcon());
			cartaMano4.setIcon(new ImageIcon());

		}
	}

	@Override
	public void update(Observable o, Object datos) {
		setVisible(true);
		String[] partes = ((String) datos).split(" ");
		if (partes[0].equals("cola")) {
			imprimirListaCartasCola(partes);
		} else if (partes[0].equals("jugador")) {
			botonesCartasActivados = true;
			texto.setText("Elige una carta");
			imprimirListaCartasJugador(partes);
		} else if (partes[0].equals("bot")) {
			botonesCartasActivados = false;
			botonesCartasCola = false;
			imprimirListaCartasJugador(partes);
			Partida.getPartida().juegaBot();
		} else if (partes[0].equals("eleccion")) {
			if (partes[1].equals("salto")) {
				texto.setText("Elige si deseas saltar uno o dos animales");
				panelSalto.setVisible(true);
				botonesCartasActivados = false;

			} else {
				texto.setText("Elige una carta de la cola");
				botonesCartasCola = true;
				botonesCartasActivados = false;

			}
		} else if (partes[0].equals("fin")) {
			botonesCartasActivados = false;
			botonesCartasCola = false;

			Partida.getPartida().finalizarPartida();
		}
		FinTurno.getFinTurno().toFront();
	}
}