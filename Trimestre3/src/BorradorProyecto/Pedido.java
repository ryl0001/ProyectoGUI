package BorradorProyecto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Pedido extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private double totalPrecio;

    public Pedido(Object[][] videojuegosSeleccionados, double totalPrecio) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(IniciarSesion.class.getResource("/BorradorProyecto/gamers (1) (1).png")));
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JLabel lblPedido = new JLabel("Realizar Pedido");
        lblPedido.setHorizontalAlignment(SwingConstants.CENTER);
        lblPedido.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblPedido, BorderLayout.NORTH);

        // Creamos un modelo de tabla no editable
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

        // Agregamos los videojuegos seleccionados al modelo de la tabla
        for (Object[] videojuego : videojuegosSeleccionados) {
            model.addRow(videojuego);
        }

        // Creamos la tabla con el modelo creado
        table = new JTable(model);
        contentPane.add(new JScrollPane(table), BorderLayout.CENTER);

        JLabel lblTotalPrecio = new JLabel("Total Precio: \u20AC" + String.format("%.2f", totalPrecio)); // Euro symbol
        lblTotalPrecio.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblTotalPrecio, BorderLayout.SOUTH);

        JButton btnFinalizar = new JButton("Finalizar");
        btnFinalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener la fecha actual
                    Timestamp fechaActual = new Timestamp(System.currentTimeMillis());

                    // Insertar el pedido en la base de datos
                    ConexionMySQL conexion = new ConexionMySQL("root", "test", "Proyecto");
                    conexion.conectar();
                    for (Object[] videojuego : videojuegosSeleccionados) {
                        int idVideojuego = Integer.parseInt(videojuego[0].toString());
                        int idCategoria = Integer.parseInt(videojuego[3].toString());
                        String insertQuery = "INSERT INTO Pedidos (Fecha, Estado, Videojuegos_idVideojuegos, Videojuegos_Categorias_idCategorias1, Clientes_idClientes) " +
                                "VALUES ('" + fechaActual + "', 'Pendiente', " + idVideojuego + ", " + idCategoria + ", " + IniciarSesion.GuardarUsuario +")"; // Aquí deberías obtener el ID del cliente de alguna manera
                        conexion.ejecutarInsertDeleteUpdate(insertQuery);
                    }
                    conexion.desconectar();

                    // Mostrar mensaje de éxito
                    JOptionPane.showMessageDialog(null, "Pedido realizado correctamente.");

                    // Cerrar la ventana
                    dispose();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al realizar el pedido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        contentPane.add(btnFinalizar, BorderLayout.SOUTH);
    }
}
