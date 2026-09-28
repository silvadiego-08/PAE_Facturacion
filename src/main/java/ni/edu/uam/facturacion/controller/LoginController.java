package ni.edu.uam.facturacion.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ni.edu.uam.facturacion.dao.UsuarioDAO;
import ni.edu.uam.facturacion.model.Usuario;
import ni.edu.uam.facturacion.util.SceneManager;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @FXML
    private void iniciarSesion() {
        String nombreUsuario = txtUsuario.getText();
        String contrasena = txtPassword.getText();

        if (nombreUsuario == null || nombreUsuario.isBlank()) {
            mostrarMensaje(Alert.AlertType.WARNING, "El usuario es obligatorio.");
            return;
        }

        if (contrasena == null || contrasena.isBlank()) {
            mostrarMensaje(Alert.AlertType.WARNING, "La contraseña es obligatoria.");
            return;
        }

        nombreUsuario = nombreUsuario.trim();

        Usuario usuario;
        try {
            usuario = usuarioDAO.buscarPorNombreUsuario(nombreUsuario);
        } catch (SQLException e) {
            mostrarMensaje(Alert.AlertType.ERROR, "No se pudo validar las credenciales: " + e.getMessage());
            return;
        }

        if (usuario == null) {
            mostrarMensaje(Alert.AlertType.ERROR, "El usuario ingresado no existe.");
            return;
        }

        if (!usuario.isActivo()) {
            mostrarMensaje(Alert.AlertType.ERROR, "El usuario está desactivado. Contacte al administrador.");
            return;
        }

        if (!usuario.getContrasena().equals(contrasena)) {
            mostrarMensaje(Alert.AlertType.ERROR, "La contraseña es incorrecta.");
            return;
        }

        try {
            usuarioDAO.actualizarUltimoLogin(usuario.getId());
        } catch (SQLException e) {
            mostrarMensaje(Alert.AlertType.WARNING, "No se pudo registrar el último acceso: " + e.getMessage());
        }

        try {
            SceneManager.switchTo("/ni/edu/uam/facturacion/fxml/menu-principal.fxml");
        } catch (IOException e) {
            mostrarMensaje(Alert.AlertType.ERROR, "No se pudo abrir el menú principal: " + e.getMessage());
        }
    }

    @FXML
    private void salir() {
        Platform.exit();
    }

    private void mostrarMensaje(Alert.AlertType tipo, String mensaje) {
        Alert alert = new Alert(tipo, mensaje);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}