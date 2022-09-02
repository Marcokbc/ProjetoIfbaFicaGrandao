package ifba.dev.projetoFicaGrandao.repository;

import ifba.dev.projetoFicaGrandao.domain.Instrutor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrutorRepository extends JpaRepository<Instrutor, Long>{
	List<Instrutor> findByNome(String nome);
}

