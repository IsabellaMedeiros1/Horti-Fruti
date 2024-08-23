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

        String titulo = "                                           ,,                                                          ,,  \n" +
                "`7MMF'  `7MMF'                     mm      db                `7MM\"\"\"YMM                        mm      db  \n" +
                "  MM      MM                       MM                          MM    `7                        MM          \n" +
                "  MM      MM   ,pW\"Wq.  `7Mb,od8 mmMMmm  `7MM                  MM   d   `7Mb,od8 `7MM  `7MM  mmMMmm  `7MM  \n" +
                "  MMmmmmmmMM  6W'   `Wb   MM' \"'   MM      MM                  MM\"\"MM     MM' \"'   MM    MM    MM      MM  \n" +
                "  MM      MM  8M     M8   MM       MM      MM      mmmmm       MM   Y     MM       MM    MM    MM      MM  \n" +
                "  MM      MM  YA.   ,A9   MM       MM      MM                  MM         MM       MM    MM    MM      MM  \n" +
                ".JMML.  .JMML. `Ybmd9'  .JMML.     `Mbmo .JMML.              .JMML.     .JMML.     `Mbod\"YML.  `Mbmo .JMML.\n";
        int op;
        do{
            System.out.println(titulo +
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

                case 2:
                    System.out.println("Digite o código do produto que deseja consultar: ");
                    int codigoConsulta = leitor.nextInt();
                    Produto produtoCodConsulta = opcao.codigoConsulta(codigoConsulta);
                    if (produtoCodConsulta != null) {
                        System.out.println("Produto encontrado:\n " + produtoCodConsulta);
                    } else {
                        System.out.println("Produto com o código " + codigoConsulta + " não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("Digite o nome do produto que deseja consultar: ");
                    String nomeConsulta = leitor.nextLine();
                    Produto produtoNmConsulta = opcao.nomeConsulta(nomeConsulta);
                    if (produtoNmConsulta != null) {
                        System.out.println("Produto encontrado:\n " + produtoNmConsulta);
                    } else {
                        System.out.println("Produto com o nome " + nomeConsulta + " não encontrado.");
                    }
                    break;

                case 4:
                    List<Produto> produtosCadastrados = opcao.listar();

                    if (produtosCadastrados.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                        break;
                    }

                    System.out.println("Escolha o código do produto que deseja alterar:");
                    for (Produto p : produtosCadastrados) {
                        System.out.println("Código: " + p.getCodigo() + " - Nome: " + p.getNome());
                    }

                    System.out.println("Digite o código do produto que deseja alterar: ");
                    int codigoAlterar = leitor.nextInt();
                    leitor.nextLine();
                    Produto produtoAlterar = opcao.codigoConsulta(codigoAlterar);

                    if (produtoAlterar != null) {
                        System.out.println("Digite o novo nome do Produto: ");
                        String novoNome = leitor.nextLine();
                        System.out.println("Digite o novo preço por Kg do produto: ");
                        double novoPreco = leitor.nextDouble();
                        leitor.nextLine();
                        System.out.println("Escolha a nova categoria do produto: "+
                                "\n(F) Fruta"+
                                "\n(L) Legumes"+
                                "\n(V) Verdura"+
                                "\n(O) Ovo"+
                                "\n(T) Tempero");
                        String novaCategoriaEscolhida = leitor.nextLine().toUpperCase();
                        Categoria novaCategoria = null;
                        switch (novaCategoriaEscolhida) {
                            case "F":
                                          novaCategoria = Categoria.FRUTA;
                      break;
                            case "L":
                                novaCategoria = Categoria.LEGUMES;
                                break;
                            case "V":
                                novaCategoria = Categoria.VERDURA;
                                break;
                            case "O":
                                novaCategoria = Categoria.OVO;
                                break;
                            case "T":
                                novaCategoria = Categoria.TEMPERO;
                                break;
                            default:
                                System.out.println("Categoria inválida! Tente novamente.");
                                continue;
                        }
                        produtoAlterar.setNome(novoNome);
                        produtoAlterar.setPreco(novoPreco);
                        produtoAlterar.setCategoria(novaCategoria);
                        opcao.alterar(produtoAlterar);
                        System.out.println("Produto alterado com sucesso!\n");
                    } else {
                        System.out.println("Produto com o código " + codigoAlterar + " não encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Digite o código do produto que deseja excluir: ");
                    int codigoExcluir = leitor.nextInt();
                    Produto produtoExcluir = opcao.codigoConsulta(codigoExcluir);
                    if (produtoExcluir != null) {
                        opcao.excluir(codigoExcluir);
                        System.out.println("Produto excluído com sucesso!");
                    } else {
                        System.out.println("Produto com o código " + codigoExcluir + " não encontrado.");
                    }
                    break;

            }
        } while (op != 6);
        System.out.println("Programa encerrado");
    }
}
