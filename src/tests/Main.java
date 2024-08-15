package tests;

import repository.Opcao;
import repository.Menu;
import models.Produto;
import enums.Categoria;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Opcao opcao = new Menu();
        Scanner leitor = new Scanner(System.in);
        Random random = new Random();

        int op;
        do{
            System.out.println("H O R T I - F R U T I"+
                    "\n(0) Cadastrar Produto" +
                    "\n(1) Listar Produtos" +
                    "\n(2) Consultar Produto pelo Código" +
                    "\n(3) Consultar Produto pelo Nome" +
                    "\n(4) Alterar" +
                    "\n(5) Excluir" +
                    "\n(6) Sair" +
                    "\nDigite a opção que deseja: ");
            op = leitor.nextInt();
            leitor.nextLine();

            switch (op){
                case 0:
                    int codigo = random.nextInt(10000);

                    System.out.println("Digite o nome do Produto: ");
                    String nome = leitor.nextLine();
                    System.out.println("Digite o preço por Kg do produto: ");
                    double preco = leitor.nextDouble();
                    leitor.nextLine();
                    System.out.println("Escolha a categoria que deseja registrar o produto: "+
                            "\n(F) Fruta"+
                            "\n(L) Legumes"+
                            "\n(V) Verdura"+
                            "\n(O) Ovo"+
                            "\n(T) Tempero");
                    String categoriaEscolhida = leitor.nextLine().toUpperCase();
                    Categoria categoria = null;
                    switch (categoriaEscolhida) {
                        case "F":
                            categoria = Categoria.FRUTA;
                            break;
                        case "L":
                            categoria = Categoria.LEGUMES;
                            break;
                        case "V":
                            categoria = Categoria.VERDURA;
                            break;
                        case "O":
                            categoria = Categoria.OVO;
                            break;
                        case "T":
                            categoria = Categoria.TEMPERO;
                            break;
                        default:
                            System.out.println("Categoria inválida! Tente novamente.");
                            continue;
                    }

                    Produto produto = new Produto(codigo, nome, preco, categoria);
                    opcao.cadastrar(produto);
                    System.out.println("Produto foi cadastrado com sucesso! Seu código será: " + codigo);
                    break;

                case 1:
                    System.out.println("Lista dos Produtos: ");
                    List<Produto> produtos = opcao.listar();
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        for(Produto p : produtos){
                            System.out.println(p);
                        }
                    }
                    break;
            }
        } while (op != 6);
        System.out.println("Programa encerrado");
    }
}
