package PRUEBA_CONEXION;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class Pedido extends JFrame {

    private JPanel contentPane;
    private JTable table;

    public Pedido(Object[][] videojuegosSeleccionados, double totalPrecio) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JLabel lblPedido = new JLabel("Realizar Pedido");
        lblPedido.setHorizontalAlignment(SwingConstants.CENTER);
        lblPedido.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblPedido, BorderLayout.NORTH);

        // Creamos un modelo de tabla
        DefaultTableModel model = new DefaultTableModel();
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
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Ejemplo de videojuegos seleccionados y total del precio
                    Object[][] videojuegosSeleccionados = {
                        {"1", "Videojuego 1", 20.0, "Categoria 1"},
                        {"2", "Videojuego 2", 30.0, "Categoria 2"}
                    };
                    Pedido frame = new Pedido(videojuegosSeleccionados, 50.0); 
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
