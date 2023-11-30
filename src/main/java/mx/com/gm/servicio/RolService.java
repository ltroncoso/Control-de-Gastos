
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Rol;


public interface RolService {
    
    public List<Rol> listarRoles();
    
    public Rol buscarPorId(Long idRol);
    
}
