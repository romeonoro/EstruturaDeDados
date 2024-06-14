package tree;

import java.util.Objects;
import java.util.Scanner;


public class Atleta implements Comparable<Atleta> {
	Scanner tc = new Scanner(System.in);

    String nome;
    String apelido;
    String altura;
    String posicao;

    public Atleta() {
        System.out.println("---CADASTRO DE ATLETA DE VÔLEI DE AREIA---");
        System.out.println("Digite o nome do atleta");
        this.nome = tc.nextLine();
        System.out.println("Digite o apelido do atleta");
        this.apelido = tc.nextLine();
        System.out.println("Digite a altura do atleta");
        this.altura = tc.nextLine();
        System.out.println("Digite a posição atleta (entrada ou saída)");
        this.posicao = tc.nextLine();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    // Método toString
    @Override
    public String toString() {
        return "Atleta{" +
                " nome='" + nome + '\'' +
                ", apelido='" + apelido + '\'' +
                ", altura='" + altura + '\'' +
                ", posicao=" + posicao +
                '}';
    }

    // Método equals
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Atleta atleta = (Atleta) o;
        return nome.equals(atleta.nome);
    }

    // Método hashCode
    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    // Método compareTo para ordenação em TreeSet
    @Override
    public int compareTo(Atleta outro) {
        return this.nome.compareTo(outro.nome);
    }
}

