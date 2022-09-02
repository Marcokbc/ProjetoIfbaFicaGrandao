package ifba.dev.projetoFicaGrandao.requests;

import lombok.Data;

@Data
public class TreinoPutRequestBody {
	private long id;
	private String divisao;
	private String Exercicio;
}
