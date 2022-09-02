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
public class Treino{
		private long id;
		private String divisao;
		private String Exercicio; 
}

