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
public class Instrutor{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		private String endereco;
		private String nome;
		private String email;
		private String senha;
		private String datanasc;
		private String cep;
		private String bairro;
		private String cidade;
		private String estado;
}

