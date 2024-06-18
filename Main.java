package tree;

//import java.util.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static List<Atleta> listaDeAtletas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("MENU");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Listar por altura decrescente");
            System.out.println("4 - Remover");
            System.out.println("5 - Pesquisar por apelido");
            System.out.println("6 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1:
                    cadastrar(scanner);
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    listarPorAlturaDecrescente();
                    break;
                case 4:
                    remover(scanner);
                    break;
                case 5:
                    pesquisar(scanner);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);

        scanner.close();
    }

    private static void cadastrar(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Apelido: ");
        String apelido = scanner.nextLine();
        System.out.print("Altura: ");
        double altura = scanner.nextDouble();
        scanner.nextLine();  // Consumir nova linha
        System.out.print("Posição (entrada/saída): ");
        String posicao = scanner.nextLine();

        Atleta atleta = new Atleta(nome, apelido, altura, posicao);
        listaDeAtletas.add(atleta);
        System.out.println("Atleta cadastrado com sucesso!");
    }

    private static void listar() {
        if (listaDeAtletas.isEmpty()) {
            System.out.println("Nenhum atleta cadastrado.");
        } else {
            listaDeAtletas.forEach(System.out::println);
        }
    }

    private static void listarPorAlturaDecrescente() {
        if (listaDeAtletas.isEmpty()) {
            System.out.println("Nenhum atleta cadastrado.");
        } else {
            List<Atleta> atletasOrdenados = new ArrayList<>(listaDeAtletas);
            atletasOrdenados.sort((a1, a2) -> Double.compare(a2.getAltura(), a1.getAltura()));
            atletasOrdenados.forEach(System.out::println);
        }
    }

    private static void remover(Scanner scanner) {
        System.out.print("Apelido do atleta a ser removido: ");
        String apelido = scanner.nextLine();
        Atleta atletaARemover = listaDeAtletas.stream()
                                               .filter(atleta -> atleta.getApelido().equals(apelido))
                                               .findFirst()
                                               .orElse(null);

        if (atletaARemover != null) {
            listaDeAtletas.remove(atletaARemover);
            System.out.println("Atleta removido com sucesso!");
        } else {
            System.out.println("Atleta não encontrado.");
        }
    }

    private static void pesquisar(Scanner scanner) {
        System.out.print("Apelido do atleta: ");
        String apelido = scanner.nextLine();
        Atleta atletaEncontrado = listaDeAtletas.stream()
                                                 .filter(atleta -> atleta.getApelido().equals(apelido))
                                                 .findFirst()
                                                 .orElse(null);

        if (atletaEncontrado != null) {
            System.out.println(atletaEncontrado);
        } else {
            System.out.println("Atleta não encontrado.");
        }
    }
}
