package BorradorProyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class Tienda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda frame = new Tienda();
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
	public Tienda() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tienda.class.getResource("/BorradorProyecto/gamers (1) (1).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.setBounds(699, 451, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel lblTitBuscador = new JLabel("BUSCADOR");
		lblTitBuscador.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblTitBuscador.setForeground(new Color(255, 255, 255));
		lblTitBuscador.setBounds(395, 23, 140, 40);
		contentPane.add(lblTitBuscador);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnComprar.setBounds(586, 451, 89, 23);
		contentPane.add(btnComprar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(131, 92, 220, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(449, 92, 203, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Tienda.class.getResource("/BorradorProyecto/Portada para YouTube de gamer profesional moderno morado (1) (1).png")));
		lblFondo.setBounds(0, 0, 900, 539);
		contentPane.add(lblFondo);
	}
}
