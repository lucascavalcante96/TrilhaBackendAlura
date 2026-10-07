package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    static void main() throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um filme para busca: ");
        var busca = sc.nextLine();
        try{
            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=3dc19462";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

            TituloOmdb meuFilmeOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(meuFilmeOmdb);

            Titulo meuFilme = new Titulo(meuFilmeOmdb);

            System.out.println("Titulo já convertido");
            System.out.println(meuFilme);

            FileWriter escrita = new FileWriter("filmes.txt", true);
            escrita.write(meuFilme.toString());
            escrita.close();
        } catch (NumberFormatException e){
            System.out.println("Aconteceu um erro: " + e.getMessage());
        } catch (IllegalArgumentException e){
            System.out.println("Aconteceu um erro: " + e.getMessage());
        } catch (ErroDeConversaoDeAnoException e){
            System.out.println(e.getMessage());
        }
    }
}
