package ifba.dev.projetoFicaGrandao.service;

import ifba.dev.projetoFicaGrandao.domain.Aluno;
import ifba.dev.projetoFicaGrandao.repository.AlunoRepository;
import ifba.dev.projetoFicaGrandao.requests.AlunoPostRequestBody;
import ifba.dev.projetoFicaGrandao.mapper.AlunoMapper;
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
        return alunoRepository.save(AlunoMapper.INSTANCE.toAluno(alunoPostRequestBody));
    }

	public void delete(long id) {
		alunoRepository.delete(findByIdOrThrowBadRequestException(id));
	}

	public void replace(AlunoPutRequestBody alunoPutRequestBody) {
		Aluno savedAluno = findByIdOrThrowBadRequestException(alunoPutRequestBody.getId());
		Aluno aluno = AlunoMapper.INSTANCE.toAluno(alunoPutRequestBody);
        aluno.setId(savedAluno.getId());

        alunoRepository.save(aluno);
		
	}
}