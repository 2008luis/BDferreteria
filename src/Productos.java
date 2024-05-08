
public class Productos {
    int id_producto;
    String nombreProducto;

    public Productos(int id_producto, String nombreProducto) {
        this.id_producto = id_producto;
        this.nombreProducto = nombreProducto;
    }
    public int getId_producto() {
        return id_producto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }
}
