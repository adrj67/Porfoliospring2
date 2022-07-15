
package com.app.porfolio.repository;

import com.app.porfolio.entity.Usuario;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository ("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable>{
    
    public List<Usuario> findByNombreAndClave (String nombre, String clave);
    
    public List<Usuario> findByNombre(String nombre);
   
}