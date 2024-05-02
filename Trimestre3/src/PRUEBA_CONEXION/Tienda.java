package PRUEBA_CONEXION;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class Tienda extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private ConexionMySQL conexion;

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

    public Tienda() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(IniciarSesion.class.getResource("/BorradorProyecto/gamers (1) (1).png")));
        conexion = new ConexionMySQL("root", "test", "Proyecto");
        try {
            conexion.conectar();
            ResultSet rs = conexion.ejecutarSelect("SELECT * FROM Videojuegos");
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
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
            table = new JTable(model);
            table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 539);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitBuscador = new JLabel("BUSCADOR");
        lblTitBuscador.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        lblTitBuscador.setForeground(new Color(255, 255, 255));
        lblTitBuscador.setBounds(395, 23, 140, 40);
        contentPane.add(lblTitBuscador);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnSalir.setBounds(699, 451, 89, 23);
        contentPane.add(btnSalir);

        JButton btnComprar = new JButton("Comprar");
        btnComprar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener las filas seleccionadas
                int[] selectedRows = table.getSelectedRows();
                if (selectedRows.length == 0) {
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún videojuego.");
                } else {
                    // Recopilar los videojuegos seleccionados y sus precios
                    Object[][] videojuegosSeleccionados = new Object[selectedRows.length][4]; // 4 columnas para ID, nombre, precio y categoría
                    double totalPrecio = 0.0;
                    for (int i = 0; i < selectedRows.length; i++) {
                        for (int j = 0; j < 4; j++) {
                            videojuegosSeleccionados[i][j] = table.getValueAt(selectedRows[i], j);
                        }
                        totalPrecio += Double.parseDouble(table.getValueAt(selectedRows[i], 2).toString());
                    }
                    // Mostrar la ventana Pedido con los videojuegos seleccionados y el total del precio
                    Pedido pedido = new Pedido(videojuegosSeleccionados, totalPrecio);
                    pedido.setVisible(true);
                }
            }
        });
        btnComprar.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnComprar.setBounds(586, 451, 89, 23);
        contentPane.add(btnComprar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(157, 122, 582, 306);
        contentPane.add(scrollPane);

        scrollPane.setViewportView(table);
        
        JButton btnNewButton = new JButton("Usuario");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        btnNewButton.setBounds(43, 36, 89, 23);
        contentPane.add(btnNewButton);
        
        // Fondo
        JLabel lblFondo = new JLabel("");
        lblFondo.setIcon(new ImageIcon(Tienda.class.getResource("/BorradorProyecto/Portada para YouTube de gamer profesional moderno morado (1) (1).png")));
        lblFondo.setBounds(0, 0, 900, 539);
        contentPane.add(lblFondo);
    }
}
