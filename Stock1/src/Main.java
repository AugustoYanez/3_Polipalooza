import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/stock";
        String username = "alumno";
        String password = "alumnoipm";


// PROCEDIMIENTO 1

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Crear el objeto CallableStatement para ejecutar el procedimiento almacenado
            String procedureCall = "{ CALL productoPorPedido() }";
            CallableStatement statement = connection.prepareCall(procedureCall);

            // Ejecutar el procedimiento almacenado
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el ResultSet y mostrar los resultados
            while (resultSet.next()) {
                String codProducto = resultSet.getString("codProducto");
                String descripcion = resultSet.getString("descripcion");
                int cantidad = resultSet.getInt("cantidad");
                double precioUnitario = resultSet.getDouble("precioUnitario");

                System.out.println("CodProducto: " + codProducto);
                System.out.println("Descripcion: " + descripcion);
                System.out.println("Cantidad: " + cantidad);
                System.out.println("Precio Unitario: " + precioUnitario);
                System.out.println("----------------------------------");
            }

            // Cerrar el ResultSet, CallableStatement y la conexión
            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("Procedimiento 1 almacenado ejecutado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // PROCEDIMIENTO 2

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "CALL actualizarStockDiario()";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.execute();

                // Recuperar los resultados
                String selectSql = "SELECT * FROM stock.producto";
                try (PreparedStatement selectStatement = connection.prepareStatement(selectSql);
                     ResultSet resultSet = selectStatement.executeQuery()) {
                    System.out.println("Resultados:");
                    while (resultSet.next()) {
                        int codProducto = resultSet.getInt("codProducto");
                        String descripcion = resultSet.getString("descripcion");
                        int stock = resultSet.getInt("stock");

                        System.out.println("Código de Producto: " + codProducto);
                        System.out.println("Descripción: " + descripcion);
                        System.out.println("Stock: " + stock);
                        System.out.println("--------------------------");
                    }
                }

                System.out.println("Procedimiento 2 almacenado ejecutado exitosamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

// PROCEDIMIENTO 3

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Crear el objeto CallableStatement para ejecutar el procedimiento almacenado
            String procedureCall = "{ CALL listarProductosSinStockNoCompradosUltimos3Meses() }";
            CallableStatement statement = connection.prepareCall(procedureCall);

            // Ejecutar el procedimiento almacenado
            ResultSet resultSet = statement.executeQuery();

            // Iterar sobre los resultados y mostrarlos por pantalla
            while (resultSet.next()) {
                int codProducto = resultSet.getInt("codProducto");
                String descripcion = resultSet.getString("descripcion");
                int stock = resultSet.getInt("stock");

                System.out.println("Código del Producto: " + codProducto);
                System.out.println("Descripción: " + descripcion);
                System.out.println("Stock: " + stock);
                System.out.println("--------------------");
            }

            // Cerrar el ResultSet, el CallableStatement y la conexión
            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("Procedimiento 3 almacenado ejecutado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }






























    }











        // obtener columnas de una tabla (STOCK)

        //  ArrayList<String> clientes = new ArrayList<>();

        // clientes = bdd.obtenerColumnasDeUnaTabla("producto");
//int i = 0;
        //     for (String f : clientes){

        //      System.out.println( "TABLA" + i++ +": " + f);

        //  }





    }
