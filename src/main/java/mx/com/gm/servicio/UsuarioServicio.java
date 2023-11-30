
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Usuario;

public interface UsuarioServicio {
    
    public List<Usuario> listarUsuarios();
    
    public void guardar(Usuario usuario);
    
    public void eliminar(Usuario usuario);
    
    public Usuario encontrarUsuario(Usuario usuario);
    
    public boolean esPasswordEncriptada(String password);
    
    public String encriptarPassword(String password);
    
}
