package br.com.enfermagem.repository;

import br.com.enfermagem.model.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LoginRepository extends PagingAndSortingRepository<Usuario, Long> {

    Usuario findByEmailAndSenha(String email, String senha);

    Usuario findByEmail(String email);
}
