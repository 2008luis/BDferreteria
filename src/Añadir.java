import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class Añadir extends javax.swing.JFrame {

  
    

    String nombre, categoria;
    int codigo, cantidad;
    double precio, precioVenta;
    int emplea, ides;
    String usar;

    public Añadir(int idempleados, String usuarios, int id) {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.emplea = idempleados;
        this.usar = usuarios;
        this.ides = id;
        Conexiones con = new Conexiones();
        mostrarDatos();
        
    }

    private Añadir() {
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtnombreProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtcodigoProducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtcategoriaProducto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtcantidadProducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaregistroProducto = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtprecioProducto = new javax.swing.JTextField();
        btnAgregarProducto = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnmodificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnDevolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 172, 130));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("NOMBRE");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 80, -1));

        txtnombreProducto.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(txtnombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 140, 30));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("CODIGO");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, -1));

        txtcodigoProducto.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(txtcodigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 140, 30));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("CATEGORIA ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 20));

        txtcategoriaProducto.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(txtcategoriaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 140, 30));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("CANTIDAD");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        txtcantidadProducto.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(txtcantidadProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 140, 30));

        tablaregistroProducto.setBackground(new java.awt.Color(204, 204, 204));
        tablaregistroProducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaregistroProducto.setForeground(new java.awt.Color(0, 0, 0));
        tablaregistroProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaregistroProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaregistroProducto.setGridColor(new java.awt.Color(255, 51, 51));
        tablaregistroProducto.setSelectionBackground(new java.awt.Color(153, 204, 255));
        tablaregistroProducto.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tablaregistroProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaregistroProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaregistroProducto);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 1010, 370));

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("PRECIO");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, -1, -1));

        txtprecioProducto.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(txtprecioProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 140, 30));

        btnAgregarProducto.setBackground(new java.awt.Color(102, 204, 255));
        btnAgregarProducto.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnAgregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Mas.png"))); // NOI18N
        btnAgregarProducto.setText("AGREGAR");
        btnAgregarProducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, 190, 60));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("AÑADIR PRODUCTO");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnmodificar.setBackground(new java.awt.Color(102, 204, 255));
        btnmodificar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnmodificar.setForeground(new java.awt.Color(255, 255, 255));
        btnmodificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar.png"))); // NOI18N
        btnmodificar.setText("MODIFICAR");
        btnmodificar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnmodificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 190, 60));

        btnEliminar.setBackground(new java.awt.Color(102, 204, 255));
        btnEliminar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar2.0.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 190, 60));

        btnBuscar.setBackground(new java.awt.Color(102, 204, 255));
        btnBuscar.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 190, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo ferreteria.jpeg"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 150, 150));

        btnDevolver.setBackground(new java.awt.Color(255, 51, 102));
        btnDevolver.setForeground(new java.awt.Color(0, 0, 0));
        btnDevolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Devolver.png"))); // NOI18N
        btnDevolver.setText("DEVOLVER");
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnDevolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 190, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        if (txtnombreProducto.getText().isEmpty()
                || txtcodigoProducto.getText().isEmpty()
                || txtcategoriaProducto.getText().isEmpty()
                || txtprecioProducto.getText().isEmpty()
                || txtcantidadProducto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hay campos vacios");
            return;
        }
        if (!esNumerico(txtcodigoProducto.getText())
                || !esNumerico(txtcantidadProducto.getText())
                || !esNumerico(txtprecioProducto.getText())) {
            JOptionPane.showMessageDialog(null, "los campos de codigo,cantidad,precio son numericos");
            return;
        }
        guardarProductos();
        txtcantidadProducto.setText("");
        txtcategoriaProducto.setText("");
        txtcodigoProducto.setText("");
        txtnombreProducto.setText("");
        txtprecioProducto.setText("");
    }//GEN-LAST:event_btnAgregarProductoActionPerformed
    
    
    private void tablaregistroProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaregistroProductoMouseClicked
        //esta parte del codigo es para que presione un valor en la tabla y llene los campos

        int seleccionar = tablaregistroProducto.rowAtPoint(evt.getPoint());
        txtnombreProducto.setText(String.valueOf(tablaregistroProducto.getValueAt(seleccionar, 0)));
        txtcodigoProducto.setText(String.valueOf(tablaregistroProducto.getValueAt(seleccionar, 1)));
        txtcategoriaProducto.setText(String.valueOf(tablaregistroProducto.getValueAt(seleccionar, 2)));
        txtcantidadProducto.setText(String.valueOf(tablaregistroProducto.getValueAt(seleccionar, 3)));
        txtprecioProducto.setText(String.valueOf(tablaregistroProducto.getValueAt(seleccionar, 4)));
    }//GEN-LAST:event_tablaregistroProductoMouseClicked

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
     
            
     Inicio ini = new Inicio(emplea,usar,ides);
        ini.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnDevolverActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
   Conexiones con = new Conexiones();
        try (Connection connection = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPass())) {
   
            String nuevoNombre = txtnombreProducto.getText();
    int nuevaCantidad = Integer.parseInt(txtcantidadProducto.getText());
    double nuevoPrecio = Double.parseDouble(txtprecioProducto.getText());
    

    // Ejecutar la consul
    String sql = "UPDATE producto SET nombreProducto     = ?, cantidad = ?, precio = ? WHERE id_producto = ?";
    PreparedStatement stmt = connection.prepareStatement(sql);
    stmt.setString(1, nuevoNombre);
    stmt.setInt(2, nuevaCantidad);
    stmt.setDouble(3, nuevoPrecio);
    int filasActualizadas = stmt.executeUpdate();
    if (filasActualizadas > 0) {
        JOptionPane.showMessageDialog(rootPane, "Producto actualizado exitosamente");
    } else {
        JOptionPane.showMessageDialog(rootPane, "No se pudo actualizar el producto");
    }
} catch (SQLException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(rootPane, "Error al actualizar el producto: " + e.getMessage());
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(rootPane, "Por favor ingrese valores numéricos válidos para la cantidad y el precio");
}
    }//GEN-LAST:event_btnmodificarActionPerformed
   public void guardarProductos() {
    codigo = Integer.parseInt(txtcodigoProducto.getText());
    cantidad = Integer.parseInt(txtcantidadProducto.getText());
    precio = Double.parseDouble(txtprecioProducto.getText());
    nombre = txtnombreProducto.getText().toUpperCase();
    categoria = txtcategoriaProducto.getText().toUpperCase();
    precioVenta = precio * 2;
    Conexiones con = new Conexiones();
    try {
        Connection connection = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPass());
        PreparedStatement stmtExiste = connection.prepareStatement("call validarProductoExistente(?,?)");
        stmtExiste.setString(1, nombre);
        stmtExiste.setInt(2, codigo);
        ResultSet rsExiste = stmtExiste.executeQuery();
        
        rsExiste.next();
        int totalExistente = rsExiste.getInt("total");
        if (totalExistente > 0) {
            JOptionPane.showMessageDialog(rootPane, "El producto ya está registrado, o el código ya tiene producto");
        } else {
            PreparedStatement stmt = connection.prepareStatement("call agregarProducto(?,?,?,?,?,?)");
            stmt.setString(1, nombre);
            stmt.setInt(2, codigo);
            stmt.setString(3, categoria);
            stmt.setDouble(4, precio);
            stmt.setDouble(5, precioVenta);
            stmt.setInt(6, cantidad);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Guardado con éxito");
            mostrarDatos();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(rootPane, "Error de base de datos: " + e.getMessage());
    }
}
    public void mostrarDatos() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            tablaregistroProducto.setModel(model);
            Conexiones con = new Conexiones();
            try (Connection connection = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPass())) {

                try (PreparedStatement stmt = connection.prepareCall("call mostrardatosProducto()")) {
                    ResultSet ps = stmt.executeQuery();
                    ResultSetMetaData metaData = ps.getMetaData();

                    for (int i = 1; i <= metaData.getColumnCount(); i++) {
                        model.addColumn(metaData.getColumnLabel(i));
                    }
                    while (ps.next()) {
                        Object[] filas = new Object[metaData.getColumnCount()];
                        for (int i = 0; i < metaData.getColumnCount(); i++) {
                            filas[i] = ps.getObject(i + 1);
                        }
                        model.addRow(filas);
                    }
                    ps.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Error de base de datos: " + e.getMessage());
        }
    }

    public boolean esNumerico(String cadena) {
        if (cadena == null || cadena.isEmpty()) {
            return false;
        }
        for (char c : cadena.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
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
            java.util.logging.Logger.getLogger(Añadir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Añadir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Añadir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Añadir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Añadir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaregistroProducto;
    private javax.swing.JTextField txtcantidadProducto;
    private javax.swing.JTextField txtcategoriaProducto;
    private javax.swing.JTextField txtcodigoProducto;
    private javax.swing.JTextField txtnombreProducto;
    private javax.swing.JTextField txtprecioProducto;
    // End of variables declaration//GEN-END:variables
}
