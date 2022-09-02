package ifba.dev.projetoFicaGrandao.service;

import ifba.dev.projetoFicaGrandao.domain.Instrutor;
import ifba.dev.projetoFicaGrandao.exception.BadRequestException;
import ifba.dev.projetoFicaGrandao.mapper.InstrutorMapper;
import ifba.dev.projetoFicaGrandao.repository.AlunoRepository;
import ifba.dev.projetoFicaGrandao.repository.InstrutorRepository;
import ifba.dev.projetoFicaGrandao.requests.InstrutorPostRequestBody;
import ifba.dev.projetoFicaGrandao.requests.InstrutorPutRequestBody;
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
public class InstrutorService {
	private final InstrutorRepository instrutorRepository;
    public List<Instrutor> listAll() {
        return instrutorRepository.findAll();
    }
    
    public List<Instrutor> findByNome(String nome){
    	return instrutorRepository.findByNome(nome);
    }

    public Instrutor findByIdOrThrowBadRequestException(long id) {
        return instrutorRepository.findById(id)
        		.orElseThrow(() -> new BadRequestException("Instrutor not Found"));
    }

    @Transactional
    public Instrutor save(InstrutorPostRequestBody instrutorPostRequestBody) {
        return instrutorRepository.save(InstrutorMapper.INSTANCE.toInstrutor(instrutorPostRequestBody));
    }

	public void delete(long id) {
		instrutorRepository.delete(findByIdOrThrowBadRequestException(id));
	}

	public void replace(InstrutorPutRequestBody instrutorPutRequestBody) {
		Instrutor savedInstrutor = findByIdOrThrowBadRequestException(instrutorPutRequestBody.getId());
		Instrutor instrutor = InstrutorMapper.INSTANCE.toInstrutor(instrutorPutRequestBody);
        instrutor.setId(savedInstrutor.getId());

        instrutorRepository.save(instrutor);
		
	}
}