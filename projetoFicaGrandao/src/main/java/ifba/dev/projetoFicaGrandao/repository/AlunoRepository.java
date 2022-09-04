package ifba.dev.projetoFicaGrandao.repository;

import ifba.dev.projetoFicaGrandao.domain.Aluno;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	List<Aluno> findByNome(String nome);
}

