package BorradorProyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class IniciarSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUs;
	private JTextField textContraseña;
	private Connection conexion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IniciarSesion frame = new IniciarSesion();
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
	public IniciarSesion() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(IniciarSesion.class.getResource("/BorradorProyecto/gamers (1) (1).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 916, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textUs = new JTextField();
		textUs.setBounds(320, 78, 297, 20);
		contentPane.add(textUs);
		textUs.setColumns(10);
		
		JLabel lblUs = new JLabel("Usuario/email");
		lblUs.setForeground(new Color(255, 255, 255));
		lblUs.setBounds(423, 53, 89, 14);
		contentPane.add(lblUs);
		
		JLabel lblContra = new JLabel("Contraseña");
		lblContra.setForeground(new Color(255, 255, 255));
		lblContra.setBounds(423, 109, 89, 14);
		contentPane.add(lblContra);
		
		textContraseña = new JTextField();
		textContraseña.setBounds(320, 134, 297, 20);
		contentPane.add(textContraseña);
		textContraseña.setColumns(10);
		
		
		
		JButton btnSalir = new JButton("Salir\r\n");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(398, 401, 127, 49);
		contentPane.add(btnSalir);
		
		JLabel lblTitulo = new JLabel("INICIAR SESIÓN");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setBounds(373, 11, 165, 31);
		contentPane.add(lblTitulo);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConexionMySQL connect = new ConexionMySQL ("root", "test", "Proyecto");
				 try {
					 	connect.conectar();
					 	
					 	@SuppressWarnings("deprecation")
					 	String login = "SELECT * FROM Clientes WHERE email='"+textUs.getText()+"'AND contraseña='"+textContraseña.getText()+"'";
	                    ResultSet resultado = connect.ejecutarSelect(login);
	                    
	                    String ClienteCorrecto=null;
	                    String ContraseñaCorrecta=null;
	                    
	                    if (resultado.next()){
	                    	ClienteCorrecto = resultado.getString(1);
	                    	ContraseñaCorrecta = resultado.getString(2);
	                    	
	                    	Tienda tienda=new Tienda();
	                    	tienda.setVisible(true);
	                    	dispose();
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos. Por favor, regístrate primero.", "Error", JOptionPane.ERROR_MESSAGE);
	                    }
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                    JOptionPane.showMessageDialog(null, "Error al verificar las credenciales.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
				 			
	            }
	        });
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEntrar.setBounds(399, 341, 126, 49);
		contentPane.add(btnEntrar);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(IniciarSesion.class.getResource("/BorradorProyecto/Portada para YouTube de gamer profesional moderno morado (1) (1).png")));
		lblNewLabel.setBounds(0, 0, 916, 539);
		contentPane.add(lblNewLabel);
	}
}
