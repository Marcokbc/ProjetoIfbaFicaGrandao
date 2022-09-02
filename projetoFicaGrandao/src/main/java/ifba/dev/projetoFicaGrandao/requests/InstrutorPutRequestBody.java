package ifba.dev.projetoFicaGrandao.requests;

import lombok.Data;

@Data
public class InstrutorPutRequestBody {
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
