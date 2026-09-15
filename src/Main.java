import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Epsodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class Main {
    static void main() {
        Filme meuFilme = new Filme();
        meuFilme.setNome("O poderoso chefão");
        meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoEmMinutos(180);


        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println("Média: " + meuFilme.pegaMedia());

        Serie lost = new Serie();
        lost.setNome("Lost");
        lost.setAnoDeLancamento(2000);
        lost.setTemporadas(10);
        lost.setEpsodiosPorTemporada(10);
        lost.setMinutosPorEpsodio(50);

        System.out.println("Duração de " + lost.getNome() + ": " + lost.getDuracaoEmMinutos() + " minutos");

        Filme outroFilme = new Filme();
        outroFilme.setNome("Avatar");
        outroFilme.setAnoDeLancamento(2023);
        outroFilme.setDuracaoEmMinutos(200);

        CalculadoraDeTempo calc = new CalculadoraDeTempo();
        calc.inclui(meuFilme);
        calc.inclui(outroFilme);
        calc.inclui(lost);
        System.out.println("Tempo total para assistir: " + calc.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);
        Epsodio epsodio =  new Epsodio();
        epsodio.setNome("Inicio");
        epsodio.setNumero(1);
        epsodio.setSerie(lost);
        epsodio.setTotalDeVizualizacoes(300);

        filtro.filtra(epsodio);

        Filme filme2 = new Filme();
        filme2.setNome("Dogville");
        filme2.setAnoDeLancamento(2003);
        filme2.setDuracaoEmMinutos(200);
        filme2.avalia(10);

        ArrayList<Titulo> titulos = new ArrayList<Titulo>();
        titulos.add(meuFilme);
        titulos.add(outroFilme);
        titulos.add(filme2);
        titulos.add(lost);

        System.out.println("Total de titulos: " + titulos.size());
        System.out.println("Primeiro Filme: " + titulos.get(0).getNome());

    }
}
