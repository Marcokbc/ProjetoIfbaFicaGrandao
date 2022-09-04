package ifba.dev.projetoFicaGrandao.service;

import ifba.dev.projetoFicaGrandao.domain.Aluno;
import ifba.dev.projetoFicaGrandao.repository.AlunoRepository;
import ifba.dev.projetoFicaGrandao.requests.AlunoPostRequestBody;
import ifba.dev.projetoFicaGrandao.requests.AlunoPutRequestBody;
import ifba.dev.projetoFicaGrandao.exception.BadRequestException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AlunoService {
    
    private final AlunoRepository alunoRepository;
    public List<Aluno> listAll() {
        return alunoRepository.findAll();
    }
    
    public List<Aluno> findByNome(String nome){
    	return alunoRepository.findByNome(nome);
    }

    public Aluno findByIdOrThrowBadRequestException(long id) {
        return alunoRepository.findById(id)
        		.orElseThrow(() -> new BadRequestException("Aluno not Found"));
    }

    @Transactional
    public Aluno save(AlunoPostRequestBody alunoPostRequestBody) {
        return alunoRepository.save(Aluno.builder()
        		.nome(alunoPostRequestBody.getNome())
        		.bairro(alunoPostRequestBody.getBairro())
        		.cep(alunoPostRequestBody.getCep())
        		.cidade(alunoPostRequestBody.getCidade())
        		.cpf(alunoPostRequestBody.getCpf())
        		.datanasc(alunoPostRequestBody.getDatanasc())
        		.email(alunoPostRequestBody.getEmail())
        		.estado(alunoPostRequestBody.getEstado())
        		.senha(alunoPostRequestBody.getSenha())
        		.telefone(alunoPostRequestBody.getTelefone())
        		.build());
    }

	public void delete(long id) {
		alunoRepository.delete(findByIdOrThrowBadRequestException(id));
	}

	public void replace(AlunoPutRequestBody alunoPutRequestBody) {
		Aluno savedAluno = findByIdOrThrowBadRequestException(alunoPutRequestBody.getId());
		Aluno aluno = Aluno.builder()
                .id(savedAluno.getId())
                .nome(alunoPutRequestBody.getNome())
                .bairro(alunoPutRequestBody.getBairro())
        		.cep(alunoPutRequestBody.getCep())
        		.cidade(alunoPutRequestBody.getCidade())
        		.cpf(alunoPutRequestBody.getCpf())
        		.datanasc(alunoPutRequestBody.getDatanasc())
        		.email(alunoPutRequestBody.getEmail())
        		.estado(alunoPutRequestBody.getEstado())
        		.senha(alunoPutRequestBody.getSenha())
                .build();

        alunoRepository.save(aluno);
		
	}
}