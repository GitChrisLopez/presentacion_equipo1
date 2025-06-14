/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion_equipo1.RevisionCV;

import dto.ReclutadorDTO;
import entidades.Reclutador;
import javax.swing.JOptionPane;
import objetosnegocio.ReclutadorDAO;

/**
 *
 * @author paula
 */
public class RegistroRH extends javax.swing.JFrame {

    ReclutadorDAO reclutadorON;
    private Reclutador r;
    private boolean actualizar = false;

    /**
     * Creates new form CRUDRH
     */
    public RegistroRH() {
        initComponents();
    }

    public RegistroRH(Reclutador r, boolean actualizar) {
        initComponents();
        this.r = r;
        jTextFieldNombreCompletoRH.setText(r.getNombreCompleto());
        jTextFieldApellidoPaternoRH.setText(r.getApellidoPaterno());
        jTextFieldApellidoMaternoRH.setText(r.getApellidoMaterno());
        jTextFieldPuestoRH.setText(r.getPuesto());
        jTextFieldUsuarioRH.setText(r.getUsuario());
        this.actualizar = actualizar;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        popupMenu2 = new java.awt.PopupMenu();
        popupMenu3 = new java.awt.PopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3NombreCompleto = new javax.swing.JLabel();
        jLabel4ApellidoPaterno = new javax.swing.JLabel();
        jLabel5ApellidoMaterno = new javax.swing.JLabel();
        jLabel6Puesto = new javax.swing.JLabel();
        Usuario = new javax.swing.JLabel();
        jPasswordFieldContraseñaRH = new javax.swing.JPasswordField();
        jLabel8Contraseña = new javax.swing.JLabel();
        jTextFieldNombreCompletoRH = new javax.swing.JTextField();
        jTextFieldApellidoPaternoRH = new javax.swing.JTextField();
        jTextFieldApellidoMaternoRH = new javax.swing.JTextField();
        jTextFieldPuestoRH = new javax.swing.JTextField();
        jTextFieldUsuarioRH = new javax.swing.JTextField();
        jButtonConfirmacionRegistroRH = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();

        popupMenu1.setLabel("popupMenu1");

        popupMenu2.setLabel("popupMenu2");

        popupMenu3.setLabel("popupMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Registrar nuevo reclutador");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rhfoto2.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3NombreCompleto.setText("Nombre Completo:");

        jLabel4ApellidoPaterno.setText("Apellido Paterno:");

        jLabel5ApellidoMaterno.setText("Apellido Materno:");

        jLabel6Puesto.setText("Puesto:");

        Usuario.setText("Usuario:");

        jPasswordFieldContraseñaRH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldContraseñaRHActionPerformed(evt);
            }
        });

        jLabel8Contraseña.setText("Contraseña:");

        jTextFieldNombreCompletoRH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreCompletoRHActionPerformed(evt);
            }
        });

        jTextFieldApellidoPaternoRH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldApellidoPaternoRHActionPerformed(evt);
            }
        });

        jTextFieldApellidoMaternoRH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldApellidoMaternoRHActionPerformed(evt);
            }
        });

        jTextFieldPuestoRH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPuestoRHActionPerformed(evt);
            }
        });

        jTextFieldUsuarioRH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioRHActionPerformed(evt);
            }
        });

        jButtonConfirmacionRegistroRH.setText("Confirmar registro");
        jButtonConfirmacionRegistroRH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmacionRegistroRHActionPerformed(evt);
            }
        });

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldApellidoPaternoRH)
                                    .addComponent(jLabel4ApellidoPaterno)
                                    .addComponent(jLabel5ApellidoMaterno)
                                    .addComponent(jTextFieldApellidoMaternoRH, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(151, 151, 151)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8Contraseña)
                                    .addComponent(Usuario)
                                    .addComponent(jPasswordFieldContraseñaRH, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(jTextFieldUsuarioRH))))
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3NombreCompleto)
                            .addComponent(jTextFieldNombreCompletoRH, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6Puesto)
                            .addComponent(jTextFieldPuestoRH, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButtonVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonConfirmacionRegistroRH)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3NombreCompleto)
                    .addComponent(jLabel6Puesto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldNombreCompletoRH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldPuestoRH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4ApellidoPaterno)
                    .addComponent(Usuario))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldApellidoPaternoRH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldUsuarioRH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5ApellidoMaterno))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(jLabel8Contraseña)
                        .addGap(12, 12, 12)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordFieldContraseñaRH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldApellidoMaternoRH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmacionRegistroRH)
                    .addComponent(jButtonVolver))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombreCompletoRHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreCompletoRHActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldNombreCompletoRHActionPerformed

    private void jTextFieldApellidoPaternoRHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldApellidoPaternoRHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldApellidoPaternoRHActionPerformed

    private void jTextFieldApellidoMaternoRHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldApellidoMaternoRHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldApellidoMaternoRHActionPerformed

    private void jTextFieldPuestoRHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPuestoRHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPuestoRHActionPerformed

    private void jTextFieldUsuarioRHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioRHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsuarioRHActionPerformed

    private void jPasswordFieldContraseñaRHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldContraseñaRHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldContraseñaRHActionPerformed

    private void jButtonConfirmacionRegistroRHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmacionRegistroRHActionPerformed
        // TODO add your handling code here:
        String nombreRH = jTextFieldNombreCompletoRH.getText();
        String apellidoPaternoRH = jTextFieldApellidoPaternoRH.getText();
        String apellidoMaternoRH = jTextFieldApellidoMaternoRH.getText();
        String puestorh = jTextFieldPuestoRH.getText();
        String usuarioRH = jTextFieldUsuarioRH.getText();
        String contraseñaRH = new String(jPasswordFieldContraseñaRH.getPassword()); // cuidado: getPassword() retorna un char
        if (actualizar == true) {
            if (nombreRH.trim().isEmpty() || apellidoPaternoRH.trim().isEmpty() || apellidoMaternoRH.trim().isEmpty()
                    || puestorh.trim().isEmpty() || usuarioRH.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios, excepto 'contraseña'",
                        "Error de validación", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else{
                Reclutador reclutador = new Reclutador(r.getId(), nombreRH, apellidoPaternoRH, apellidoMaternoRH, puestorh, usuarioRH, contraseñaRH, true);
                try {
                    reclutadorON.getInstance().actualizarReclutador(reclutador);
                    JOptionPane.showMessageDialog(null, "¡Reclutador actualizado con exito!",
                            "Actualización exitosa", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Usuario existente, intenta con otro.",
                            "Error de actualización", JOptionPane.ERROR_MESSAGE);
                }
            }

        } else {
            //NOMBRE COMPLETO RH
            if (nombreRH.trim().isEmpty() || apellidoPaternoRH.trim().isEmpty() || apellidoMaternoRH.trim().isEmpty()
                    || puestorh.trim().isEmpty() || usuarioRH.trim().isEmpty() || contraseñaRH.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios",
                        "Error de validación", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                System.out.println("funciona");
                ReclutadorDTO r = new ReclutadorDTO(nombreRH, apellidoPaternoRH, apellidoMaternoRH, puestorh, usuarioRH, contraseñaRH, true, 0);
                Reclutador d = new Reclutador(0, nombreRH, apellidoPaternoRH, apellidoMaternoRH, puestorh, usuarioRH, contraseñaRH, true);
                try {
                    reclutadorON.getInstance().insertarReclutador(d);
                    JOptionPane.showMessageDialog(null, "¡Reclutador registrado con exito!",
                            "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Usuario existente, intenta con otro.",
                            "Error de validación", JOptionPane.ERROR_MESSAGE);
                }

            }

        }

    }//GEN-LAST:event_jButtonConfirmacionRegistroRHActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        // TODO add your handling code here:
        CrudRH rhh = new CrudRH();
        rhh.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistroRH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroRH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroRH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroRH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RegistroRH().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Usuario;
    private javax.swing.JButton jButtonConfirmacionRegistroRH;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3NombreCompleto;
    private javax.swing.JLabel jLabel4ApellidoPaterno;
    private javax.swing.JLabel jLabel5ApellidoMaterno;
    private javax.swing.JLabel jLabel6Puesto;
    private javax.swing.JLabel jLabel8Contraseña;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldContraseñaRH;
    private javax.swing.JTextField jTextFieldApellidoMaternoRH;
    private javax.swing.JTextField jTextFieldApellidoPaternoRH;
    private javax.swing.JTextField jTextFieldNombreCompletoRH;
    private javax.swing.JTextField jTextFieldPuestoRH;
    private javax.swing.JTextField jTextFieldUsuarioRH;
    private java.awt.PopupMenu popupMenu1;
    private java.awt.PopupMenu popupMenu2;
    private java.awt.PopupMenu popupMenu3;
    // End of variables declaration//GEN-END:variables
}
