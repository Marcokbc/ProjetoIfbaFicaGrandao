package ifba.dev.projetoFicaGrandao.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ifba.dev.projetoFicaGrandao.domain.Avaliacao;
import ifba.dev.projetoFicaGrandao.requests.AvaliacaoPostRequestBody;
import ifba.dev.projetoFicaGrandao.requests.AvaliacaoPutRequestBody;

@Mapper(componentModel = "spring")
public abstract class AvaliacaoMapper {
	public static final AvaliacaoMapper INSTANCE = Mappers.getMapper(AvaliacaoMapper.class);

    public abstract Avaliacao toAvaliacao(AvaliacaoPostRequestBody avaliacaoPostRequestBody);

    public abstract Avaliacao toAvaliacao(AvaliacaoPutRequestBody avaliacaoPutRequestBody);
}
