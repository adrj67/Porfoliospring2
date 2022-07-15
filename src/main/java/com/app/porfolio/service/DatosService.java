
package com.app.porfolio.service;

import com.app.porfolio.entity.Datos;
import com.app.porfolio.repository.DatosRepository;
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
@RequestMapping("/datos")
@CrossOrigin
public class DatosService {
    
    @Autowired
    DatosRepository datosRepository;
    
    @GetMapping (path = "/buscar")
    public List<Datos> findAll(){
        return datosRepository.findAll();
    }
   
    @GetMapping ( path = "/buscar/usuario/{fkIdUsuario}")
    public List<Datos> findByFkIdUsuario (@PathVariable ("fkIdUsuario") int fkIdUsuario){
        return datosRepository.findByFkIdUsuario (fkIdUsuario);
    }
    
    @GetMapping ( path = "/buscar/{id}")
    public Optional <Datos> findById (@PathVariable ("id") int id){
        return datosRepository.findById (id);
    }
    
    @PostMapping (path ="/guardar")
    public Datos saveDatos(@RequestBody Datos datos){
        return datosRepository.save(datos);
    }
    
    @DeleteMapping ( path ="/eliminar/{id}")
    public void deleteDatos (@PathVariable ("id") int id){
        
        Optional <Datos> datos;
        datos = datosRepository.findById(id);
        if (datos.isPresent()){
            datosRepository.delete(datos.get());
        }
       
    }
}
