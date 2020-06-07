package packInterfaz;

import java.awt.Color;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juegoProyecto.Partida;

import javax.swing.JLabel;
import java.awt.Font;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RankGanador extends JFrame implements Observer{

	private static RankGanador miRankingGanador;
	private JPanel contentPane;
	private JList<String> list;
	private String[] values = new String[1];
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	private RankGanador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Menu");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Partida.getPartida().iniciarInterfazPortada();
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(391, 11, 77, 23);
		contentPane.add(btnNewButton);

		
		JLabel lblRankingpartida = new JLabel("Puntuaciones Partida");
		lblRankingpartida.setFont(new Font("Stencil", Font.PLAIN, 26));
		lblRankingpartida.setForeground(Color.white);
		lblRankingpartida.setBounds(72, 0, 384, 80);
		contentPane.add(lblRankingpartida);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 458, 373);
		contentPane.add(scrollPane);
		
		list = new JList<String>();
		scrollPane.setViewportView(list);
		list.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RankGanador.class.getResource("/packInterfaz/rank.jpg")));
		lblNewLabel.setBounds(0, 0, 478, 457);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		String[] partes = ((String) arg1).split(" ");
		if(partes[0].equals("ganador")) {
			VentanaJuego.getVentanaJuego().setVisible(false);
			setVisible(true);
			setValues(partes);
		}
		
	}
	public void ganadores(String arg1) {
		String[] partes = ((String) arg1).split(" ");
		if(partes[0].equals("ganador")) {
			VentanaJuego.getVentanaJuego().setVisible(false);
			setVisible(true);
			setValues(partes);
		}
	}

	private void setValues(String[] partes) {
		values = new String[partes.length];
		values[0] = "Usuario  CartasMetidas   PuntosObtenidos";
		for(int i = 1; i<partes.length-2; i=i+3) {
			String sNombre= partes[i];
			String p1 = partes[i+1]; //Nombre
			String p2 = partes[i+2]; //Nombre
			String s= sNombre;
			while(s.length()<18) {
				s = s + " ";
			}
			s = s + p1;
			while(s.length()<39) {
				s = s + " ";
			}
			s = s + p2;
			values[i]= s;

		}
		actualizarLista();
		setVisible(true);
	}

	private void actualizarLista() {
		list.setModel(new AbstractListModel<String>() {
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});		
	}

	public static RankGanador getRankingGanador() {
		if(miRankingGanador==null) {
			miRankingGanador = new RankGanador();
		}
		return miRankingGanador;
	}
}
