package repository;

import models.Produto;
import java.util.List;

public interface Opcao {
    void cadastrar(Produto produto);
    List<Produto> listar();
    Produto codigoConsulta(int codigo);
    Produto nomeConsulta(String nome);
    void alterar(Produto produto);
    void excluir(int codigo);
}

