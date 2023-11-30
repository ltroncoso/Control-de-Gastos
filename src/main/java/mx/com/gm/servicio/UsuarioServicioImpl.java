package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.UsuarioDao;
import mx.com.gm.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{
    
    @Autowired
    private UsuarioDao usuarioDao;

    @Override
     @Transactional(readOnly = true)
    public List<Usuario> listarUsuarios() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    public Usuario encontrarUsuario(Usuario usuario) {
            return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    public boolean esPasswordEncriptada(String password) {
        return password.startsWith("$2a$");
    }

    @Override
    public String encriptarPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
    
}
