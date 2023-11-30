
package mx.com.gm.dao;

import mx.com.gm.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao extends JpaRepository<Cliente, Long> {
    
}
