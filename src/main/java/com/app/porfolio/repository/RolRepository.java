
package com.app.porfolio.repository;

import com.app.porfolio.entity.Rol;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository ("rolRepository")
public interface RolRepository extends JpaRepository<Rol,Serializable> {
    
}
