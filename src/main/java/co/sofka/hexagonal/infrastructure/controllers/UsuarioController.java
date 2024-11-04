package co.sofka.hexagonal.infrastructure.controllers;

import co.sofka.hexagonal.application.services.UsuarioService;
import co.sofka.hexagonal.domain.models.DinBodyResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<DinBodyResponse> createUsuario(@RequestBody DinBodyResponse dinBodyResponse){
        DinBodyResponse createdDinBodyResponse = usuarioService.createUsuario(dinBodyResponse);
        return new ResponseEntity<>(createdDinBodyResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DinBodyResponse> getUsuarioById(@PathVariable Integer id){
    return usuarioService.getUsuario(id)
            .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping
    public ResponseEntity<List<DinBodyResponse>> getAllUsuarios(){
        List<DinBodyResponse> dinBodyResponses = usuarioService.getAllUsuarios();
        return new ResponseEntity<>(dinBodyResponses, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DinBodyResponse> updateUsuario(@PathVariable Integer id,
                                                         @RequestBody DinBodyResponse updatedDinBodyResponse){
        return usuarioService.updateUsuario(updatedDinBodyResponse)
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

   @DeleteMapping("/{usuarioId}")
    public ResponseEntity deleteUsuario(@PathVariable Integer id){
        if(usuarioService.deleteUsuario(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }

}
