
public class FacturaVenta extends javax.swing.JFrame {

    String nombre,nit,productos,nombreProducto;
    int cantidad,valorpagar;
    public FacturaVenta(String nombre,String nit, int cantidad,int valorpagar,String nombreProducto) {
        initComponents();
        lbNombrecliente.setText("NOMBRE DEL CLIENTE ES:  " +  nombre);
        lbnit.setText("EL NIT ES:  " + nit);
        lbCantidad.setText("LA CANTIDAD ES :: "+Integer.toString(cantidad));
        lbvalor.setText("EL VALOR A PAGAR ES :" + Integer.toString(valorpagar));
        lbproducto.setText("EL PRODUCTO ES : " + nombreProducto);
        this.nombre=nombre;
        this.cantidad=cantidad;
        this.valorpagar=valorpagar;
        this.nit=nit;
        this.nombreProducto= nombreProducto;
    }
    private FacturaVenta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
       @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbNombrecliente = new javax.swing.JLabel();
        lbnit = new javax.swing.JLabel();
        lbCantidad = new javax.swing.JLabel();
        lbvalor = new javax.swing.JLabel();
        lbproducto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setText("****FACTURA DE VENTA *******");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 70));

        lbNombrecliente.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbNombrecliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 290, 10));
        jPanel1.add(lbnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 160, 10));
        jPanel1.add(lbCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 220, 10));
        jPanel1.add(lbvalor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 190, 20));
        jPanel1.add(lbproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 190, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FacturaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturaVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbCantidad;
    private javax.swing.JLabel lbNombrecliente;
    private javax.swing.JLabel lbnit;
    private javax.swing.JLabel lbproducto;
    private javax.swing.JLabel lbvalor;
    // End of variables declaration//GEN-END:variables
}
