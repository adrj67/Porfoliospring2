
package com.app.porfolio.service;

import com.app.porfolio.entity.Estudios;
import com.app.porfolio.repository.EstudiosRepository;
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
@RequestMapping("/estudios")
@CrossOrigin
public class EstudiosService {
    
    @Autowired
    EstudiosRepository estudiosRepository;
    
    @GetMapping (path = "/buscar")
    public List<Estudios> findAll(){
        return estudiosRepository.findAll();
    }
    
    @GetMapping ( path = "/buscarest/usuario/{fkIdUsuario}")
    public List<Estudios> findByFkIdUsuario (@PathVariable ("fkIdUsuario") int fkIdUsuario){
        
        return estudiosRepository.findByFkIdUsuario (fkIdUsuario);
    }
   
    @GetMapping ( path = "/buscar/{id}")
    public Optional<Estudios> findById (@PathVariable ("id") int id){
        
        return estudiosRepository.findById(id);
    }
    
    
    @PostMapping (path ="/guardar")
    public Estudios saveEstudios(@RequestBody Estudios estudios){
        
        return estudiosRepository.save(estudios);
    }
    
    @DeleteMapping ( path ="/eliminar/{id}")
    public void deleteEstudios (@PathVariable ("id") int id){
        
        Optional <Estudios> estudios;
        estudios = estudiosRepository.findById(id);
        if (estudios.isPresent()){
            estudiosRepository.delete(estudios.get());
        }
    }
}
