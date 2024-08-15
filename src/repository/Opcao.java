package repository;

import models.Produto;
import java.util.List;

public interface Opcao {
    void cadastrar(Produto produto);
    List<Produto> listar();
    Produto consultarPorCodigo(int codigo);
    Produto consultarPorNome(String nome);
    void alterar(Produto produto);
    void excluir(int codigo);
}

