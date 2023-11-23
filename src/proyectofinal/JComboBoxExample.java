/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JComboBoxExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("JComboBox Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear datos de ejemplo
        DefaultComboBoxModel<ComboData> comboBoxModel = new DefaultComboBoxModel<>();
        comboBoxModel.addElement(new ComboData(1, "Opción 1"));
        ComboData x = new ComboData(2, "Opción 2");
        comboBoxModel.addElement(x);
        comboBoxModel.addElement(new ComboData(3, "Opción 3"));

        // Crear JComboBox y establecer el modelo
        JComboBox<ComboData> comboBox = new JComboBox<>(comboBoxModel);

        // Crear un botón para cambiar la selección
        JButton cambiarBoton = new JButton("Cambiar Selección");
        cambiarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el modelo y buscar el índice del nuevo valor
//                ComboData nuevoValor = new ComboData(2, "Opción 2");
                int index = findIndex(comboBoxModel, x);

                // Cambiar el elemento seleccionado
                if (index != -1) {
                    comboBox.setSelectedIndex(index);
                }
            }
        });

        // Agregar componentes al panel de contenido
        JPanel contentPane = new JPanel();
        contentPane.add(comboBox);
        contentPane.add(cambiarBoton);

        // Configurar el frame
        frame.getContentPane().add(contentPane);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static int findIndex(DefaultComboBoxModel<ComboData> model, ComboData value) {
        for (int i = 0; i < model.getSize(); i++) {
            if (model.getElementAt(i).equals(value)) {
                return i;
            }
        }
        return -1;
    }

}

class ComboData {

    private int id;
    private String text;

    public ComboData(int id, String text) {
        this.id = id;
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
