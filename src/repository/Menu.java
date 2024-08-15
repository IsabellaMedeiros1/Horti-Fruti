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
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public Produto nomeConsulta(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
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