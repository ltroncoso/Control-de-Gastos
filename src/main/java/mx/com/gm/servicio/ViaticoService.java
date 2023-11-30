
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Viatico;


public interface ViaticoService {
    
    public List<Viatico> listarViaticos();
    
    public void guardar(Viatico viatico);
    
    public void eliminar(Viatico viatico);
    
    public Viatico encontrarViatico(Viatico viatico);
    
}