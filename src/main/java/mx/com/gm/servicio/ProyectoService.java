
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Proyecto;

public interface ProyectoService {
    
    public List<Proyecto> listarProyectos();
    
    public void actualizarGastos();
    
    public void guardar(Proyecto proyecto);
    
    public void eliminar(Proyecto proyecto);
    
    public Proyecto encontrarProyecto(Proyecto proyecto);
    
}
