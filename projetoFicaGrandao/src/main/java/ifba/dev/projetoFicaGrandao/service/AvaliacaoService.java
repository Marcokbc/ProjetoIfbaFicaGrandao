package ifba.dev.projetoFicaGrandao.service;

import ifba.dev.projetoFicaGrandao.domain.Aluno;
import ifba.dev.projetoFicaGrandao.domain.Avaliacao;
import ifba.dev.projetoFicaGrandao.exception.BadRequestException;
import ifba.dev.projetoFicaGrandao.mapper.AlunoMapper;
import ifba.dev.projetoFicaGrandao.mapper.AvaliacaoMapper;
import ifba.dev.projetoFicaGrandao.repository.AlunoRepository;
import ifba.dev.projetoFicaGrandao.repository.AvaliacaoRepository;
import ifba.dev.projetoFicaGrandao.requests.AlunoPostRequestBody;
import ifba.dev.projetoFicaGrandao.requests.AlunoPutRequestBody;
import ifba.dev.projetoFicaGrandao.requests.AvaliacaoPostRequestBody;
import ifba.dev.projetoFicaGrandao.requests.AvaliacaoPutRequestBody;
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
public class AvaliacaoService {
	private final AvaliacaoRepository avaliacaoRepository;
    public List<Avaliacao> listAll() {
        return avaliacaoRepository.findAll();
    }
    
    public List<Avaliacao> findByNome(String nome){
    	return avaliacaoRepository.findByNome(nome);
    }

    public Avaliacao findByIdOrThrowBadRequestException(long id) {
        return avaliacaoRepository.findById(id)
        		.orElseThrow(() -> new BadRequestException("Avalicao not Found"));
    }

    @Transactional
    public Avaliacao save(AvaliacaoPostRequestBody avaliacaoPostRequestBody) {
        return avaliacaoRepository.save(AvaliacaoMapper.INSTANCE.toAvaliacao(avaliacaoPostRequestBody));
    }

	public void delete(long id) {
		avaliacaoRepository.delete(findByIdOrThrowBadRequestException(id));
	}

	public void replace(AvaliacaoPutRequestBody avaliacaoPutRequestBody) {
		Avaliacao savedAvaliacao = findByIdOrThrowBadRequestException(avaliacaoPutRequestBody.getId());
		Avaliacao avaliacao = AvaliacaoMapper.INSTANCE.toAvaliacao(avaliacaoPutRequestBody);
        avaliacao.setId(savedAvaliacao.getId());

        avaliacaoRepository.save(avaliacao);
		
	}
}