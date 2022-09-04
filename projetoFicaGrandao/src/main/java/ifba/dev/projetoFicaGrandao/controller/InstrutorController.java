package ifba.dev.projetoFicaGrandao.controller;

import ifba.dev.projetoFicaGrandao.domain.Instrutor;
import ifba.dev.projetoFicaGrandao.requests.InstrutorPostRequestBody;
import ifba.dev.projetoFicaGrandao.requests.InstrutorPutRequestBody;
import ifba.dev.projetoFicaGrandao.service.InstrutorService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("instrutores")
@RequiredArgsConstructor
public class InstrutorController {
	private final InstrutorService instrutorService;

    @GetMapping
    public ResponseEntity<List<Instrutor>> list(){
        return ResponseEntity.ok(instrutorService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Instrutor> findById(@PathVariable long id){
        return ResponseEntity.ok(instrutorService.findByIdOrThrowBadRequestException(id));
    }
    
    @GetMapping(path = "/find")
    public ResponseEntity<List<Instrutor>> findByNome(@RequestParam String nome){
        return ResponseEntity.ok(instrutorService.findByNome(nome));
    }
    
    @PostMapping
    public ResponseEntity<Instrutor> save(@RequestBody @Valid InstrutorPostRequestBody instrutorPostRequestBody){
        return new ResponseEntity<>(instrutorService.save(instrutorPostRequestBody), HttpStatus.CREATED);
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
    	instrutorService.delete(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody InstrutorPutRequestBody instrutorPutRequestBody){
    	instrutorService.replace(instrutorPutRequestBody);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
