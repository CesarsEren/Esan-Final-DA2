/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTIL;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BuscadorTabla extends JFrame {

    private JTextField textField;
    private JTable table;
    private DefaultTableModel tableModel;

    public BuscadorTabla() {
        setTitle("Buscador de Tabla");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Crear datos de ejemplo para la tabla
        Object[][] data = {
            {"John", "Doe", 25},
            {"Jane", "Smith", 30},
            {"Bob", "Johnson", 22}, // Agrega más filas según sea necesario
        };

        // Nombres de las columnas
        Object[] columnNames = {"Nombre", "Apellido", "Edad"};

        // Crear el modelo de la tabla
        tableModel = new DefaultTableModel(data, columnNames);

        // Crear la tabla con el modelo
        table = new JTable(tableModel);

        // Crear el campo de texto para búsqueda
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 25));

        // Agregar un listener al campo de texto para filtrar la tabla
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterTable();
            }
        });

        // Crear el panel y agregar componentes
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(textField, BorderLayout.NORTH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        // Agregar el panel al frame
        add(panel);

        // Mostrar el frame
        setVisible(true);
    }

    // Método para filtrar la tabla
    private void filterTable() {
        String searchText = textField.getText().toLowerCase();
        List<Integer> filteredRows = new ArrayList<>();

        // Iterar a través de las filas de la tabla
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            // Obtener el valor de la columna que deseas filtrar (por ejemplo, la primera columna)
            String cellValue = tableModel.getValueAt(i, 0).toString().toLowerCase();

            // Verificar si el valor de la celda contiene el texto de búsqueda
            if (cellValue.contains(searchText)) {
                filteredRows.add(i);
            }
        }

        // Limpiar la selección actual de la tabla
        table.clearSelection();

        // Seleccionar las filas filtradas
        for (int row : filteredRows) {
            table.addRowSelectionInterval(row, row);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BuscadorTabla());
    }
}
