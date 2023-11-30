
package mx.com.gm.servicio;

import java.util.Arrays;
import java.util.List;
import mx.com.gm.dao.ProyectoDao;
import mx.com.gm.dao.ViaticoDao;
import mx.com.gm.domain.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProyectoServiceImpl implements ProyectoService{
    
    @Autowired
    private ProyectoDao proyectoDao;
    
    @Autowired
    private ViaticoDao viaticoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Proyecto> listarProyectos() {
        return (List<Proyecto>) proyectoDao.findAll();
    }

    
    
    @Override
    public void actualizarGastos() {
       List<Proyecto> proyectos = proyectoDao.findAll();
       var viaticos = viaticoDao.findAll();
       int numProyectos = proyectos.size();
        double[] gastos = new double[numProyectos];
        Arrays.fill(gastos, 0.0);
        int i = 0;
        
        for (var p : proyectos) {
            for (var v : viaticos) {
                if (p.getIdProyecto() == v.getProyecto().getIdProyecto()) {
                    gastos[i] += v.getMonto();
                }
            }
            i = i + 1;
        }
        
        for (int j=0;j<numProyectos; j++){
            Proyecto proyecto = proyectos.get(j);
            proyecto.setGasto(gastos[j]);
        }
        
        proyectoDao.saveAll(proyectos);
    }

    @Override
    @Transactional
    public void guardar(Proyecto proyecto) {
        proyectoDao.save(proyecto);
    }

    @Override
    public void eliminar(Proyecto proyecto) {
        proyectoDao.delete(proyecto);
    }

    @Override
    @Transactional(readOnly = true)
    public Proyecto encontrarProyecto(Proyecto proyecto) {
        return proyectoDao.findById(proyecto.getIdProyecto()).orElse(null);
    }

        
 
}
