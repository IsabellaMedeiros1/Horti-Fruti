package models;

import enums.Categoria;

public class Produto {
    private int codigo;
    private String nome;
    private double precoPorKg;
    private Categoria categoria;

    public Produto(int codigo, String nome, double precoPorKg, Categoria categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoPorKg = precoPorKg;
        this.categoria = categoria;
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoPorKg() {
        return precoPorKg;
    }

    public void setPrecoPorKg(double precoPorKg) {
        this.precoPorKg = precoPorKg;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ItemHortiFruti{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", precoPorKg=" + precoPorKg +
                ", categoria=" + categoria +
                '}';
    }
}
