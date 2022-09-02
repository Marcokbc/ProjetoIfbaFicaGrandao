package ifba.dev.projetoFicaGrandao.service;

import ifba.dev.projetoFicaGrandao.domain.Treino;
import ifba.dev.projetoFicaGrandao.exception.BadRequestException;
import ifba.dev.projetoFicaGrandao.mapper.TreinoMapper;
import ifba.dev.projetoFicaGrandao.repository.AlunoRepository;
import ifba.dev.projetoFicaGrandao.repository.TreinoRepository;
import ifba.dev.projetoFicaGrandao.requests.TreinoPostRequestBody;
import ifba.dev.projetoFicaGrandao.requests.TreinoPutRequestBody;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class TreinoService {
	private final TreinoRepository treinoRepository;
    public List<Treino> listAll() {
        return treinoRepository.findAll();
    }
    
    public List<Treino> findByNome(String nome){
    	return treinoRepository.findByNome(nome);
    }

    public Treino findByIdOrThrowBadRequestException(long id) {
        return treinoRepository.findById(id)
        		.orElseThrow(() -> new BadRequestException("Treino not Found"));
    }

    @Transactional
    public Treino save(TreinoPostRequestBody treinoPostRequestBody) {
        return treinoRepository.save(TreinoMapper.INSTANCE.toTreino(treinoPostRequestBody));
    }

	public void delete(long id) {
		treinoRepository.delete(findByIdOrThrowBadRequestException(id));
	}

	public void replace(TreinoPutRequestBody treinoPutRequestBody) {
		Treino savedTreino = findByIdOrThrowBadRequestException(treinoPutRequestBody.getId());
		Treino treino = TreinoMapper.INSTANCE.toTreino(treinoPutRequestBody);
        treino.setId(savedTreino.getId());

        treinoRepository.save(treino);
		
	}
}