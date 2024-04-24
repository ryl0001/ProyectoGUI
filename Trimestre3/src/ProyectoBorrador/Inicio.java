package ProyectoBorrador;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import PRUEBA_CONEXION.ConexionMySQL;

import javax.swing.JButton;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//Crear y mostrar la ventana
		Inicio frame = new Inicio();
		frame.setVisible(true);
		
		ConexionMySQL connect = new ConexionMySQL("root","test","TiendaVideojuegos");
		Scanner teclado = new Scanner(System.in);
		};


	/**
	 * Create the frame.
	 */
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Configura como se debe cerrar la ventana
		setSize(450,300); //Establece el tamaño inicial de la ventana
		contentPane = new JPanel(); // Crear un nuevo panel
		setContentPane(contentPane); //Establece el panel como contenido de la ventana
		contentPane.setLayout(new BorderLayout()); //Configura el diseño del panel

		
		//Ruta de la imagen
		String imagePath = "/PROYECTO/src/ProyectoBorrador/Fondo.png";
		
		//Cargar imagen
		ImageIcon icon = new ImageIcon(imagePath); //Crear un objeto con la ruta de la imagen
		Image image = icon.getImage(); //Obtiene la imagen del icono
		
		// Verificar si la imagen se cargó correctamente
        if (image != null) {
            System.out.println("Imagen cargada correctamente");
        } else {
            System.out.println("Error al cargar la imagen");
        }
		
		//Redimensionar la imagen para que se ajuste al tamaño de la ventana
		Image scaledImage = image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH); //Redimensiona la imagen
		ImageIcon scaledIcon = new ImageIcon(scaledImage); //Crea un nuevo ImageIcon con la imagen redimensionada
		
		//Crear un JLabel para mostrar la imagen
		JLabel imageLabel = new JLabel(new ImageIcon(Inicio.class.getResource("/ProyectoBorrador/Fondo.png")));
		
		//Centrar la imagen en el panel
		contentPane.add(imageLabel, BorderLayout.CENTER);
		
		//Forzar una actualización de la interfaz gráfica
		revalidate(); //Actualizar el diseño del panel
		repaint(); //Vuelve a pintar el contenido del panel
        
	}
}
