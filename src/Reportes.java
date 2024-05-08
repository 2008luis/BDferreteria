
import ReportesVentanas.JIFClienteMasCompras;
import ReportesVentanas.JIFProductoMasVendido;
import ReportesVentanas.JIFRecaudoTotal;
import ReportesVentanas.JIFRecuadoVendedor;
import ReportesVentanas.JIFReporteVentasRealizadas;
import ReportesVentanas.JIFVendedorFechas;
import ReportesVentanas.JIFVendedorMasVentas;

public class Reportes extends javax.swing.JFrame {
int emplea,ides;
    String usar;
    public Reportes(int idempleados, String usuarios, int id) {
           this.setUndecorated(true);
        initComponents();
         this.emplea=idempleados;
        this.usar=usuarios;
        this.ides=id;
           this.setLocationRelativeTo(null);
    }

    private Reportes() {
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JescritorioReportes = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btndeVolver = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuItem1 = new javax.swing.JMenu();
        MenuItem1_1 = new javax.swing.JMenuItem();
        Menuitem2 = new javax.swing.JMenu();
        Menuitem2_2 = new javax.swing.JMenuItem();
        MenuItem2_2 = new javax.swing.JMenuItem();
        jMenuItem2_3 = new javax.swing.JMenuItem();
        MenuItem2_4 = new javax.swing.JMenuItem();
        Menuitem2_5 = new javax.swing.JMenuItem();
        Menuitem2_7 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REPORTES");

        JescritorioReportes.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setText("ADMINISTRADOR");

        JescritorioReportes.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout JescritorioReportesLayout = new javax.swing.GroupLayout(JescritorioReportes);
        JescritorioReportes.setLayout(JescritorioReportesLayout);
        JescritorioReportesLayout.setHorizontalGroup(
            JescritorioReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JescritorioReportesLayout.createSequentialGroup()
                .addGap(435, 435, 435)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(452, Short.MAX_VALUE))
        );
        JescritorioReportesLayout.setVerticalGroup(
            JescritorioReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JescritorioReportesLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo ferreteria.jpeg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 160, 180));

        btndeVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Devolver.png"))); // NOI18N
        btndeVolver.setText("INICIO");
        btndeVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btndeVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 140, 40));

        MenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/empleadosss.png"))); // NOI18N
        MenuItem1.setText("REGISTRO EMPLEADO");

        MenuItem1_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/maslogo.png"))); // NOI18N
        MenuItem1_1.setText("REGISTRAR EMPLEADOS");
        MenuItem1_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItem1_1ActionPerformed(evt);
            }
        });
        MenuItem1.add(MenuItem1_1);

        jMenuBar1.add(MenuItem1);

        Menuitem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reportes.png"))); // NOI18N
        Menuitem2.setText("REPORTES");

        Menuitem2_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/martillo.png"))); // NOI18N
        Menuitem2_2.setText("Producto mas vendido");
        Menuitem2_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menuitem2_2ActionPerformed(evt);
            }
        });
        Menuitem2.add(Menuitem2_2);

        MenuItem2_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventasrealizadas.png"))); // NOI18N
        MenuItem2_2.setText("VENTAS GENERAL");
        MenuItem2_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItem2_2ActionPerformed(evt);
            }
        });
        Menuitem2.add(MenuItem2_2);

        jMenuItem2_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fechasvendedor.png"))); // NOI18N
        jMenuItem2_3.setText("VENDEDOR RANGO DE FECHA");
        jMenuItem2_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2_3ActionPerformed(evt);
            }
        });
        Menuitem2.add(jMenuItem2_3);

        MenuItem2_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/totall.png"))); // NOI18N
        MenuItem2_4.setText("RECAUDO TOTAL");
        MenuItem2_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItem2_4ActionPerformed(evt);
            }
        });
        Menuitem2.add(MenuItem2_4);

        Menuitem2_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/totalVendedor.png"))); // NOI18N
        Menuitem2_5.setText("RECAUDO VENDEDOR");
        Menuitem2_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menuitem2_5ActionPerformed(evt);
            }
        });
        Menuitem2.add(Menuitem2_5);

        Menuitem2_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clientesVen.png"))); // NOI18N
        Menuitem2_7.setText("CLIENTE CON MAS COMPRAS");
        Menuitem2_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menuitem2_7ActionPerformed(evt);
            }
        });
        Menuitem2.add(Menuitem2_7);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/VendedorVen.png"))); // NOI18N
        jMenuItem2.setText("VENDEDOR CON MAS VENTAS");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Menuitem2.add(jMenuItem2);

        jMenuBar1.add(Menuitem2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JescritorioReportes)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JescritorioReportes)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuItem1_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItem1_1ActionPerformed
        RegistroEmpleados empleado = new RegistroEmpleados();
        empleado.setVisible(true);
    }//GEN-LAST:event_MenuItem1_1ActionPerformed

    private void Menuitem2_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menuitem2_5ActionPerformed
        // TODO add your handling code here:
        JIFRecuadoVendedor vende = new JIFRecuadoVendedor();
        JescritorioReportes.add(vende);
        vende.show();
    }//GEN-LAST:event_Menuitem2_5ActionPerformed

    private void MenuItem2_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItem2_4ActionPerformed
        // TODO add your handling code here:
        JIFRecaudoTotal total = new JIFRecaudoTotal();
        JescritorioReportes.add(total);
        total.show();
    }//GEN-LAST:event_MenuItem2_4ActionPerformed

    private void jMenuItem2_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2_3ActionPerformed
        // TODO add your handling code here:
        JIFVendedorFechas vendedor = new JIFVendedorFechas();
        JescritorioReportes.add(vendedor);
        vendedor.show();
    }//GEN-LAST:event_jMenuItem2_3ActionPerformed

    private void MenuItem2_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItem2_2ActionPerformed
        // TODO add your handling code here:
        JIFReporteVentasRealizadas realizadas = new JIFReporteVentasRealizadas();
        JescritorioReportes.add(realizadas);
        realizadas.show();
    }//GEN-LAST:event_MenuItem2_2ActionPerformed

    private void Menuitem2_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menuitem2_2ActionPerformed

        JIFProductoMasVendido producto = new JIFProductoMasVendido();
        JescritorioReportes.add(producto);
        producto.show();
    }//GEN-LAST:event_Menuitem2_2ActionPerformed

    private void btndeVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeVolverActionPerformed
        
             
     Inicio ini = new Inicio(emplea,usar,ides);
        ini.setVisible(true);
         dispose();
    }//GEN-LAST:event_btndeVolverActionPerformed

    private void Menuitem2_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menuitem2_7ActionPerformed
        // TODO add your handling code here:
          JIFClienteMasCompras clientes = new JIFClienteMasCompras();
        JescritorioReportes.add(clientes);
        clientes.show();
    }//GEN-LAST:event_Menuitem2_7ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
           JIFVendedorMasVentas vende = new JIFVendedorMasVentas();
        JescritorioReportes.add(vende);
        vende.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane JescritorioReportes;
    private javax.swing.JMenu MenuItem1;
    private javax.swing.JMenuItem MenuItem1_1;
    private javax.swing.JMenuItem MenuItem2_2;
    private javax.swing.JMenuItem MenuItem2_4;
    private javax.swing.JMenu Menuitem2;
    private javax.swing.JMenuItem Menuitem2_2;
    private javax.swing.JMenuItem Menuitem2_5;
    private javax.swing.JMenuItem Menuitem2_7;
    private javax.swing.JButton btndeVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem2_3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
