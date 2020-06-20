package edu.academik.clase02.jsp001.controlador;

import edu.academik.clase02.jsp001.modelo.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario Batres
 */
public class ConnectionManager {

    private static Connection connection = null;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {

        }
    }

    public static synchronized Connection getConnection() throws SQLException {

        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/redis_inisa", "postgres", "felicia");
        }

        return connection;
    }

    //Podría estar en otra clase llamada ProductoServicio
    public List<Producto> buscarProductos() throws SQLException {

        List<Producto> productoList = new ArrayList<>();

        String sql = "select * from productos";

        try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {

            try (ResultSet rs = pstm.executeQuery()) {

                while (rs.next()) {
                    Producto producto = new Producto();

                    producto.setId(rs.getInt("producto_id"));
                    producto.setNombre(rs.getString("descripcion"));

                    productoList.add(producto);
                }
            }

        }

        return productoList;
    }

}
