


public class Inicio extends javax.swing.JFrame {

    int id;
    String usuario;
   int idemple;

    public Inicio(int ID, String Usuario, int idEmpleado) {
          this.setUndecorated(true);
        initComponents();
        this.id = ID;
        this.setLocationRelativeTo(null);
      Lbmosrtrar.setText( Usuario);
        this.idemple=idEmpleado;
        this.usuario = Usuario;
        if (ID != 1) {
            btnProductos.setEnabled(false);
            btnReportes.setEnabled(false);
        }
    }

    public Inicio() {
      
    }
   
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbBienvenido = new javax.swing.JLabel();
        lbImagenVentas = new javax.swing.JLabel();
        Lbmosrtrar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnVender = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnCerrarsesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbBienvenido.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        lbBienvenido.setForeground(new java.awt.Color(0, 0, 0));
        lbBienvenido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bien.png"))); // NOI18N
        jPanel1.add(lbBienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 140));

        lbImagenVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/diagrama.png"))); // NOI18N
        lbImagenVentas.setText("jLabel3");
        jPanel1.add(lbImagenVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 670, 460));

        Lbmosrtrar.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        Lbmosrtrar.setForeground(new java.awt.Color(255, 51, 51));
        Lbmosrtrar.setText(".");
        jPanel1.add(Lbmosrtrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 280, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 710, 680));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setForeground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVender.setBackground(new java.awt.Color(102, 204, 255));
        btnVender.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnVender.setForeground(new java.awt.Color(255, 255, 255));
        btnVender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Vender.png"))); // NOI18N
        btnVender.setText("VENDER");
        btnVender.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });
        jPanel2.add(btnVender, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 230, 60));

        btnProductos.setBackground(new java.awt.Color(102, 204, 255));
        btnProductos.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Añadir.png"))); // NOI18N
        btnProductos.setText("AÑADIR");
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        jPanel2.add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 230, 60));

        btnReportes.setBackground(new java.awt.Color(102, 204, 255));
        btnReportes.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Admin.png"))); // NOI18N
        btnReportes.setText("ADMIN");
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });
        jPanel2.add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 230, 60));

        btnInventario.setBackground(new java.awt.Color(102, 204, 255));
        btnInventario.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnInventario.setForeground(new java.awt.Color(255, 255, 255));
        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Inventario.png"))); // NOI18N
        btnInventario.setText("STOCK");
        btnInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });
        jPanel2.add(btnInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 230, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo ferreteria.jpeg"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 150, 150));

        btnCerrarsesion.setBackground(new java.awt.Color(255, 0, 0));
        btnCerrarsesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarsesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cerrar.png"))); // NOI18N
        btnCerrarsesion.setText("CERRAR SESION ");
        btnCerrarsesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarsesionActionPerformed(evt);
            }
        });
        jPanel2.add(btnCerrarsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 230, 60));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        
        Añadir aña= new Añadir(idemple, usuario, id);
        aña.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnProductosActionPerformed
    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
 
       Inventario inv = new Inventario(idemple , usuario, id);
        inv.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnInventarioActionPerformed
    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        
        Reportes report = new Reportes( idemple, usuario, id);
        report.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
        // TODO add your handling code here:
        
       Ventas ven= new Ventas( idemple, usuario, id);
       ven.setVisible(true);
       dispose();
    }//GEN-LAST:event_btnVenderActionPerformed

    private void btnCerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarsesionActionPerformed
        // TODO add your handling code here:
        dispose(); 
        LOGIN loginForm = new LOGIN();
        loginForm.setVisible(true);
    }//GEN-LAST:event_btnCerrarsesionActionPerformed
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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lbmosrtrar;
    private javax.swing.JButton btnCerrarsesion;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnVender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbBienvenido;
    private javax.swing.JLabel lbImagenVentas;
    // End of variables declaration//GEN-END:variables
}
