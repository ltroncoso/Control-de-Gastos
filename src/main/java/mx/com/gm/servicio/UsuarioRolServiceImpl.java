
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.UsuarioRolDao;
import mx.com.gm.domain.UsuarioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {

    @Autowired
    private UsuarioRolDao usuarioRolDao;

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioRol> listarRelaciones() {
        return (List<UsuarioRol>) usuarioRolDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(UsuarioRol usuarioRol) {
        usuarioRolDao.save(usuarioRol);
    }

    @Override
    @Transactional
    public void eliminar(UsuarioRol usuarioRol) {
        usuarioRolDao.delete(usuarioRol);
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioRol encontrarViatico(UsuarioRol usuarioRol) {
        return usuarioRolDao.findById(usuarioRol.getIdUsuarioRol()).orElse(null);
    }

    @Override
    public boolean existeAsignacion(Long idUsuario, Long idRol) {
       UsuarioRol asignacion = usuarioRolDao.findByUsuarioIdUsuarioAndRolIdRol(idUsuario, idRol);
       return asignacion!= null;
    }

    @Override
    public boolean asignacionUser(Long idUsuario) {
        UsuarioRol asignacion = usuarioRolDao.findByUsuarioIdUsuario(idUsuario);
        return asignacion!=null;
    }

    

}
