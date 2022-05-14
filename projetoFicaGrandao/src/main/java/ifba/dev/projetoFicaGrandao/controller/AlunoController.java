package ifba.dev.projetoFicaGrandao.controller;

import ifba.dev.projetoFicaGrandao.domain.Aluno;
import ifba.dev.projetoFicaGrandao.service.AlunoService;
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
@RequestMapping("alunos")
@Log4j2
@RequiredArgsConstructor
public class AlunoController {
    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> list(){
        return ResponseEntity.ok(alunoService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable long id){
        return ResponseEntity.ok(alunoService.findById(id));
    }
    
    @PostMapping
    public ResponseEntity<Aluno> save(@RequestBody Aluno aluno){
        return new ResponseEntity<>(alunoService.save(aluno), HttpStatus.CREATED);
    }
}
