package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class PrincipalComListas {
    static void main() {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        Filme outroFilme = new Filme("Avatar", 2023);
        Filme filme2 = new Filme("Dogville", 2003);
        Serie lost = new Serie("Lost", 2000);

        ArrayList<Titulo> titulos = new ArrayList<Titulo>();
        titulos.add(meuFilme);
        titulos.add(outroFilme);
        titulos.add(filme2);
        titulos.add(lost);

        for(Titulo titulo : titulos) {
            System.out.println(titulo.getNome());
            if (titulo instanceof Filme filme) {
                System.out.println("Classificação " + filme.getClassificacao());
            }

        }
    }
}
