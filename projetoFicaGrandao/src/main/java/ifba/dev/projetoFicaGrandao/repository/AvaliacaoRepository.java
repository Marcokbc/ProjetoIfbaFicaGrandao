package ifba.dev.projetoFicaGrandao.repository;

import ifba.dev.projetoFicaGrandao.domain.Avaliacao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{
	
}

