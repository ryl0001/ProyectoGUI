package BorradorProyecto;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ConfirmacionEliminar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField email;
	private JPasswordField contraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmacionEliminar frame = new ConfirmacionEliminar();
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
	public ConfirmacionEliminar() {
		 
	        setIconImage(Toolkit.getDefaultToolkit().getImage(IniciarSesion.class.getResource("/BorradorProyecto/gamers (1) (1).png")));
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 916, 539);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	        setContentPane(contentPane);
	        contentPane.setLayout(null);
	        
	        JLabel Titulo = new JLabel("Pon tus datos, para eliminar tu usuario.");
	        Titulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
	        Titulo.setForeground(new Color(255, 255, 255));
	        Titulo.setBounds(222, 29, 468, 56);
	        contentPane.add(Titulo);
	        
	        JLabel TitEmail = new JLabel("Email");
	        TitEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
	        TitEmail.setForeground(new Color(255, 255, 255));
	        TitEmail.setBounds(118, 123, 46, 14);
	        contentPane.add(TitEmail);
	        
	        email = new JTextField();
	        email.setBounds(118, 161, 518, 20);
	        contentPane.add(email);
	        email.setColumns(10);
	        
	        JLabel TitContraseña = new JLabel("Contraseña");
	        TitContraseña.setForeground(Color.WHITE);
	        TitContraseña.setFont(new Font("Tahoma", Font.BOLD, 15));
	        TitContraseña.setBounds(118, 207, 111, 14);
	        contentPane.add(TitContraseña);
	        
	        contraseña = new JPasswordField();
	        contraseña.setBounds(118, 232, 518, 20);
	        contentPane.add(contraseña);
	        
	        JButton Eliminar = new JButton("Eliminar Cuenta");
	        Eliminar.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		ConexionMySQL connect = new ConexionMySQL("root", "test", "Proyecto");
	        		try {
	        			connect.conectar();

	                    @SuppressWarnings("deprecation")
	                    String login = "SELECT * FROM Clientes WHERE email='" + email.getText() + "'AND contraseña='" + contraseña.getText() + "'";
	                    ResultSet resultado = connect.ejecutarSelect(login);

	                    String ClienteCorrecto = null;
	                    String ContraseñaCorrecta = null;

	                    if (resultado.next()) {
	                        ClienteCorrecto = resultado.getString(1);
	                        ContraseñaCorrecta = resultado.getString(2);

	                        @SuppressWarnings("deprecation")
							String delete = "DELETE FROM Clientes WHERE email ='" + email.getText() + "'AND contraseña='" + contraseña.getText() + "'";
	                        
	                        connect.ejecutarInsertDeleteUpdate(delete);
	                        JOptionPane.showMessageDialog(null, "Usuario eliminado Correctamente.");
	                        //AQUI
	                       
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos. Por favor, intentelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
	                    }
	        	}
	                 catch (SQLException ex) {
	                    ex.printStackTrace();
	                    JOptionPane.showMessageDialog(null, "Error al verificar las credenciales.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	        	}
	        });
	        Eliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
	        Eliminar.setBounds(343, 339, 126, 64);
	        contentPane.add(Eliminar);
	        
	        JButton Salir = new JButton("SALIR");
	        Salir.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        	}
	        });
	        Salir.setFont(new Font("Tahoma", Font.BOLD, 11));
	        Salir.setBounds(719, 427, 89, 23);
	        contentPane.add(Salir);
	        
	        JLabel Fondo = new JLabel("");
	        Fondo.setIcon(new ImageIcon(ConfirmacionEliminar.class.getResource("/BorradorProyecto/Portada para YouTube de gamer profesional moderno morado (1) (1).png")));
	        Fondo.setBounds(0, 0, 900, 500);
	        contentPane.add(Fondo);
	        
	        
	        
	        
	}
}
