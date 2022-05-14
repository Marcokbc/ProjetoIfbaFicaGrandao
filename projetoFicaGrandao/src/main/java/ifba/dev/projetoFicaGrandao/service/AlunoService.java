package ifba.dev.projetoFicaGrandao.service;

import ifba.dev.projetoFicaGrandao.domain.Aluno;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AlunoService {
    private static List<Aluno> alunos;

    static {
    	alunos = new ArrayList<>(List.of(new Aluno(1L, "2309470234","9340593405","Marco","marco@gmail.com","academia","07/02/2004","46100000","santa teresa","brumado","bahia")));
    }

    // private final AnimeRepository animeRepository;
    public List<Aluno> listAll() {
        return alunos;
    }

    public Aluno findById(long id) {
        return alunos.stream()
                .filter(aluno -> aluno.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aluno not Found"));
    }

    public Aluno save(Aluno aluno) {
        aluno.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        alunos.add(aluno);
        return aluno;
    }
}