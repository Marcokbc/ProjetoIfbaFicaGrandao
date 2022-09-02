package ifba.dev.projetoFicaGrandao.requests;

import lombok.Data;

@Data
public class AvaliacaoPutRequestBody {
	private long id;
	private double peso;
	private double altura;
	private double bodyfat;
	private int idade;
	private String nivelatv;
	private String problemas;
	private String observacao;
}
