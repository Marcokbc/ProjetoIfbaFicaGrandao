package ifba.dev.projetoFicaGrandao.controller;

import ifba.dev.projetoFicaGrandao.domain.Aluno;
import ifba.dev.projetoFicaGrandao.requests.AlunoPostRequestBody;
import ifba.dev.projetoFicaGrandao.requests.AlunoPutRequestBody;
import ifba.dev.projetoFicaGrandao.service.AlunoService;
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
@RequestMapping("alunos")
@RequiredArgsConstructor
public class AlunoController {
    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> list(){
        return ResponseEntity.ok(alunoService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable long id){
        return ResponseEntity.ok(alunoService.findByIdOrThrowBadRequestException(id));
    }
    
    @GetMapping(path = "/find")
    public ResponseEntity<List<Aluno>> findByNome(@RequestParam String nome){
        return ResponseEntity.ok(alunoService.findByNome(nome));
    }
    
    @PostMapping
    public ResponseEntity<Aluno> save(@RequestBody @Valid AlunoPostRequestBody alunoPostRequestBody){
        return new ResponseEntity<>(alunoService.save(alunoPostRequestBody), HttpStatus.CREATED);
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
    	alunoService.delete(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody AlunoPutRequestBody alunoPutRequestBody){
    	alunoService.replace(alunoPutRequestBody);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
