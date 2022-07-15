
package com.app.porfolio.repository;

import com.app.porfolio.entity.Estudios;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository ("estudiosRepository")
public interface EstudiosRepository extends JpaRepository<Estudios, Serializable>{
    
   public List<Estudios> findByFkIdUsuario(int fkidusuario); 
   
   
}
