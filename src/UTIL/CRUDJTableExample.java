/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTIL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CRUDJTableExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("CRUD JTable Example");
        JTable table = new JTable();

        // Crear un DefaultTableModel con columnas predeterminadas
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Columna 1");
        model.addColumn("Columna 2");

        // Establecer el modelo en la JTable
        table.setModel(model);

        // Botones para agregar, actualizar y quitar registros
        JButton addButton = new JButton("Agregar Registro");
        JButton updateButton = new JButton("Actualizar Registro");
        JButton deleteButton = new JButton("Quitar Registro");

        // Agregar ActionListener para los botones
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Añadir un nuevo registro al modelo de la tabla
                Object[] newRow = {"Nuevo Dato 1", "Nuevo Dato 2"};
                model.addRow(newRow);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la fila seleccionada
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Actualizar valores en la fila seleccionada
                    model.setValueAt("Dato Actualizado 1", selectedRow, 0);
                    model.setValueAt("Dato Actualizado 2", selectedRow, 1);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la fila seleccionada
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Quitar la fila seleccionada
                    model.removeRow(selectedRow);
                }
            }
        });

        // Crear un contenedor y agregar componentes
        JPanel panel = new JPanel();
        panel.add(new JScrollPane(table));
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);

        frame.getContentPane().add(panel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
