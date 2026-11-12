package Exception;


public class EquipoNoDisponibleException extends PrestamoException {
    public EquipoNoDisponibleException(String codigo, String mensajeUsuario, String mensajeTecnico) {
        super(codigo, mensajeUsuario, mensajeTecnico);
    }
}
