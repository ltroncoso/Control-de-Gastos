package mx.com.gm.servicio;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.dao.UsuarioDao;
import mx.com.gm.domain.Usuario;
import mx.com.gm.domain.UsuarioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Slf4j
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Obtén la autenticación actual directamente en el método
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Usuario usuario = getUsuarioAutenticado(authentication);

        if (usuario == null) {
            // El usuario no está autenticado actualmente, cargamos desde la base de datos
            usuario = usuarioDao.findByUsername(username);

            if (usuario == null) {
                throw new UsernameNotFoundException(username);
            }
        }

        var roles = new ArrayList<GrantedAuthority>();

        for (UsuarioRol usuarioRol : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(usuarioRol.getRol().getRol()));
        }

        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }

    public Usuario getUsuarioAutenticado(Authentication authentication) {
        // Obtén el usuario autenticado actualmente desde la autenticación
        
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            log.info("el usuario esta Autentificado ");
            return usuarioDao.findByUsername(username);
            
        }
        log.info("el usuario no esta autentificado");
        return null;
    }
}