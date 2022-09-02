package ifba.dev.projetoFicaGrandao.domain;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
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

