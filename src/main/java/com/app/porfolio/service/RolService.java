
package com.app.porfolio.service;

import com.app.porfolio.entity.Rol;
import com.app.porfolio.repository.RolRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rol")
@CrossOrigin
public class RolService {
    
    @Autowired
    RolRepository rolRepository;
    
    @GetMapping (path="/buscar")
    public List<Rol> getAllRol(){
        return rolRepository.findAll();
    }
    
    @PostMapping (path ="/guardar")
    public Rol saveRol(@RequestBody Rol rol){
        return rolRepository.save(rol);
    }
    
    @DeleteMapping ( path ="/eliminar/{id}")
    public void deletRol (@PathVariable ("id") int id){
        
        Optional <Rol> rol;
        rol = rolRepository.findById(id);
        if (rol.isPresent()){
            rolRepository.delete(rol.get());
        }
    }
}