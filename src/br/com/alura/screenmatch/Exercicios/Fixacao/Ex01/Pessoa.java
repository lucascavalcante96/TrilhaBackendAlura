package br.com.alura.screenmatch.Exercicios.Fixacao.Ex01;

public record Pessoa(String nome, int idade, String cidade) {
    @Override
    public String toString() {
        return "Dados Pessoais {" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
