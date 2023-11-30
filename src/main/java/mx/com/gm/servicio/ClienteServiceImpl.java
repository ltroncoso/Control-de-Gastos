
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.ClienteDao;
import mx.com.gm.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteDao clienteDao;

    @Override
    public List<Cliente> listarClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }
    
}