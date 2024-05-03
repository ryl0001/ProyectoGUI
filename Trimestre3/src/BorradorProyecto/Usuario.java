package BorradorProyecto;

import java.awt.Color;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Usuario extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    

    public Usuario() {
        setUndecorated(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(IniciarSesion.class.getResource("/BorradorProyecto/gamers (1) (1).png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 916, 539);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        

        JButton EliminarUs = new JButton("Eliminar Usuario");
        EliminarUs.setFont(new Font("Tahoma", Font.BOLD, 11));
        EliminarUs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
				ConfirmacionEliminar CE = new ConfirmacionEliminar();
				CE.setVisible(true);
                
            }
        });
        EliminarUs.setBounds(270, 275, 138, 23);
        contentPane.add(EliminarUs);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnSalir.setBounds(543, 275, 89, 23);
        contentPane.add(btnSalir);

        JLabel lblActualizarUsu = new JLabel("¿ESTAS SEGURO DE QUE QUIERES ELIMINAR TU USUARIO?");
        lblActualizarUsu.setHorizontalAlignment(SwingConstants.CENTER);
        lblActualizarUsu.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblActualizarUsu.setForeground(new Color(255, 255, 255));
        lblActualizarUsu.setBounds(185, 113, 541, 109);
        contentPane.add(lblActualizarUsu);

        JLabel lblNewLabel = new JLabel("Actualizar/Eliminar Usuario");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(0, 0, 943, 539);
        contentPane.add(lblNewLabel);
        lblNewLabel.setIcon(new ImageIcon(IniciarSesion.class.getResource("/BorradorProyecto/Portada para YouTube de gamer profesional moderno morado (1) (1).png")));
    }
}
