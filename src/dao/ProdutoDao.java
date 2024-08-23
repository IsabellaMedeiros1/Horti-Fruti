package dao;

import models.Produto;
import enums.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {
    private Connection conexao;

    public void cadastrarProduto(Produto produto) {
        conexao = ConnectionFactory.obterConexao();
        String sql = "INSERT INTO tbl_produto (codigo, nome, preco, categoria) VALUES (?, ?, ?, ?)";
        try (PreparedStatement comandoSQL = conexao.prepareStatement(sql)) {
            comandoSQL.setInt(1, produto.getCodigo());
            comandoSQL.setString(2, produto.getNome());
            comandoSQL.setDouble(3, produto.getPreco());
            comandoSQL.setString(4, produto.getCategoria().toString());
            comandoSQL.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Produto> listarProdutos() {
        conexao = ConnectionFactory.obterConexao();
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM tbl_produto";
        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produto produto = new Produto(rs.getInt("codigo"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        Categoria.valueOf(rs.getString("categoria")));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return produtos;
    }

    public Produto buscarPorCodigo(int codigo) {
        conexao = ConnectionFactory.obterConexao();
        Produto produto = null;
        String sql = "SELECT * FROM tbl_produto WHERE codigo = ?";
        try (PreparedStatement comandoSQL = conexao.prepareStatement(sql)) {
            comandoSQL.setInt(1, codigo);
            try (ResultSet rs = comandoSQL.executeQuery()) {
                if (rs.next()) {
                    produto = new Produto(rs.getInt("codigo"),
                            rs.getString("nome"),
                            rs.getDouble("preco"),
                            Categoria.valueOf(rs.getString("categoria")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return produto;
    }

    public Produto buscarPorNome(String nome) {
        conexao = ConnectionFactory.obterConexao();
        Produto produto = null;
        String sql = "SELECT * FROM tbl_produto WHERE nome = ?";
        try (PreparedStatement comandoSQL = conexao.prepareStatement(sql)) {
            comandoSQL.setString(1, nome);
            try (ResultSet rs = comandoSQL.executeQuery()) {
                if (rs.next()) {
                    produto = new Produto(rs.getInt("codigo"),
                            rs.getString("nome"),
                            rs.getDouble("preco"),
                            Categoria.valueOf(rs.getString("categoria")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return produto;
    }

    public void alterarProduto(Produto produto) {
        conexao = ConnectionFactory.obterConexao();
        String sql = "UPDATE tbl_produto SET nome = ?, preco = ?, categoria = ? WHERE codigo = ?";
        try (PreparedStatement comandoSQL = conexao.prepareStatement(sql)) {
            comandoSQL.setString(1, produto.getNome());
            comandoSQL.setDouble(2, produto.getPreco());
            comandoSQL.setString(3, produto.getCategoria().toString());
            comandoSQL.setInt(4, produto.getCodigo());
            comandoSQL.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void excluirProduto(int codigo) {
        conexao = ConnectionFactory.obterConexao();
        String sql = "DELETE FROM tbl_produto WHERE codigo = ?";
        try (PreparedStatement comandoSQL = conexao.prepareStatement(sql)) {
            comandoSQL.setInt(1, codigo);
            comandoSQL.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
