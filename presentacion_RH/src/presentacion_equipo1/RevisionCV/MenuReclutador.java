/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion_equipo1.RevisionCV;

/**
 *
 * @author chris
 */
public class MenuReclutador extends javax.swing.JFrame {

    /**
     * Creates new form MenuReclutad
     */
    public MenuReclutador() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelFotoRH = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        revisionCV = new javax.swing.JButton();
        listasCV = new javax.swing.JButton();
        registrarC = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        actualizarC = new javax.swing.JButton();
        estadoC = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cerrarSesion1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        jLabel2.setText("Menú");

        revisionCV.setText("Revisión CV (filtro I)");
        revisionCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revisionCVActionPerformed(evt);
            }
        });

        listasCV.setText("Listas de CV (filtro II)");
        listasCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listasCVActionPerformed(evt);
            }
        });

        registrarC.setText("Registrar nuevo candidato");
        registrarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarCActionPerformed(evt);
            }
        });

        jLabel3.setText("Reclutamiento");

        jLabel4.setText("Alta a candidatos");

        actualizarC.setText("Actualizar datos del candidato");
        actualizarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarCActionPerformed(evt);
            }
        });

        estadoC.setText("Estado del candidato");
        estadoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoCActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rhfoto2.png"))); // NOI18N

        cerrarSesion1.setBackground(new java.awt.Color(0, 0, 0));
        cerrarSesion1.setForeground(new java.awt.Color(255, 255, 255));
        cerrarSesion1.setText("Cerrar Sesion");
        cerrarSesion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesion1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jLabelFotoRH))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(209, 209, 209)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(revisionCV)
                                    .addComponent(listasCV))
                                .addGap(164, 164, 164)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(actualizarC)
                                    .addComponent(registrarC)
                                    .addComponent(estadoC))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(cerrarSesion1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(454, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelFotoRH, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(registrarC))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(revisionCV)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(actualizarC))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(listasCV)))
                .addGap(8, 8, 8)
                .addComponent(estadoC)
                .addContainerGap(103, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(539, Short.MAX_VALUE)
                    .addComponent(cerrarSesion1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void revisionCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revisionCVActionPerformed
//        RevisionCV Rcv = new RevisionCV();
//        Rcv.setVisible(true);
        //llama a la clase de filtroI con las listas 
        SeleccionCV SCV = new SeleccionCV();
        SCV.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_revisionCVActionPerformed

    private void listasCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listasCVActionPerformed
//        RevisionCV Rcv = new RevisionCV();
//        Rcv.setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_listasCVActionPerformed

    private void registrarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarCActionPerformed
        RegistrarCandidato RC = new RegistrarCandidato();
        RC.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_registrarCActionPerformed

    private void estadoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadoCActionPerformed

    private void cerrarSesion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesion1ActionPerformed
        IniciarSesionRH ISRH = new IniciarSesionRH();
        ISRH.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cerrarSesion1ActionPerformed

    private void actualizarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarCActionPerformed
        SeleccionCV SCV = new SeleccionCV();
        SCV.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_actualizarCActionPerformed

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
            java.util.logging.Logger.getLogger(MenuReclutador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuReclutador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuReclutador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuReclutador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuReclutador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarC;
    private javax.swing.JButton cerrarSesion1;
    private javax.swing.JButton estadoC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelFotoRH;
    private javax.swing.JButton listasCV;
    private javax.swing.JButton registrarC;
    private javax.swing.JButton revisionCV;
    // End of variables declaration//GEN-END:variables
}
