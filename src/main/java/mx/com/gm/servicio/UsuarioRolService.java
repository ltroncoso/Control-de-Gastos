
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.UsuarioRol;

public interface UsuarioRolService {
    
    public List<UsuarioRol> listarRelaciones();
    
    public void guardar(UsuarioRol usuarioRol);
    
    public void eliminar(UsuarioRol usuarioRol);
    
    public UsuarioRol encontrarViatico(UsuarioRol usuarioRol);
    
    public boolean existeAsignacion(Long idUsuario,Long idRol);
    
    public boolean asignacionUser(Long idUsuario);
}
