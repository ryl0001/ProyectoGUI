package PRUEBA_CONEXION;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;

public class Tienda extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private ConexionMySQL conexion;

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
        conexion = new ConexionMySQL("root", "test", "Proyecto");
        try {
            conexion.conectar();
            // Ejecutamos una consulta para obtener los datos de la tabla deseada
            ResultSet rs = conexion.ejecutarSelect("SELECT * FROM Videojuegos");
            // Creamos un modelo de tabla
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Nombre");
            model.addColumn("Precio");
            model.addColumn("Categoria");
            // Llenamos el modelo con los resultados de la consulta
            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getInt("idVideojuegos");
                fila[1] = rs.getString("Nombre");
                fila[2] = rs.getDouble("Precio");
                fila[3] = rs.getString("Categorias_idCategorias1");
                model.addRow(fila);
            }
            // Inicializamos la tabla con el modelo creado
            table = new JTable(model);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos");
        } finally {
            try {
                conexion.desconectar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

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

        JComboBox ComboBoxVideojuegos = new JComboBox();
        ComboBoxVideojuegos.setBounds(131, 92, 220, 22);
        contentPane.add(ComboBoxVideojuegos);

        JComboBox ComboBoxCategoria = new JComboBox();
        ComboBoxCategoria.setBounds(449, 92, 203, 22);
        contentPane.add(ComboBoxCategoria);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(95, 125, 582, 306);
        contentPane.add(scrollPane);

        // Añadimos la tabla al JScrollPane
        scrollPane.setViewportView(table);

        JLabel lblFondo = new JLabel("");
        lblFondo.setIcon(new ImageIcon(Tienda.class.getResource("/BorradorProyecto/Portada para YouTube de gamer profesional moderno morado (1) (1).png")));
        lblFondo.setBounds(0, 0, 900, 539);
        contentPane.add(lblFondo);
    }
}
