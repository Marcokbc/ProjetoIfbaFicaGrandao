package ifba.dev.projetoFicaGrandao.controller;

import ifba.dev.projetoFicaGrandao.domain.Avaliacao;
import ifba.dev.projetoFicaGrandao.service.AvaliacaoService;
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
@RequestMapping("avaliacao")
@Log4j2
@RequiredArgsConstructor
public class AvaliacaoController {
    private final AvaliacaoService avaliacaoService;

    @GetMapping
    public ResponseEntity<List<Avaliacao>> list(){
        return ResponseEntity.ok(avaliacaoService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Avaliacao> findById(@PathVariable long id){
        return ResponseEntity.ok(avaliacaoService.findById(id));
    }
    
    @PostMapping
    public ResponseEntity<Avaliacao> save(@RequestBody Avaliacao avaliacao){
        return new ResponseEntity<>(avaliacaoService.save(avaliacao), HttpStatus.CREATED);
    }
}
