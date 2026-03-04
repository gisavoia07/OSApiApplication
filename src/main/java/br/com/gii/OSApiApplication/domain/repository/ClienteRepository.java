package br.com.gii.OSApiApplication.domain.repository;

import br.com.gii.OSApiApplication.domain.model.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sesi3dia
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    List<Cliente> findByNome(String nome);
    List<Cliente> findByNomeContaining(String nome);
    Cliente findByEmail(String email);
    
       
}
