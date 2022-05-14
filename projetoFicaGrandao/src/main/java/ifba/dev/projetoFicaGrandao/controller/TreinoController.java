package ifba.dev.projetoFicaGrandao.controller;

import ifba.dev.projetoFicaGrandao.domain.Treino;
import ifba.dev.projetoFicaGrandao.service.TreinoService;
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
@RequestMapping("treinos")
@Log4j2
@RequiredArgsConstructor
public class TreinoController {
    private final TreinoService treinoService;

    @GetMapping
    public ResponseEntity<List<Treino>> list(){
        return ResponseEntity.ok(treinoService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Treino> findById(@PathVariable long id){
        return ResponseEntity.ok(treinoService.findById(id));
    }
    
    @PostMapping
    public ResponseEntity<Treino> save(@RequestBody Treino treino){
        return new ResponseEntity<>(treinoService.save(treino), HttpStatus.CREATED);
    }
}
