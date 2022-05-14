package ifba.dev.projetoFicaGrandao.service;

import ifba.dev.projetoFicaGrandao.domain.Treino;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class TreinoService {
    private static List<Treino> treinos;

    static {
    	treinos = new ArrayList<>(List.of(new Treino(1L,"A","Supino")));
    }

    // private final AnimeRepository animeRepository;
    public List<Treino> listAll() {
        return treinos;
    }

    public Treino findById(long id) {
        return treinos.stream()
                .filter(treino -> treino.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Treino not Found"));
    }

    public Treino save(Treino treino) {
        treino.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        treinos.add(treino);
        return treino;
    }
}