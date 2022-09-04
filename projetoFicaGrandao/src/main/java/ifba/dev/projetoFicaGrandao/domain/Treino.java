package ifba.dev.projetoFicaGrandao.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		private String divisao;
		private String exercicio; 
}

