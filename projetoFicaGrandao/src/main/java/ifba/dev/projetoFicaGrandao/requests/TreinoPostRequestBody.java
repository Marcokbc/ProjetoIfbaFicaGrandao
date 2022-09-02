package ifba.dev.projetoFicaGrandao.requests;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class TreinoPostRequestBody {
	private String divisao;
	private String Exercicio;
}
