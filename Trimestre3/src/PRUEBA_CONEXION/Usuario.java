package PRUEBA_CONEXION;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Usuario extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JPasswordField passwordField;
    private int idUsuario;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Usuario frame = new Usuario(1); // Ejemplo de ID de usuario, puedes pasar el ID real desde IniciarSesion
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario; // Guardamos el ID del usuario

        setUndecorated(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(IniciarSesion.class.getResource("/BorradorProyecto/gamers (1) (1).png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 916, 539);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel ActualizarUsuario = new JLabel("Actualizar Usuario");
        ActualizarUsuario.setBounds(259, 23, 384, 42);
        ActualizarUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        ActualizarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        ActualizarUsuario.setForeground(new Color(255, 255, 255));
        contentPane.add(ActualizarUsuario);
        
        JLabel LvlDirr = new JLabel("Cambiar Dirección");
        LvlDirr.setBounds(117, 78, 118, 14);
        LvlDirr.setFont(new Font("Tahoma", Font.BOLD, 11));
        LvlDirr.setForeground(new Color(255, 255, 255));
        contentPane.add(LvlDirr);
        
        JLabel lblUs = new JLabel("Cambiar email");
        lblUs.setBounds(117, 156, 113, 14);
        lblUs.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblUs.setForeground(new Color(255, 255, 255));
        contentPane.add(lblUs);
        
        JLabel lblCont = new JLabel("Cambiar Contraseña");
        lblCont.setBounds(117, 232, 118, 14);
        lblCont.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCont.setForeground(new Color(255, 255, 255));
        contentPane.add(lblCont);
        
        textField = new JTextField();
        textField.setBounds(127, 111, 565, 20);
        contentPane.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(127, 192, 565, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(127, 271, 565, 20);
        contentPane.add(passwordField);
        
        JButton ActualizarUs = new JButton("Actualizar");
        ActualizarUs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarUsuario();
            }
        });
        ActualizarUs.setBounds(405, 428, 113, 23);
        contentPane.add(ActualizarUs);
        
        JButton EliminarUs = new JButton("Eliminar Usuario");
        EliminarUs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarUsuario();
            }
        });
        EliminarUs.setBounds(554, 428, 138, 23);
        contentPane.add(EliminarUs);
        
        JButton btnSalir = new JButton("Salir\r\n");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnSalir.setBounds(688, 476, 89, 23);
        contentPane.add(btnSalir);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, 0, 916, 539);
        lblNewLabel.setIcon(new ImageIcon(IniciarSesion.class.getResource("/BorradorProyecto/Portada para YouTube de gamer profesional moderno morado (1) (1).png")));
        contentPane.add(lblNewLabel);
    }

    private void actualizarUsuario() {
        String nuevaDireccion = textField.getText();
        String nuevoEmail = textField_1.getText();
        String nuevaContraseña = new String(passwordField.getPassword());

        // Validar que al menos un campo tenga un valor nuevo
        if (!nuevaDireccion.isEmpty() || !nuevoEmail.isEmpty() || !nuevaContraseña.isEmpty()) {
            // Realizar la actualización en la base de datos usando el idUsuario
            // Ejemplo:
            // ConexionMySQL conexion = new ConexionMySQL("usuario", "contraseña", "base_de_datos");
            // conexion.conectar();
            // conexion.ejecutarInsertDeleteUpdate("UPDATE Clientes SET Direccion='" + nuevaDireccion + "', Email='" + nuevoEmail + "', Contraseña='" + nuevaContraseña + "' WHERE idClientes=" + idUsuario);
            // conexion.desconectar();
            System.out.println("Usuario actualizado en la base de datos");
        } else {
            System.out.println("No se ha introducido ningún cambio.");
        }
    }

    private void eliminarUsuario() {
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar tu cuenta?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            // Realizar la eliminación en la base de datos usando el idUsuario
            // Ejemplo:
            // ConexionMySQL conexion = new ConexionMySQL("usuario", "contraseña", "base_de_datos");
            // conexion.conectar();
            // conexion.ejecutarInsertDeleteUpdate("DELETE FROM Clientes WHERE idClientes=" + idUsuario);
            // conexion.desconectar();
            System.out.println("Usuario eliminado de la base de datos");
            dispose(); // Cerrar la ventana después de eliminar el usuario
        }
    }
}
