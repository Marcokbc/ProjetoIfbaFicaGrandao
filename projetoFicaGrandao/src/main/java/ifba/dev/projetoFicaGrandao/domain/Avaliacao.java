package ifba.dev.projetoFicaGrandao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Avaliacao{
		private long id;
		private double peso;
		private double altura;
		private double bodyfat;
		private int idade;
		private String nivelatv;
		private String problemas;
		private String observacao;
}

