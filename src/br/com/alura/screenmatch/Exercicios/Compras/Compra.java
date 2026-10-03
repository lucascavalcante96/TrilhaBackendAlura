package br.com.alura.screenmatch.Exercicios.Compras;

public class Compra implements Comparable<Compra> {
    private String descricaoProduto;
    private double valor;

    public Compra(String descricao, double valor) {
        this.descricaoProduto = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricaoProduto;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Compra: descricao = " + descricaoProduto +
                " valor =" + valor;
    }

    @Override
    public int compareTo(Compra outraCompra) {
        return Double.valueOf(this.valor).compareTo(Double.valueOf(outraCompra.valor));
    }
}