package ifba.dev.projetoFicaGrandao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Aluno{
		private long id;
		private String telefone;
		private String cpf;
		private String nome;
		private String email;
		private String senha;
		private String datanasc;
		private String cep;
		private String bairro;
		private String cidade;
		private String estado;
}

