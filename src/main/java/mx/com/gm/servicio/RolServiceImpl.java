
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.RolDao;
import mx.com.gm.domain.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RolServiceImpl implements RolService{
    
    @Autowired
    private RolDao rolDao;

    @Override
    public List<Rol> listarRoles() {
        return (List<Rol>) rolDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Rol buscarPorId(Long idRol) {
        return rolDao.findById(idRol).orElse(null);
    }
    
}
