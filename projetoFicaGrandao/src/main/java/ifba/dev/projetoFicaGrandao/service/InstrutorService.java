package ifba.dev.projetoFicaGrandao.service;

import ifba.dev.projetoFicaGrandao.domain.Instrutor;
import ifba.dev.projetoFicaGrandao.exception.BadRequestException;
import ifba.dev.projetoFicaGrandao.repository.InstrutorRepository;
import ifba.dev.projetoFicaGrandao.requests.InstrutorPostRequestBody;
import ifba.dev.projetoFicaGrandao.requests.InstrutorPutRequestBody;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

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
        return instrutorRepository.save(Instrutor.builder()
        		.nome(instrutorPostRequestBody.getNome())
        		.bairro(instrutorPostRequestBody.getBairro())
        		.cidade(instrutorPostRequestBody.getCidade())
        		.cep(instrutorPostRequestBody.getCep())
        		.datanasc(instrutorPostRequestBody.getDatanasc())
        		.email(instrutorPostRequestBody.getEmail())
        		.endereco(instrutorPostRequestBody.getEndereco())
        		.estado(instrutorPostRequestBody.getEstado())
        		.senha(instrutorPostRequestBody.getSenha())
        		.build());
        
    }

	public void delete(long id) {
		instrutorRepository.delete(findByIdOrThrowBadRequestException(id));
	}

	public void replace(InstrutorPutRequestBody instrutorPutRequestBody) {
		Instrutor savedInstrutor = findByIdOrThrowBadRequestException(instrutorPutRequestBody.getId());
		Instrutor instrutor  = Instrutor.builder()
                .id(savedInstrutor.getId())
                .nome(instrutorPutRequestBody.getNome())
                .bairro(instrutorPutRequestBody.getBairro())
        		.cidade(instrutorPutRequestBody.getCidade())
        		.cep(instrutorPutRequestBody.getCep())
        		.datanasc(instrutorPutRequestBody.getDatanasc())
        		.email(instrutorPutRequestBody.getEmail())
        		.endereco(instrutorPutRequestBody.getEndereco())
        		.estado(instrutorPutRequestBody.getEstado())
        		.senha(instrutorPutRequestBody.getSenha())
                .build();

        instrutorRepository.save(instrutor);
		
	}
}