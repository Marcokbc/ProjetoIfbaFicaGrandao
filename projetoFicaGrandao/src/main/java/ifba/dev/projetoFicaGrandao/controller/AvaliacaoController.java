package ifba.dev.projetoFicaGrandao.controller;

import ifba.dev.projetoFicaGrandao.domain.Avaliacao;
import ifba.dev.projetoFicaGrandao.requests.AvaliacaoPostRequestBody;
import ifba.dev.projetoFicaGrandao.requests.AvaliacaoPutRequestBody;
import ifba.dev.projetoFicaGrandao.service.AvaliacaoService;
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
@RequestMapping("avaliacao")
@RequiredArgsConstructor
public class AvaliacaoController {
	private final AvaliacaoService avaliacaoService;

    @GetMapping
    public ResponseEntity<List<Avaliacao>> list(){
        return ResponseEntity.ok(avaliacaoService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Avaliacao> findById(@PathVariable long id){
        return ResponseEntity.ok(avaliacaoService.findByIdOrThrowBadRequestException(id));
    }
    
    @GetMapping(path = "/find")
    public ResponseEntity<List<Avaliacao>> findByNome(@RequestParam String nome){
        return ResponseEntity.ok(avaliacaoService.findByNome(nome));
    }
    
    @PostMapping
    public ResponseEntity<Avaliacao> save(@RequestBody @Valid AvaliacaoPostRequestBody avaliacaoPostRequestBody){
        return new ResponseEntity<>(avaliacaoService.save(avaliacaoPostRequestBody), HttpStatus.CREATED);
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
    	avaliacaoService.delete(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody AvaliacaoPutRequestBody avaliacaoPutRequestBody){
    	avaliacaoService.replace(avaliacaoPutRequestBody);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
