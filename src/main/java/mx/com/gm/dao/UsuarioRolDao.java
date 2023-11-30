
package mx.com.gm.dao;


import mx.com.gm.domain.Usuario;
import mx.com.gm.domain.UsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRolDao extends JpaRepository<UsuarioRol, Long>{
    
    UsuarioRol findByUsuarioIdUsuarioAndRolIdRol(Long idUsuario, Long idRol);
    
    UsuarioRol findByUsuarioIdUsuario(Long idUsuario);
    
}
