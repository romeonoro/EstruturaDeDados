package tree;

import java.util.Objects;

public class Atleta implements Comparable<Atleta> {
    private String nome;
    private String apelido;
    private double altura;
    private String posicao;

    public Atleta(String nome, String apelido, double altura, String posicao) {
        this.nome = nome;
        this.apelido = apelido;
        this.altura = altura;
        this.posicao = posicao;
    }

    public String getNome() {
        return nome;
    }

    public String getApelido() {
        return apelido;
    }

    public double getAltura() {
        return altura;
    }

    public String getPosicao() {
        return posicao;
    }

    @Override
    public int compareTo(Atleta outro) {
        return this.apelido.compareTo(outro.apelido);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Atleta atleta = (Atleta) obj;
        return apelido.equals(atleta.apelido);
    }

    @Override
    public int hashCode() {
        return apelido.hashCode();
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Apelido: " + apelido + ", Altura: " + altura + ", Posição: " + posicao;
    }
}

