package ifba.dev.projetoFicaGrandao.requests;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class AvaliacaoPostRequestBody {
	private double peso;
	private double altura;
	private double bodyfat;
	private int idade;
	private String nivelatv;
	private String problemas;
	private String observacao;
}
