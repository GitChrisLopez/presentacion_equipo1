/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomControls;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Ragzard
 */
public class RendererConBtn extends JPanel implements ListCellRenderer<String> {

    private final JLabel lblTexto = new JLabel();
    private final JLabel lblCerrar = new JLabel("X");

    public RendererConBtn() {
        setLayout(new BorderLayout());
        lblCerrar.setForeground(Color.BLACK);
        lblCerrar.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCerrar.setPreferredSize(new Dimension(30, 20));

        this.add(lblTexto, BorderLayout.CENTER);
        this.add(lblCerrar, BorderLayout.EAST);
        this.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {

        lblTexto.setText(value);

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            lblTexto.setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            lblTexto.setForeground(list.getForeground());
        }

        return this;
    }
}
