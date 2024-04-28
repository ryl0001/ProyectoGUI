package BorradorProyecto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblNewLabel;
	private JButton btnEnviar;
	private JButton btnSalir;


	/**
	 * Create the frame.
	 */
	public Registro() {
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(IniciarSesion.class.getResource("/BorradorProyecto/gamers (1) (1).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 539);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Formulario = new JLabel("Formulario de registro");
		lbl_Formulario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lbl_Formulario.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Formulario.setForeground(new Color(255, 255, 255));
		lbl_Formulario.setBounds(259, 23, 384, 42);
		contentPane.add(lbl_Formulario);
		
		textField = new JTextField();
		textField.setBounds(135, 98, 185, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(361, 98, 185, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(270, 154, 373, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(582, 98, 194, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lbl_NomForm = new JLabel("Nombre");
		lbl_NomForm.setForeground(new Color(255, 255, 255));
		lbl_NomForm.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		lbl_NomForm.setBounds(186, 73, 46, 14);
		contentPane.add(lbl_NomForm);
		
		JLabel lbl_ApForm = new JLabel("Apellidos");
		lbl_ApForm.setForeground(new Color(255, 255, 255));
		lbl_ApForm.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		lbl_ApForm.setBounds(411, 76, 57, 14);
		contentPane.add(lbl_ApForm);
		
		JLabel LvlDirr = new JLabel("Dirección");
		LvlDirr.setFont(new Font("Tahoma", Font.BOLD, 11));
		LvlDirr.setForeground(new Color(255, 255, 255));
		LvlDirr.setBounds(430, 129, 57, 14);
		contentPane.add(LvlDirr);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDNI.setForeground(new Color(255, 255, 255));
		lblDNI.setBounds(653, 73, 46, 14);
		contentPane.add(lblDNI);
		
		JLabel lblUs = new JLabel("Usuario/email");
		lblUs.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUs.setForeground(new Color(255, 255, 255));
		lblUs.setBounds(411, 329, 113, 14);
		contentPane.add(lblUs);
		
		textField_5 = new JTextField();
		textField_5.setBounds(270, 354, 373, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(270, 410, 373, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblCont = new JLabel("Contraseña");
		lblCont.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCont.setForeground(new Color(255, 255, 255));
		lblCont.setBounds(412, 385, 75, 14);
		contentPane.add(lblCont);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEnviar.setBounds(312, 466, 113, 50);
		contentPane.add(btnEnviar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.setBounds(491, 466, 113, 50);
		contentPane.add(btnSalir);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Registro.class.getResource("/BorradorProyecto/Portada para YouTube de gamer profesional moderno morado (1) (1).png")));
		lblNewLabel.setBounds(0, 0, 913, 539);
		contentPane.add(lblNewLabel);
	}
}
