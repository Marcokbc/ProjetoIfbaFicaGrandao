package ifba.dev.projetoFicaGrandao.requests;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class InstrutorPostRequestBody {
	private String endereco;
	@NotEmpty(message = "The avalicao name cannot be empty")
	private String nome;
	private String email;
	private String senha;
	private String datanasc;
	private String cep;
	private String bairro;
	private String cidade;
	private String estado;
}
