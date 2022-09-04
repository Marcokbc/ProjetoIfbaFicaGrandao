package ifba.dev.projetoFicaGrandao.service;

import ifba.dev.projetoFicaGrandao.domain.Avaliacao;
import ifba.dev.projetoFicaGrandao.exception.BadRequestException;
import ifba.dev.projetoFicaGrandao.repository.AvaliacaoRepository;
import ifba.dev.projetoFicaGrandao.requests.AvaliacaoPostRequestBody;
import ifba.dev.projetoFicaGrandao.requests.AvaliacaoPutRequestBody;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AvaliacaoService {
	private final AvaliacaoRepository avaliacaoRepository;
    public List<Avaliacao> listAll() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao findByIdOrThrowBadRequestException(long id) {
        return avaliacaoRepository.findById(id)
        		.orElseThrow(() -> new BadRequestException("Avalicao not Found"));
    }

    @Transactional
    public Avaliacao save(AvaliacaoPostRequestBody avaliacaoPostRequestBody) {
    	return avaliacaoRepository.save(Avaliacao.builder()
    			.peso(avaliacaoPostRequestBody.getPeso())
    			.altura(avaliacaoPostRequestBody.getAltura())
    			.bodyfat(avaliacaoPostRequestBody.getBodyfat())
    			.idade(avaliacaoPostRequestBody.getIdade())
    			.nivelatv(avaliacaoPostRequestBody.getNivelatv())
    			.problemas(avaliacaoPostRequestBody.getProblemas())
    			.observacao(avaliacaoPostRequestBody.getObservacao())
    			.build());
    }

	public void delete(long id) {
		avaliacaoRepository.delete(findByIdOrThrowBadRequestException(id));
	}

	public void replace(AvaliacaoPutRequestBody avaliacaoPutRequestBody) {
		Avaliacao savedAvaliacao = findByIdOrThrowBadRequestException(avaliacaoPutRequestBody.getId());
		Avaliacao avaliacao = Avaliacao.builder()
                .id(savedAvaliacao.getId())
                .peso(avaliacaoPutRequestBody.getPeso())
                .altura(avaliacaoPutRequestBody.getAltura())
    			.bodyfat(avaliacaoPutRequestBody.getBodyfat())
    			.idade(avaliacaoPutRequestBody.getIdade())
    			.nivelatv(avaliacaoPutRequestBody.getNivelatv())
    			.problemas(avaliacaoPutRequestBody.getProblemas())
    			.observacao(avaliacaoPutRequestBody.getObservacao())
                .build();

        avaliacaoRepository.save(avaliacao);
		
	}
}