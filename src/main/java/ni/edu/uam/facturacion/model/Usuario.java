package ni.edu.uam.facturacion.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {

    private Integer id;
    private String nombreUsuario;
    private String correo;
    private String contrasena;
    private String nombreCompleto;
    private boolean activo;

    @Override
    public String toString() {
        return nombreUsuario;
    }
}