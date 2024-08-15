package repository;

import models.Produto;
import java.util.ArrayList;
import java.util.List;


public class Menu implements Opcao {
    private List<Produto> produtos = new ArrayList<>();

    @Override
    public void cadastrar(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public List<Produto> listar() {
        return produtos;
    }

    @Override
    public Produto codigoConsulta(int codigo) {
        return produtos.stream()
                .filter(produto -> produto.getCodigo() == codigo)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Produto nomeConsulta(String nome) {
        return produtos.stream()
                .filter(produto -> produto.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void alterar(Produto produto) {
        Produto existente = codigoConsulta(produto.getCodigo());
        if (existente != null) {
            existente.setNome(produto.getNome());
            existente.setPreco(produto.getPreco());
            existente.setCategoria(produto.getCategoria());
        }
    }

    @Override
    public void excluir(int codigo) {
        produtos.removeIf(produto -> produto.getCodigo() == codigo);
    }
}