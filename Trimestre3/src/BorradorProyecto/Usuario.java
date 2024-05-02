package BorradorProyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Usuario extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JPasswordField passwordField;

    public Usuario() {
        setUndecorated(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(IniciarSesion.class.getResource("/BorradorProyecto/gamers (1) (1).png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 916, 539);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Dirección:");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(227, 212, 85, 23);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Email:");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_2.setBounds(227, 272, 85, 23);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Contraseña:");
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_3.setBounds(227, 330, 112, 23);
        contentPane.add(lblNewLabel_3);

        textField = new JTextField();
        textField.setBounds(384, 212, 258, 23);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(384, 272, 258, 23);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(384, 330, 258, 23);
        contentPane.add(passwordField);

        JButton ActualizarUs = new JButton("Actualizar");
        ActualizarUs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String direccion = textField.getText();
                String email = textField_1.getText();
                String contraseña = new String(passwordField.getPassword());

                StringBuilder query = new StringBuilder("UPDATE Clientes SET");
                boolean cambios = false;

                if (!direccion.isEmpty()) {
                    query.append(" Direccion = '").append(direccion).append("'");
                    cambios = true;
                }
                if (!email.isEmpty()) {
                    if (cambios) {
                        query.append(",");
                    }
                    query.append(" Email = '").append(email).append("'");
                    cambios = true;
                }
                if (!contraseña.isEmpty()) {
                    if (cambios) {
                        query.append(",");
                    }
                    query.append(" Contraseña = '").append(contraseña).append("'");
                    cambios = true;
                }

                if (cambios) {
                    try {
                        ConexionMySQL conexion = new ConexionMySQL("root", "test", "Proyecto");
                        conexion.conectar();
                        String consulta = query.toString();
                        conexion.ejecutarInsertDeleteUpdate(consulta); // Corrección aquí
                        JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente.");
                        conexion.desconectar();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al actualizar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha realizado ningún cambio.");
                }
            }
        });
        ActualizarUs.setBounds(405, 428, 113, 23);
        contentPane.add(ActualizarUs);

        JButton EliminarUs = new JButton("Eliminar Usuario");
        EliminarUs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar este usuario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    try {
                        ConexionMySQL conexion = new ConexionMySQL("root", "test", "Proyecto");
                        conexion.conectar();
                        //String consulta = "DELETE FROM Clientes WHERE idClientes = ?";
                        //PreparedStatement statement = conexion.prepararConsulta(consulta);
                        //statement.setInt(1, idUsuario);
                        //statement.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
                        conexion.desconectar();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al eliminar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        EliminarUs.setBounds(554, 428, 138, 23);
        contentPane.add(EliminarUs);
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnSalir.setBounds(769, 485, 89, 23);
        contentPane.add(btnSalir);
                
                JLabel lblActualizarUsu = new JLabel("ACTUALIZAR USUARIO");
                lblActualizarUsu.setHorizontalAlignment(SwingConstants.CENTER);
                lblActualizarUsu.setFont(new Font("Tahoma", Font.BOLD, 18));
                lblActualizarUsu.setForeground(new Color(255, 255, 255));
                lblActualizarUsu.setBounds(305, 40, 312, 35);
                contentPane.add(lblActualizarUsu);
                
                        
                
                        JLabel lblNewLabel = new JLabel("Actualizar/Eliminar Usuario");
                        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
                        lblNewLabel.setBounds(0, 0, 943, 539);
                        contentPane.add(lblNewLabel);
                        lblNewLabel.setIcon(new ImageIcon(IniciarSesion.class.getResource("/BorradorProyecto/Portada para YouTube de gamer profesional moderno morado (1) (1).png")));
                
                        
    }
}
