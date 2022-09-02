package ifba.dev.projetoFicaGrandao.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ifba.dev.projetoFicaGrandao.domain.Aluno;
import ifba.dev.projetoFicaGrandao.requests.AlunoPostRequestBody;
import ifba.dev.projetoFicaGrandao.requests.AlunoPutRequestBody;

@Mapper(componentModel = "spring")
public abstract class AlunoMapper {
	public static final AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);

    public abstract Aluno toAluno(AlunoPostRequestBody alunoPostRequestBody);

    public abstract Aluno toAluno(AlunoPutRequestBody alunoPutRequestBody);
}
