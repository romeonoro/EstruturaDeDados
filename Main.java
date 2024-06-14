package tree;

import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Scanner;
//import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner tc = new Scanner(System.in);
        int opcao;

        Set<Atleta> ListaAtletas = new TreeSet<>();

        do {
            System.out.println("\nMenu:");
            System.out.println("[1]- Cadastrar atleta");
            System.out.println("[2]- Listar Atletas");
            System.out.println("[3]- Listar por altura (Decrecente)");
            System.out.println("[4]- Remover atleta");
            System.out.println("[5]- Pesquisar por apelido");
            System.out.println("[6]- Sair");
            System.out.print("Escolha uma opção: ");
            opcao = tc.nextInt();
            tc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarAtleta(tc, ListaAtletas);
                    break;
                case 2:
                    listarAtletas(ListaAtletas);
                    break;
                case 3:
                    listarAltura(ListaAtletas);
                    break;
                case 4:
                    removerAtleta(tc, ListaAtletas);
                    break;
                case 5:
                    procurarAtleta(tc, ListaAtletas);
                    break;
                case 6:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }
	
    private static void cadastrarAtleta(Scanner tc, Set<Atleta> listaAtletas) {
        System.out.println("Digite os dados do novo atleta:");
        Atleta novoAtleta = new Atleta();
        listaAtletas.add(novoAtleta);
        System.out.println("Atleta cadastrado com sucesso.");
    }

    private static void listarAtletas(Set<Atleta> listaAtletas) {
        if (listaAtletas.isEmpty()) {
            System.out.println("Não há atletas cadastrados.");
            return;
        }
        System.out.println("Lista de Atletas:");
        for (Atleta atleta : listaAtletas) {
            System.out.println(atleta);
        }
    }
    
    private static void listarAltura(Set<Atleta> listaAtletas) {
        if (listaAtletas.isEmpty()) {
            System.out.println("Não há atletas cadastrados.");
            return;
        }
        System.out.println("Lista de Atletas:");
        for (Atleta atleta : listaAtletas) {
            System.out.println(atleta);
        }
    }

    private static void removerAtleta(Scanner tc, Set<Atleta> listaAtletas) {
        System.out.println("Digite o nome ou apelido do atleta que deseja remover:");
        String nomeOuApelido = tc.nextLine();
        Iterator<Atleta> iterator = listaAtletas.iterator();
        boolean removido = false;
        while (iterator.hasNext()) {
            Atleta atleta = iterator.next();
            if (atleta.getNome().equalsIgnoreCase(nomeOuApelido)
                    || atleta.getApelido().equalsIgnoreCase(nomeOuApelido)) {
                iterator.remove();
                System.out.println("Atleta removido com sucesso.");
                removido = true;
                break;
            }
        }
        if (!removido) {
            System.out.println("Atleta não encontrado.");
        }
    }
    
    private static void procurarAtleta(Scanner tc, Set<Atleta> listaAtletas) {
        System.out.println("Digite o nome ou apelido do atleta que deseja procurar:");
        String nomeOuApelido = tc.nextLine();
        boolean encontrado = false;
        for (Atleta atleta : listaAtletas) {
            if (atleta.getNome().equalsIgnoreCase(nomeOuApelido)
                    || atleta.getApelido().equalsIgnoreCase(nomeOuApelido)) {
                System.out.println("Atleta encontrado:");
                System.out.println(atleta);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Atleta não encontrado.");
        }
    }
}

