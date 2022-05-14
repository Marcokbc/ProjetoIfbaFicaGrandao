package ifba.dev.projetoFicaGrandao.controller;

import ifba.dev.projetoFicaGrandao.domain.Instrutor;
import ifba.dev.projetoFicaGrandao.service.InstrutorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("instrutores")
@Log4j2
@RequiredArgsConstructor
public class InstrutorController {
    private final InstrutorService instrutorService;

    @GetMapping
    public ResponseEntity<List<Instrutor>> list(){
        return ResponseEntity.ok(instrutorService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Instrutor> findById(@PathVariable long id){
        return ResponseEntity.ok(instrutorService.findById(id));
    }
    
    @PostMapping
    public ResponseEntity<Instrutor> save(@RequestBody Instrutor instrutor){
        return new ResponseEntity<>(instrutorService.save(instrutor), HttpStatus.CREATED);
    }
}
