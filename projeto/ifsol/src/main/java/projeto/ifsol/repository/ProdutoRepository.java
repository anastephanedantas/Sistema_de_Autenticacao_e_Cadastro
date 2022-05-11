package projeto.ifsol.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projeto.ifsol.model.Produtos;
@Repository
public interface ProdutoRepository extends CrudRepository<Produtos, String > {
	Produtos findById(long id);
}
