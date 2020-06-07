package packInterfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import juegoProyecto.ListaJugadores;

import javax.swing.JLabel;
import java.awt.Font;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class RankingPartida extends JFrame implements Observer{

	private static RankingPartida miRankingPartida;
	private JPanel contentPane;
	private JList<String> list;
	private String[] values = new String[1];
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	private RankingPartida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JLabel lblRankingpartida = new JLabel("RankingPartida");
		lblRankingpartida.setFont(new Font("Stencil", Font.PLAIN, 26));
		lblRankingpartida.setForeground(Color.white);
		lblRankingpartida.setBounds(44, 0, 245, 80);
		contentPane.add(lblRankingpartida);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 458, 373);
		contentPane.add(scrollPane);
		
		list = new JList<String>();
		scrollPane.setViewportView(list);
		list.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verRanking();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Partidas Ganadas", "Nombre A-Z", "Puntuacion", "Tasa de Victorias"}));
		comboBox.setBounds(299, 37, 146, 25);
		contentPane.add(comboBox);
		
		JLabel lblOrdenarPor = new JLabel("Ordenar por:");
		lblOrdenarPor.setBounds(299, 15, 86, 14);
		contentPane.add(lblOrdenarPor);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RankingPartida.class.getResource("/packInterfaz/rank.jpg")));
		lblNewLabel.setBounds(0, 0, 478, 457);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		String[] partes = ((String) arg1).split(" ");
		if(partes[0].equals("ranking")) {
			setVisible(true);
			setValues(partes);
		}
		
	}

	private void setValues(String[] partes) {
		values = new String[partes.length-1];
		for(int i = 0; i<=partes.length-2; i++) {
			String s1 = partes[i+1];
			String[] l = s1.split(" ");
			String s2 = l[0]; //Nombre
			if(comboBox.getSelectedItem().equals("Partidas Ganadas")) {
				s2= s2+ " "+ l[1];
				values[i]= s2;

			} else if(comboBox.getSelectedItem().equals("Nombre A-Z")) {
				values[i]= partes[i+1];

			} else if(comboBox.getSelectedItem().equals("Puntuacion")) {
				s2= s2+ " "+ l[3]+ " " + l[4];
				values[i]= s2;
			} else if(comboBox.getSelectedItem().equals("Tasa de Victorias")) {
				if(l[2].equals("0")) {
					s2= s2+ " "+ "0.0";
					values[i]= s2;
				} else {
					s2= s2+ " "+ (Double.parseDouble(l[1])/Double.parseDouble(l[2]));
					values[i]= s2;
				}
			}
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

	public static RankingPartida getRankingPartida() {
		if(miRankingPartida==null) {
			miRankingPartida = new RankingPartida();
		}
		return miRankingPartida;
	}

	public void verRanking() {
		setValues(ListaJugadores.getListaJugadores().getPuntuaciones(comboBox.getSelectedItem().toString()));
	}
}
