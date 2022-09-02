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
public class Instrutor{
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

