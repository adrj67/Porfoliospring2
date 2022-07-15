
package com.app.porfolio.service;

import com.app.porfolio.entity.Datos;
import com.app.porfolio.entity.Estudios;
import com.app.porfolio.entity.Trabajos;
import com.app.porfolio.entity.Usuario;
import com.app.porfolio.repository.DatosRepository;
import com.app.porfolio.repository.EstudiosRepository;
import com.app.porfolio.repository.TrabajosRepository;
import com.app.porfolio.repository.UsuarioRepository;
import java.util.LinkedList;
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
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsusarioServicio {
    
    @Autowired
    DatosRepository datosRepository;
    
    @Autowired
    EstudiosRepository estudiosRepository;
    
    @Autowired
    TrabajosRepository trabajosRepository;    
    
    @Autowired
    UsuarioRepository usuarioRepository;
    
    
    @GetMapping (path = "/buscar")
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }
   
    @GetMapping ( path = "/buscar/{id}")
    public Optional<Usuario> findById (@PathVariable ("id") int id){
        
        return usuarioRepository.findById(id);
    }
    
    @GetMapping ( path = "/buscar/nombre/{nombre}")
    public List<Usuario> findByNombre (@PathVariable ("nombre") String nombre){
        
        return usuarioRepository.findByNombre(nombre);
    }
    
    
    @PostMapping (path ="/guardar")//OK
    public Usuario saveUsuario(@RequestBody Usuario usuario){
        
        List<Datos> datos = usuario.getDatosList();
        List<Estudios> estudios = usuario.getEstudiosList();
        List<Trabajos> trabajos = usuario.getTrabajosList();
        
        usuario.setDatosList(null);
        usuario.setEstudiosList(null);
        usuario.setTrabajosList(null);
        
        usuario = usuarioRepository.save(usuario);
        
        usuario.setDatosList(new LinkedList<>());
        usuario.setEstudiosList(new LinkedList<>());
        usuario.setTrabajosList(new LinkedList<>());
        
        if (datos != null){
            for (Datos d : datos){
                d.setFkIdUsuario(usuario.getId());
                datosRepository.save(d);
                usuario.getDatosList().add(d);
            }
        }
        if (estudios != null){
            for (Estudios e : estudios){
                e.setFkIdUsuario(usuario.getId());
                estudiosRepository.save(e);
                usuario.getEstudiosList().add(e);
            }
        }
        if (trabajos != null){
            for (Trabajos t : trabajos){
                t.setFkIdUsuario(usuario.getId());
                trabajosRepository.save(t);
                usuario.getTrabajosList().add(t);
            }
        }       
        return usuario;
    }
    
    @DeleteMapping (path ="/eliminar/{id}")
    public void deleteUsuario (@PathVariable ("id") int id){
        
        Optional <Usuario> usuario;
        usuario = usuarioRepository.findById(id);
        
        if (usuario.isPresent()){
            Usuario borrar = usuario.get();
            for(Datos d: borrar.getDatosList()){
                datosRepository.delete(d);
            }
            for(Estudios e: borrar.getEstudiosList()){
                estudiosRepository.delete(e);
            }
            for(Trabajos t: borrar.getTrabajosList()){
                trabajosRepository.delete(t);
            }
            
            usuarioRepository.delete(usuario.get());
        }
    }
    
    
    @PostMapping (path = "/login")
    public Usuario login (@RequestBody Usuario usuario){
        
        List<Usuario> usuarios = usuarioRepository.findByNombreAndClave(usuario.getNombre(), usuario.getClave());
        
        if (!usuarios.isEmpty()){
           return usuarios.get(0);
        }
        return null;
    }
}
