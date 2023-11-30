
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.DepartamentoDao;
import mx.com.gm.domain.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartamentoServiceImpl implements DepartamentoService{
    
    @Autowired
    private DepartamentoDao departamentoDao;

    @Override
    public List<Departamento> listarDepartamentos() {
        return (List<Departamento>) departamentoDao.findAll();
    }
    
}
