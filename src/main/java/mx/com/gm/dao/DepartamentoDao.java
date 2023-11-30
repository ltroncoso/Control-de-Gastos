
package mx.com.gm.dao;


import mx.com.gm.domain.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartamentoDao extends JpaRepository<Departamento,Long>{
    
}
