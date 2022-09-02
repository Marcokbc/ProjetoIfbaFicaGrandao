package ifba.dev.projetoFicaGrandao.requests;

import lombok.Data;

@Data
public class AlunoPutRequestBody {
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
