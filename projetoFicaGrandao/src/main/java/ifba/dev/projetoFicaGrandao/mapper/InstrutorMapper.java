package ifba.dev.projetoFicaGrandao.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ifba.dev.projetoFicaGrandao.domain.Instrutor;
import ifba.dev.projetoFicaGrandao.requests.InstrutorPostRequestBody;
import ifba.dev.projetoFicaGrandao.requests.InstrutorPutRequestBody;

@Mapper(componentModel = "spring")
public abstract class InstrutorMapper {
	public static final InstrutorMapper INSTANCE = Mappers.getMapper(InstrutorMapper.class);

    public abstract Instrutor toInstrutor(InstrutorPostRequestBody instrutorPostRequestBody);

    public abstract Instrutor toInstrutor(InstrutorPutRequestBody instrutorPutRequestBody);
}
