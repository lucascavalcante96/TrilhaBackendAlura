package br.com.alura.screenmatch.Exercicios.Fixacao.Ex01;

import com.google.gson.Gson;

public class Main {
    static void main() {
        String json = """
                {
                    "nome" : "Lucas",
                    "idade" : 30,
                    "cidade" : "Francisco Morato"
                }
                """;
        Gson gson = new Gson();
        Pessoa pessoa = gson.fromJson(json,Pessoa.class);
        System.out.println(pessoa);
    }
}
