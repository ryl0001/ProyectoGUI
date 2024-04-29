package BorradorProyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTextArea;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/BorradorProyecto/gamers (1) (1).png")));
		setTitle("J.Y. STORE GAMERS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 534);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_1 = new JLabel("J.Y. STORE GAMERS");
		lbl_1.setBackground(new Color(255, 255, 255));
		lbl_1.setFont(new Font("Liberation Serif", Font.BOLD | Font.ITALIC, 31));
		lbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_1.setBounds(153, 11, 402, 50);
		lbl_1.setForeground(new Color(255, 255, 255));
		contentPane.add(lbl_1);
		
		JButton btn_iniciosesion = new JButton("Iniciar sesión");
		btn_iniciosesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl_1.setText("Iniciar sesión");
				IniciarSesion InSes = new IniciarSesion();
				InSes.setVisible(true);
			}
		});
		btn_iniciosesion.setBounds(33, 80, 216, 37);
		contentPane.add(btn_iniciosesion);
		
		JButton btn_registro = new JButton("Registrarse");
		btn_registro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl_1.setText("Registrarse");
				Registro registroUs = new Registro();
				registroUs.setVisible(true);
			}
		});
		btn_registro.setBounds(33, 128, 216, 37);
		contentPane.add(btn_registro);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(33, 176, 216, 37);
		contentPane.add(btnSalir);
		
		JTextArea txtrHola = new JTextArea();
		txtrHola.setText("¡Bienvenido a nuestra tienda de videojuegos!\r\n\r\nExplora nuestra selección de juegos nuevos y \r\nclásicos. Encuentra tus aventuras digitales \r\nfavoritas y comienza a jugar. \r\n\r\n¡Sumérgete en la diversión ahora mismo!");
		txtrHola.setOpaque(false); // Hacer que el JTextArea sea transparente
        txtrHola.setForeground(Color.WHITE);
		txtrHola.setBounds(255, 330, 394, 130);
		contentPane.add(txtrHola);
		
		JLabel lblFondoPantalla = new JLabel("");
		lblFondoPantalla.setIcon(new ImageIcon(Inicio.class.getResource("/BorradorProyecto/Portada para YouTube de gamer profesional moderno morado (1).png")));
		lblFondoPantalla.setBounds(0, 0, 759, 534);
		contentPane.add(lblFondoPantalla);
		
		ConexionMySQL connect = new ConexionMySQL ("root", "test", "freedb_ProyectoTiendaVideojuegos");
	        try {
	            connect.conectar();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	}
}
