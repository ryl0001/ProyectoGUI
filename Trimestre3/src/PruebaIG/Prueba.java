package PruebaIG;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Prueba extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba frame = new Prueba();
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
	public Prueba() {
		setTitle("HOLA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Etiqueta1 = new JLabel("Cuál nombre es más bonito: ");
		lbl_Etiqueta1.setForeground(new Color(255, 255, 255));
		lbl_Etiqueta1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Etiqueta1.setBounds(107, 44, 213, 40);
		lbl_Etiqueta1.setFont(new Font("Sitka Subheading", Font.PLAIN, 13));
		contentPane.add(lbl_Etiqueta1);
		
		JButton btnNewButton = new JButton("Juan");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl_Etiqueta1.setText("Juan");
				VentanaEmer ventana2 = new VentanaEmer();
				ventana2.setVisible(true);
			}
		});
		btnNewButton.setBounds(116, 136, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
		JButton btnNewButton_1 = new JButton("Pepe");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl_Etiqueta1.setText("Pepe");
			}
		});
		btnNewButton_1.setBounds(253, 136, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
