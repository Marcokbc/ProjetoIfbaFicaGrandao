package ifba.dev.projetoFicaGrandao.service;

import ifba.dev.projetoFicaGrandao.domain.Instrutor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class InstrutorService {
    private static List<Instrutor> instrutores;

    static {
    	instrutores = new ArrayList<>(List.of(new Instrutor(1L, "Rua jonas","Rennan","reymarcos@gmail.com","boco","12739","4610000","santa tereza","brumado","bahia")));
    }

    // private final AnimeRepository animeRepository;
    public List<Instrutor> listAll() {
        return instrutores;
    }

    public Instrutor findById(long id) {
        return instrutores.stream()
                .filter(instrutor -> instrutor.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Instrutor not Found"));
    }

    public Instrutor save(Instrutor instrutor) {
        instrutor.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        instrutores.add(instrutor);
        return instrutor;
    }
}