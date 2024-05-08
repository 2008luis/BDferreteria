import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Añadire {

   private String nombre;
    private int codigo;
    private String categoria;
    private int cantidad;
    private double precio;
    private double total;

    public Añadire(String nombre, int codigo, String categoria, int cantidad, double precio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = calcularTotal();
    }


    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public double getTotal() {
        return total;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.total = calcularTotal();
        actualizarCantidadEnBD();
    }

    private double calcularTotal() {
        return precio * cantidad;
    }

    public void actualizarCantidadEnBD() {
        try {
            Conexiones conexionInfo = new Conexiones();
            Connection conexion = DriverManager.getConnection(conexionInfo.getUrl(), conexionInfo.getUser(), conexionInfo.getPass());
            String query = "UPDATE productos SET cantidad = ? WHERE codigo = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, cantidad);
            statement.setInt(2, codigo);
            statement.executeUpdate();
            conexion.close(); // Cerrar la conexión después de usarla
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar la cantidad del producto en la base de datos", "", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String venderProducto(int cantidadVendida) {
        if (this.cantidad >= cantidadVendida) {
            this.cantidad -= cantidadVendida;
            this.total = calcularTotal();
            actualizarCantidadEnBD();
            return "Venta realizada con éxito. Cantidad restante: " + this.cantidad;
        } else {
            return "Error: No hay suficiente cantidad de productos para vender.";
        }
    }
    
     public double totalventa() {
        return precio * 2; // Ejemplo: simplemente duplica el precio para el total de venta
    }

}
