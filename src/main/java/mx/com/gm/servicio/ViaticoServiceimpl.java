
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.ViaticoDao;
import mx.com.gm.domain.Viatico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ViaticoServiceimpl implements ViaticoService{

    @Autowired 
        private ViaticoDao viaticoDao;
    
    @Override
     @Transactional(readOnly = true)
    public List<Viatico> listarViaticos() {
        return (List<Viatico>) viaticoDao.findAll();
    }
 
    @Override
    @Transactional
    public void guardar(Viatico viatico) {
        viaticoDao.save(viatico);
    }

    @Override
    @Transactional
    public void eliminar(Viatico viatico) {
        viaticoDao.delete(viatico);
    }

    @Override
    @Transactional(readOnly = true)
    public Viatico encontrarViatico(Viatico viatico) {
        return viaticoDao.findById(viatico.getIdViatico()).orElse(null);
    }
    
}
