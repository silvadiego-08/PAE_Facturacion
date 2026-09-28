package ni.edu.uam.facturacion.dao;

import ni.edu.uam.facturacion.model.Usuario;
import ni.edu.uam.facturacion.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class UsuarioDAO {

    public Usuario buscarPorNombreUsuario(String nombreUsuario) throws SQLException {

        String sql = """
                SELECT id, nombre_usuario, correo, contrasena, nombre_completo, activo
                FROM usuarios
                WHERE nombre_usuario = ?
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, nombreUsuario);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapear(rs);
                }
            }
        }

        return null;
    }

    public void actualizarUltimoLogin(int id) throws SQLException {

        String sql = """
                UPDATE usuarios
                SET ultimo_login = ?
                WHERE id = ?
                """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setTimestamp(1, Timestamp.from(java.time.Instant.now()));
            ps.setInt(2, id);

            ps.executeUpdate();
        }
    }

    private Usuario mapear(ResultSet rs) throws SQLException {

        return new Usuario(
                rs.getInt("id"),
                rs.getString("nombre_usuario"),
                rs.getString("correo"),
                rs.getString("contrasena"),
                rs.getString("nombre_completo"),
                rs.getBoolean("activo")
        );
    }
}