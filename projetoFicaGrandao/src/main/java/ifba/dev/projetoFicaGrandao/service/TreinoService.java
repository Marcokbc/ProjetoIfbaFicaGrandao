package ifba.dev.projetoFicaGrandao.service;

import ifba.dev.projetoFicaGrandao.domain.Treino;
import ifba.dev.projetoFicaGrandao.exception.BadRequestException;
import ifba.dev.projetoFicaGrandao.repository.TreinoRepository;
import ifba.dev.projetoFicaGrandao.requests.TreinoPostRequestBody;
import ifba.dev.projetoFicaGrandao.requests.TreinoPutRequestBody;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class TreinoService {
	private final TreinoRepository treinoRepository;
    public List<Treino> listAll() {
        return treinoRepository.findAll();
    }

    public Treino findByIdOrThrowBadRequestException(long id) {
        return treinoRepository.findById(id)
        		.orElseThrow(() -> new BadRequestException("Treino not Found"));
    }

    @Transactional
    public Treino save(TreinoPostRequestBody treinoPostRequestBody) {
        return treinoRepository.save(Treino.builder()
        		.divisao(treinoPostRequestBody.getDivisao())
        		.exercicio(treinoPostRequestBody.getExercicio())
        		.build());
    }

	public void delete(long id) {
		treinoRepository.delete(findByIdOrThrowBadRequestException(id));
	}

	public void replace(TreinoPutRequestBody treinoPutRequestBody) {
		Treino savedTreino = findByIdOrThrowBadRequestException(treinoPutRequestBody.getId());
		Treino treino = Treino.builder()
                .id(savedTreino.getId())
                .divisao(treinoPutRequestBody.getDivisao())
                .exercicio(treinoPutRequestBody.getExercicio())
                .build();

        treinoRepository.save(treino);
		
	}
}