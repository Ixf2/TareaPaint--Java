package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public final class Modelo {

    private Connection conexion;

    private final String usuario = "root";
    private final String password = "";

    public Modelo() {
        crearBaseDatos();
        conectarBaseDatos();
        crearTablas();
    }

    private Connection conectar(String url) throws SQLException {
        return DriverManager.getConnection(url, usuario, password);
    }

    public void crearBaseDatos() {
        try {
            conexion = conectar("jdbc:mariadb://localhost:3306/");
            Statement st = conexion.createStatement();
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS Paint");
            System.out.println("Base de datos Paint creada o que ya existe");
        } catch (SQLException e) {
            System.out.println("Error al crear la base de datos: " + e.getMessage());
        }
    }

    public void conectarBaseDatos() {
        try {
            conexion = conectar("jdbc:mariadb://localhost:3306/Paint");
            System.out.println("Conectado a la base de datos Paint");

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos Paint: " + e.getMessage());
        }
    }

    public void crearTablas() {
        try {
            Statement st = conexion.createStatement();

            st.executeUpdate("CREATE TABLE IF NOT EXISTS dibujos ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "nombre VARCHAR(100)"
                    + ")");

            st.executeUpdate("CREATE TABLE IF NOT EXISTS figuras ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "dibujo_id INT,"
                    + "tipo VARCHAR(50),"
                    + "orden_figura INT,"
                    + "color_borde VARCHAR(20),"
                    + "color_relleno VARCHAR(20),"
                    + "relleno BOOLEAN,"
                    + "FOREIGN KEY (dibujo_id) REFERENCES dibujos(id) ON DELETE CASCADE"
                    + ")");

            st.executeUpdate("CREATE TABLE IF NOT EXISTS puntos ("
                    + "figura_id INT PRIMARY KEY,"
                    + "x INT,"
                    + "y INT,"
                    + "FOREIGN KEY (figura_id) REFERENCES figuras(id) ON DELETE CASCADE"
                    + ")");

            st.executeUpdate("CREATE TABLE IF NOT EXISTS rectas ("
                    + "figura_id INT PRIMARY KEY,"
                    + "x1 INT,"
                    + "y1 INT,"
                    + "x2 INT,"
                    + "y2 INT,"
                    + "FOREIGN KEY (figura_id) REFERENCES figuras(id) ON DELETE CASCADE"
                    + ")");

            st.executeUpdate("CREATE TABLE IF NOT EXISTS circulos ("
                    + "figura_id INT PRIMARY KEY,"
                    + "xCentro INT,"
                    + "yCentro INT,"
                    + "radio INT,"
                    + "FOREIGN KEY (figura_id) REFERENCES figuras(id) ON DELETE CASCADE"
                    + ")");

            st.executeUpdate("CREATE TABLE IF NOT EXISTS poligonos_regulares ("
                    + "figura_id INT PRIMARY KEY,"
                    + "xCentro INT,"
                    + "yCentro INT,"
                    + "radio INT,"
                    + "lados INT,"
                    + "anguloInicial DOUBLE,"
                    + "FOREIGN KEY (figura_id) REFERENCES figuras(id) ON DELETE CASCADE"
                    + ")");

            st.executeUpdate("CREATE TABLE IF NOT EXISTS vertices_poligonos ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "figura_id INT,"
                    + "x INT,"
                    + "y INT,"
                    + "orden_vertice INT,"
                    + "FOREIGN KEY (figura_id) REFERENCES figuras(id) ON DELETE CASCADE"
                    + ")");

            System.out.println("Tablas creadas correctamente");

        } catch (SQLException e) {
            System.out.println("Error al crear tablas: " + e.getMessage());
        }

    }

    //CRUD
    //CREATE 
    public int guardarDibujo(String nombre) {
        try {
            String sql = "INSERT INTO dibujos(nombre) VALUES (?)";
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, nombre);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                System.out.println("Dibujo guardado correctamente");
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Error al guardar dibujo: " + e.getMessage());
        }

        return -1;
    }

    public int guardarFigura(int dibujoId, String tipo, int orden, String colorBorde, String colorRelleno, boolean relleno) {
        try {
            String sql = "INSERT INTO figuras(dibujo_id, tipo, orden_figura, color_borde, color_relleno, relleno) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, dibujoId);
            ps.setString(2, tipo);
            ps.setInt(3, orden);
            ps.setString(4, colorBorde);
            ps.setString(5, colorRelleno);
            ps.setBoolean(6, relleno);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Error al guardar figura: " + e.getMessage());
        }

        return -1;
    }

    public void guardarPunto(int figuraId, int x, int y) {
        try {
            String sql = "INSERT INTO puntos(figura_id, x, y) VALUES (?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, figuraId);
            ps.setInt(2, x);
            ps.setInt(3, y);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al guardar punto: " + e.getMessage());
        }
    }

    public void guardarRecta(int figuraId, int x1, int y1, int x2, int y2) {
        try {
            String sql = "INSERT INTO rectas(figura_id, x1, y1, x2, y2) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, figuraId);
            ps.setInt(2, x1);
            ps.setInt(3, y1);
            ps.setInt(4, x2);
            ps.setInt(5, y2);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al guardar recta: " + e.getMessage());
        }
    }

    public void guardarCirculo(int figuraId, int xCentro, int yCentro, int radio) {
        try {
            String sql = "INSERT INTO circulos(figura_id, xCentro, yCentro, radio) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, figuraId);
            ps.setInt(2, xCentro);
            ps.setInt(3, yCentro);
            ps.setInt(4, radio);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al guardar círculo: " + e.getMessage());
        }
    }

    public void guardarPoligonoRegular(int figuraId, int xCentro, int yCentro, int radio, int lados, double anguloInicial) {
        try {
            String sql = "INSERT INTO poligonos_regulares(figura_id, xCentro, yCentro, radio, lados, anguloInicial) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, figuraId);
            ps.setInt(2, xCentro);
            ps.setInt(3, yCentro);
            ps.setInt(4, radio);
            ps.setInt(5, lados);
            ps.setDouble(6, anguloInicial);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al guardar polígono regular: " + e.getMessage());
        }
    }

    public void guardarVerticePoligono(int figuraId, int x, int y, int ordenVertice) {
        try {
            String sql = "INSERT INTO vertices_poligonos(figura_id, x, y, orden_vertice) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, figuraId);
            ps.setInt(2, x);
            ps.setInt(3, y);
            ps.setInt(4, ordenVertice);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al guardar vértice: " + e.getMessage());
        }
    }

    //READ
    public void cargarDibujos() {
        try {
            String sql = "SELECT * FROM dibujos";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " | Nombre: " + rs.getString("nombre"));
            }

        } catch (SQLException e) {
            System.out.println("Error al cargar dibujos: " + e.getMessage());
        }
    }

    public void cargarFigurasDeDibujo(int dibujoId) {
        try {
            String sql = "SELECT * FROM figuras WHERE dibujo_id=? ORDER BY orden_figura ASC";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, dibujoId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int figuraId = rs.getInt("id");
                String tipo = rs.getString("tipo");

                System.out.println("Figura ID: " + figuraId + " | Tipo: " + tipo);

                if (tipo.equals("PUNTO")) {
                    cargarPunto(figuraId);
                } else if (tipo.equals("RECTA")) {
                    cargarRecta(figuraId);
                } else if (tipo.equals("CIRCULO")) {
                    cargarCirculo(figuraId);
                } else if (tipo.equals("POLIGONO_REGULAR")) {
                    cargarPoligonoRegular(figuraId);
                } else if (tipo.equals("POLIGONO_IRREGULAR")) {
                    cargarVerticesPoligono(figuraId);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al cargar figuras: " + e.getMessage());
        }
    }

    private void cargarPunto(int figuraId) {
        try {
            String sql = "SELECT * FROM puntos WHERE figura_id=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, figuraId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Punto: x=" + rs.getInt("x") + " y=" + rs.getInt("y"));
            }

        } catch (SQLException e) {
            System.out.println("Error al cargar punto: " + e.getMessage());
        }
    }

    private void cargarRecta(int figuraId) {
        try {
            String sql = "SELECT * FROM rectas WHERE figura_id=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, figuraId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Recta: x1=" + rs.getInt("x1") + " y1=" + rs.getInt("y1")
                        + " x2=" + rs.getInt("x2") + " y2=" + rs.getInt("y2"));
            }

        } catch (SQLException e) {
            System.out.println("Error al cargar recta: " + e.getMessage());
        }
    }

    private void cargarCirculo(int figuraId) {
        try {
            String sql = "SELECT * FROM circulos WHERE figura_id=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, figuraId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Círculo: xCentro=" + rs.getInt("xCentro")
                        + " yCentro=" + rs.getInt("yCentro")
                        + " radio=" + rs.getInt("radio"));
            }

        } catch (SQLException e) {
            System.out.println("Error al cargar círculo: " + e.getMessage());
        }
    }

    private void cargarPoligonoRegular(int figuraId) {
        try {
            String sql = "SELECT * FROM poligonos_regulares WHERE figura_id=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, figuraId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Polígono regular: xCentro=" + rs.getInt("xCentro")
                        + " yCentro=" + rs.getInt("yCentro")
                        + " radio=" + rs.getInt("radio")
                        + " lados=" + rs.getInt("lados")
                        + " angulo=" + rs.getDouble("anguloInicial"));
            }

        } catch (SQLException e) {
            System.out.println("Error al cargar polígono regular: " + e.getMessage());
        }
    }

    private void cargarVerticesPoligono(int figuraId) {
        try {
            String sql = "SELECT * FROM vertices_poligonos WHERE figura_id=? ORDER BY orden_vertice ASC";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, figuraId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Vértice: x=" + rs.getInt("x") + " y=" + rs.getInt("y"));
            }

        } catch (SQLException e) {
            System.out.println("Error al cargar vértices: " + e.getMessage());
        }
    }

    //UPDATE
    public void modificarDibujo(int id, String nuevoNombre) {
        try {
            String sql = "UPDATE dibujos SET nombre=? WHERE id=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nuevoNombre);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("Dibujo modificado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al modificar: " + e.getMessage());
        }
    }

    //DELETE
    public void borrarDibujo(int id) {
        try {
            String sql = "DELETE FROM dibujos WHERE id=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Dibujo eliminado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al borrar: " + e.getMessage());
        }
    }

}
