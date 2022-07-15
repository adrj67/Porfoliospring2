
package com.app.porfolio.service;

import com.app.porfolio.entity.Trabajos;
import com.app.porfolio.repository.TrabajosRepository;
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
@RequestMapping("/trabajos")
@CrossOrigin
public class TrabajosService {
    
    @Autowired
    TrabajosRepository trabajosRepository;
    
    @GetMapping (path = "/buscar")
    public List<Trabajos> findAll(){
        return trabajosRepository.findAll();
    }
    
    @GetMapping ( path = "/buscar/usuario/{fkIdUsuario}")
    public List<Trabajos> findByFkIdUsuario (@PathVariable ("fkIdUsuario") int fkIdUsuario){
        
        return trabajosRepository.findByFkIdUsuario (fkIdUsuario);
    }
   
    @GetMapping ( path = "/buscar/{id}")
    public Optional<Trabajos> findById (@PathVariable ("id") int id){
        
        return trabajosRepository.findById(id);
    }
    
    
    @PostMapping (path ="/guardar")
    public Trabajos saveTrabajos(@RequestBody Trabajos trabajos){
        
        return trabajosRepository.save(trabajos);
    }
    
    @DeleteMapping ( path ="/eliminar/{id}")
    public void deleteTrabajos (@PathVariable ("id") int id){
        
        Optional <Trabajos> trabajos;
        trabajos = trabajosRepository.findById(id);
        if (trabajos.isPresent()){
            trabajosRepository.delete(trabajos.get());
        }
    }
}
