package ifba.dev.projetoFicaGrandao.service;

import ifba.dev.projetoFicaGrandao.domain.Avaliacao;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AvaliacaoService {
    private static List<Avaliacao> avaliacoes;

    static {
    	avaliacoes = new ArrayList<>(List.of(new Avaliacao(1L, 70.1,1.75,14.0,19,"moderado","nenhum","nenhuma")));
    }

    // private final AnimeRepository animeRepository;
    public List<Avaliacao> listAll() {
        return avaliacoes;
    }

    public Avaliacao findById(long id) {
        return avaliacoes.stream()
                .filter(avaliacao -> avaliacao.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Avaliacao not Found"));
    }

    public Avaliacao save(Avaliacao avaliacao) {
        avaliacao.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        avaliacoes.add(avaliacao);
        return avaliacao;
    }
}