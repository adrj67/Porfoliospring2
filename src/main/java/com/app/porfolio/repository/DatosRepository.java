
package com.app.porfolio.repository;

import com.app.porfolio.entity.Datos;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository ("datosRepository")
public interface DatosRepository extends JpaRepository<Datos, Serializable>{
    
    public List<Datos> findByFkIdUsuario(int fkidusuario);

}
