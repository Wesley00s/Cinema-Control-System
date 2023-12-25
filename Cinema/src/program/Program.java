package program;
import cinema.movie.Movie;
import java.util.ArrayList;
import java.util.Scanner;

public class Program
{
    static ArrayList<Movie> moviesList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int contMovies = 1;
    static boolean verify;
    static void ShowMoviesList ()
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

    static void removeMovie ()
    {

    }
    public static void MainMovies()
    {
        Movie movie = new Movie();

        System.out.println("=========================================");
        String movieName;
        String movieGender;
        String movieDuration;
        do
        {
            System.out.println("Informe o nome do filme:");
            movieName = scanner.nextLine();
        }
        while (movieName.trim().isEmpty());

        do
        {
            System.out.println("Informe o gênero do filme:");
            movieGender = scanner.nextLine();
        }
        while (movieGender.trim().isEmpty() );

        do
        {
            verify = true;

            System.out.println("Informe a duração do filme em minutos:");
            movieDuration = scanner.nextLine();

            try
            {
                if (Integer.parseInt(movieDuration) <= 0)
                {
                    System.out.println("Informe um valor válido!\n");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("ERROR: Tipo inválido de dado!\n");
                verify = false;
            }
        }
        while (movieDuration.trim().isEmpty() || !verify || Integer.parseInt(movieDuration) <= 0);

        System.out.println("Filme " + "'" + movieName + "'" + " adicionado com sucesso!\n");
        movie.setMovieName(movieName);
        movie.setMovieGender(movieGender);
        movie.setMovieDuration(Integer.parseInt(movieDuration));
        moviesList.add(movie);

        System.out.println("O que deseja?\n1 - Listar outro filme\n2 - Ver lista\n3 - Remover filme\n4 - Encerrar");
        switch (scanner.nextLine())
        {
            case "1" -> MainMovies();
            case "2" -> ShowMoviesList();
            case "3" -> removeMovie();
            default -> System.out.println("Encerrando...");
        }
    }
}
