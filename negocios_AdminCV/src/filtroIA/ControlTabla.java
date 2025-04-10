/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filtroIA;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chris
 */
public class ControlTabla {
    private JTable tabla;
    private DefaultTableModel modelo;

    public ControlTabla(JTable tabla, DefaultTableModel modelo) {
        this.tabla = tabla;
        this.modelo = modelo;
    }

    // Cambia el estado de la fila seleccionada a "Filtrado"
    public void filtrarSeleccionado() {
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(tabla, "Selecciona una fila para filtrar.");
            return;
        }

        modelo.setValueAt("Filtrado", filaSeleccionada, 5); // Columna 6 = "Estado"
    }
}
