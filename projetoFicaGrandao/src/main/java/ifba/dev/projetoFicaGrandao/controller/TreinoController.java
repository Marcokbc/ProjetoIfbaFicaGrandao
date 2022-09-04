package ifba.dev.projetoFicaGrandao.controller;

import ifba.dev.projetoFicaGrandao.domain.Treino;
import ifba.dev.projetoFicaGrandao.requests.TreinoPostRequestBody;
import ifba.dev.projetoFicaGrandao.requests.TreinoPutRequestBody;
import ifba.dev.projetoFicaGrandao.service.TreinoService;
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
@RequestMapping("treinos")
@RequiredArgsConstructor
public class TreinoController {
	private final TreinoService treinoService;

    @GetMapping
    public ResponseEntity<List<Treino>> list(){
        return ResponseEntity.ok(treinoService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Treino> findById(@PathVariable long id){
        return ResponseEntity.ok(treinoService.findByIdOrThrowBadRequestException(id));
    }
    
    @PostMapping
    public ResponseEntity<Treino> save(@RequestBody @Valid TreinoPostRequestBody treinoPostRequestBody){
        return new ResponseEntity<>(treinoService.save(treinoPostRequestBody), HttpStatus.CREATED);
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
    	treinoService.delete(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody TreinoPutRequestBody treinoPutRequestBody){
    	treinoService.replace(treinoPutRequestBody);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
