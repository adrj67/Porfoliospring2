
package com.app.porfolio.repository;

import com.app.porfolio.entity.Trabajos;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository ("trabajosRepository")
public interface TrabajosRepository extends JpaRepository<Trabajos, Serializable>{
    public List<Trabajos> findByFkIdUsuario(int fkidusuario);
    
}
