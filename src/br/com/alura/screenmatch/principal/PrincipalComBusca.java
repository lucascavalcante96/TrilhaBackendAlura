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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    static void main() throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);

        var busca = " ";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        while (!busca.equals("sair")) {
            System.out.println("Digite um filme para busca: ");
            busca = sc.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            try{
                String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=3dc19462";
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
                HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                System.out.println(json);



                TituloOmdb meuFilmeOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuFilmeOmdb);

                Titulo meuTitulo = new Titulo(meuFilmeOmdb);

                System.out.println("Titulo já convertido");
                System.out.println(meuTitulo);

                titulos.add(meuTitulo);
            } catch (NumberFormatException e){
                System.out.println("Aconteceu um erro: " + e.getMessage());
            } catch (IllegalArgumentException e){
                System.out.println("Aconteceu um erro: " + e.getMessage());
            } catch (ErroDeConversaoDeAnoException e){
                System.out.println(e.getMessage());
            }

            System.out.println(titulos);

        }
        FileWriter escrita = new FileWriter("ListaDeTitulos.json", true);
        escrita.write(gson.toJson(titulos));
        escrita.close();
    }
}
