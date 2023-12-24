package program;
import cinema.movie.Movie;
import java.util.ArrayList;
import java.util.Scanner;

public class Program
{
    static ArrayList<Movie> moviesList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int contMovies = 1;
    static void ShowMoviesList()
    {
        for (Movie movie : moviesList)
        {
            System.out.println("\nFilme " + contMovies);
            System.out.println("Filme: " + movie.getMovieName());
            System.out.println("Gênero: " + movie.getMovieGender());
            System.out.println("Duração (Em minutos): " + movie.getMovieDuration());
            contMovies++;
        }
    }
    public static void MainMovies()
    {
        Movie movie = new Movie();

        System.out.println("=========================================");
        System.out.println("Informe o nome do filme:");
        movie.setMovieName(scanner.nextLine());
        System.out.println("Informe o gênero do filme:");
        movie.setMovieGender(scanner.nextLine());
        System.out.println("Informe a duração do filme em minutos:");
        movie.setMovieDuration(scanner.nextLine());
        moviesList.add(movie);

        System.out.println("Listar outro filme ou encerrar?\n1 - Continuar\n2 - Ver lista\n3 - Encerrar");
        switch (scanner.nextLine())
        {
            case "1" -> MainMovies();
            case "2" -> ShowMoviesList();
            case "3" -> System.out.println("Encerrando...");
        }
    }
}
