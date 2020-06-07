package packInterfaz;
import java.awt.EventQueue;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juegoProyecto.IaUsuario;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class Cartas extends JFrame{

	private static Cartas miCartas;
	private JPanel contentPane;
	private int cartasAElegir = 0;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_11;
	private JPanel panel_10;
	private JPanel panel_9;
	private JPanel panel_8;
	private JPanel panel_7;
	private JPanel panel_6;
	private JPanel panel_5;
	private JPanel panel_4;
	private JPanel panel_3;
	private JLabel label_12;
	private JLabel label_1;
	private JLabel label;
	private JLabel label_3;
	private JLabel label_2;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_10;
	private JLabel label_9;
	private JLabel label_8;
	private JLabel lblElijeCartas;
	private JLabel label_4;
	private JLabel label_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cartas frame = new Cartas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cartas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 11, 100, 150);
		contentPane.add(panel);
		
		label_12 = new JLabel("");
		label_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Color nuevoColor = devolverColor(panel.getForeground());
				panel.setForeground(nuevoColor);
			}
		});
		label_12.setBounds(5, 5, 90, 140);
		panel.add(label_12);
		
		lblElijeCartas = new JLabel("Elije Cartas");
		lblElijeCartas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblElijeCartas.setBounds(257, 186, 181, 32);
		contentPane.add(lblElijeCartas);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(124, 11, 100, 150);
		contentPane.add(panel_1);
		
		 label = new JLabel("");
		label_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Color nuevoColor = devolverColor(panel.getForeground());
				panel.setForeground(nuevoColor);
			}
		});
		label.setBounds(5, 5, 90, 140);
		panel_1.add(label);
		
	 panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(239, 11, 100, 150);
		contentPane.add(panel_2);
		
		 label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Color nuevoColor = devolverColor(panel.getForeground());
				panel_2.setForeground(nuevoColor);
			}
		});
		label_1.setBounds(5, 5, 90, 140);
		panel_2.add(label_1);
		
		 panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(351, 11, 100, 150);
		contentPane.add(panel_3);
		
		 label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Color nuevoColor = devolverColor(panel.getForeground());
				panel_3.setForeground(nuevoColor);
			}
		});
		label_2.setBounds(5, 5, 90, 140);
		panel_3.add(label_2);
		
		 panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.BLACK);
		panel_4.setBounds(462, 11, 100, 150);
		contentPane.add(panel_4);
		
		 label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Color nuevoColor = devolverColor(panel.getForeground());
				panel_4.setForeground(nuevoColor);
			}
		});
		label_3.setBounds(5, 5, 90, 140);
		panel_4.add(label_3);
		
		 panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.BLACK);
		panel_5.setBounds(574, 11, 100, 150);
		contentPane.add(panel_5);
		
		 label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Color nuevoColor = devolverColor(panel.getForeground());
				panel_5.setForeground(nuevoColor);
			}
		});
		label_4.setBounds(5, 5, 90, 140);
		panel_5.add(label_4);
		
		 panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.BLACK);
		panel_6.setBounds(10, 250, 100, 150);
		contentPane.add(panel_6);
		
		 label_5 = new JLabel("");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Color nuevoColor = devolverColor(panel.getForeground());
				panel_6.setForeground(nuevoColor);
			}
		});
		label_5.setBounds(5, 5, 90, 140);
		panel_6.add(label_5);
		
		 panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(Color.BLACK);
		panel_7.setBounds(124, 250, 100, 150);
		contentPane.add(panel_7);
		
		 label_6 = new JLabel("");
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Color nuevoColor = devolverColor(panel.getForeground());
				panel_7.setForeground(nuevoColor);
			}
		});
		label_6.setBounds(5, 5, 90, 140);
		panel_7.add(label_6);
		
		 panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(Color.BLACK);
		panel_8.setBounds(236, 250, 100, 150);
		contentPane.add(panel_8);
		
		 label_7 = new JLabel("");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Color nuevoColor = devolverColor(panel.getForeground());
				panel_8.setForeground(nuevoColor);
			}
		});
		label_7.setBounds(5, 5, 90, 140);
		panel_8.add(label_7);
		
		panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(Color.BLACK);
		panel_9.setBounds(350, 250, 100, 150);
		contentPane.add(panel_9);
		
		label_8 = new JLabel("");
		label_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Color nuevoColor = devolverColor(panel.getForeground());
				panel_9.setForeground(nuevoColor);
			}
		});
		label_8.setBounds(5, 5, 90, 140);
		panel_9.add(label_8);
		
		 panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(Color.BLACK);
		panel_10.setBounds(463, 250, 100, 150);
		contentPane.add(panel_10);
		
		 label_9 = new JLabel("");
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Color nuevoColor = devolverColor(panel.getForeground());
				panel_10.setForeground(nuevoColor);
			}
		});
		label_9.setBounds(5, 5, 90, 140);
		panel_10.add(label_9);
		
		panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBackground(Color.BLACK);
		panel_11.setBounds(574, 250, 100, 150);
		contentPane.add(panel_11);
		
		 label_10 = new JLabel("");
		label_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Color nuevoColor = devolverColor(panel.getForeground());
				panel_11.setForeground(nuevoColor);
			}
		});
		label_10.setBounds(5, 5, 90, 140);
		panel_11.add(label_10);
		
		panel.setForeground(Color.red);
		panel_1.setForeground(Color.red);
		panel_2.setForeground(Color.red);
		panel_3.setForeground(Color.red);
		panel_4.setForeground(Color.red);
		panel_5.setForeground(Color.red);
		panel_6.setForeground(Color.red);
		panel_7.setForeground(Color.red);
		panel_8.setForeground(Color.red);
		panel_9.setForeground(Color.red);
		panel_10.setForeground(Color.red);
		panel_11.setForeground(Color.red);
		
		JButton btnNewButton = new JButton("Elegir");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(eleccionCorrecta()) {
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(413, 187, 138, 37);
		contentPane.add(btnNewButton);
	}
	public boolean eleccionCorrecta() {
		int j = 0;
		if(panel.getForeground() == Color.green) {
			j++;
		}
		if(panel_1.getForeground() == Color.green) {
			j++;
		}
		if(panel_2.getForeground() == Color.green) {
			j++;
		}
		if(panel_3.getForeground() == Color.green) {
			j++;
		}
		if(panel_4.getForeground() == Color.green) {
			j++;
		}
		if(panel_5.getForeground() == Color.green) {
			j++;
		}
		if(panel_6.getForeground() == Color.green) {
			j++;
		}
		if(panel_7.getForeground() == Color.green) {
			j++;
		}
		if(panel_8.getForeground() == Color.green) {
			j++;
		}
		if(panel_9.getForeground() == Color.green) {
			j++;
		}
		if(panel_10.getForeground() == Color.green) {
			j++;
		}
		if(panel_11.getForeground() == Color.green) {
			j++;
		}
		if(j==cartasAElegir) {
			return true;
		}
		else {
			return false;
		}
		
	}
	public static Cartas getCartas() {
		if(miCartas==null) {
			miCartas = new Cartas();
		}
		return miCartas;
	}
	private Color devolverColor(Color color) {
		if(color == Color.red) {
			color = Color.green;
		}
		return color;
	}

	public void elegir(int i) {
		setVisible(true);
		cartasAElegir  = i;
		lblElijeCartas.setText("Elije " + i + " cartas");
		panel.setForeground(Color.red);
		panel_1.setForeground(Color.red);
		panel_2.setForeground(Color.red);
		panel_3.setForeground(Color.red);
		panel_4.setForeground(Color.red);
		panel_5.setForeground(Color.red);
		panel_6.setForeground(Color.red);
		panel_7.setForeground(Color.red);
		panel_8.setForeground(Color.red);
		panel_9.setForeground(Color.red);
		panel_10.setForeground(Color.red);
		panel_11.setForeground(Color.red);
	}
}
