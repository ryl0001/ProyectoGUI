package PRUEBA_CONEXION;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tienda extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JComboBox<String> ComboBoxCategoria;
    private ConexionMySQL conexion;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Tienda frame = new Tienda();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Tienda() {
        conectarBaseDatos();
        configurarInterfazUsuario();
    }

    private void conectarBaseDatos() {
        conexion = new ConexionMySQL("root", "test", "Proyecto");
        try {
            conexion.conectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos");
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void cargarCategorias() {
        try {
            ResultSet rs = conexion.ejecutarSelect("SELECT Nombre FROM Categoria");
            while (rs.next()) {
                ComboBoxCategoria.addItem(rs.getString("Nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar categorías desde la base de datos.");
        }
    }

    private void cargarVideojuegosPorCategoria(String categoria) {
        try {
            String query = "SELECT * FROM Videojuegos WHERE Categorias_idCategorias1 = ?";
            PreparedStatement stmt = obtenerPreparedStatement(query);
            stmt.setString(1, categoria);
            ResultSet rs = stmt.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Nombre");
            model.addColumn("Precio");
            model.addColumn("Categoria");

            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getInt("idVideojuegos");
                fila[1] = rs.getString("Nombre");
                fila[2] = rs.getDouble("Precio");
                fila[3] = rs.getString("Categorias_idCategorias1");
                model.addRow(fila);
            }

            table.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar videojuegos desde la base de datos.");
        }
    }

    private PreparedStatement obtenerPreparedStatement(String query) throws SQLException {
        return null;
    }

    private void configurarInterfazUsuario() {
        setUndecorated(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(Tienda.class.getResource("/BorradorProyecto/gamers (1) (1).png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 539);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> dispose());
        btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnSalir.setBounds(699, 451, 89, 23);
        contentPane.add(btnSalir);

        JLabel lblTitBuscador = new JLabel("BUSCADOR");
        lblTitBuscador.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        lblTitBuscador.setForeground(new Color(255, 255, 255));
        lblTitBuscador.setBounds(395, 23, 140, 40);
        contentPane.add(lblTitBuscador);

        ComboBoxCategoria = new JComboBox<>();
        ComboBoxCategoria.setBounds(341, 90, 203, 22);
        contentPane.add(ComboBoxCategoria);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(157, 122, 582, 306);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JLabel lblFondo = new JLabel("");
        lblFondo.setIcon(new ImageIcon(Tienda.class.getResource("/BorradorProyecto/Portada para YouTube de gamer profesional moderno morado (1) (1).png")));
        lblFondo.setBounds(0, 0, 900, 539);
        contentPane.add(lblFondo);

        cargarCategorias();

        ComboBoxCategoria.addActionListener(e -> {
            String categoriaSeleccionada = (String) ComboBoxCategoria.getSelectedItem();
            if (categoriaSeleccionada != null) {
                cargarVideojuegosPorCategoria(categoriaSeleccionada);
            }
        });
    }

    @Override
    public void dispose() {
        try {
            conexion.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        super.dispose();
    }
}

