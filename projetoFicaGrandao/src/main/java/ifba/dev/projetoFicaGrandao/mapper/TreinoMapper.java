package ifba.dev.projetoFicaGrandao.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ifba.dev.projetoFicaGrandao.domain.Treino;
import ifba.dev.projetoFicaGrandao.requests.TreinoPostRequestBody;
import ifba.dev.projetoFicaGrandao.requests.TreinoPutRequestBody;

@Mapper(componentModel = "spring")
public abstract class TreinoMapper {
	public static final TreinoMapper INSTANCE = Mappers.getMapper(TreinoMapper.class);

    public abstract Treino toTreino(TreinoPostRequestBody treinoPostRequestBody);

    public abstract Treino toTreino(TreinoPutRequestBody treinoPutRequestBody);
}
