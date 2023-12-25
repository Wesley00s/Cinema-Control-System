package controlers;
import entities.movie.Movie;
import java.util.ArrayList;
import java.util.Scanner;

public class Program
{
    static ArrayList<Movie> moviesList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int contMovies;
    static boolean findMovieToRemove;
    static Movie movieRemoved;
    static boolean validMovieDuration;
    static boolean findMovieName;

    static void ShowMoviesList ()
    {
        if (moviesList.isEmpty())
        {
            System.out.println("a lista de filmes está vazia!");
            return;
        }
        contMovies = 1;
        System.out.println("\n\tLISTA DE FILMES");
        for (Movie movie : moviesList)
        {
            System.out.println("Filme " + contMovies);
            System.out.println("Filme: " + movie.getMovieName());
            System.out.println("Gênero: " + movie.getMovieGender());
            System.out.println("Duração (Em minutos): " + movie.getMovieDuration());
            System.out.println("=================================\n");
            contMovies++;
        }
    }
    static void removeMovie ()
    {
        if (moviesList.isEmpty())
        {
            System.out.println("A lista de filmes está vazia.");
            return;
        }
        findMovieToRemove = false;
        movieRemoved = null;

        System.out.println("Informe o nome do filme que deseja remover:");
        String movieRemove = scanner.nextLine();

        for (Movie movie : moviesList) {
            if (movie.getMovieName().equals(movieRemove)) {
                System.out.println("Filme " + "'" + movie.getMovieName() + "'" + " removido.\n");
                movieRemoved = movie;
                findMovieToRemove = true;
            }
        }

        if (findMovieToRemove)
        {
            moviesList.remove(movieRemoved);
        }
        else
        {
            System.out.println("Filme " + "'" + movieRemove + "'" + " não encontrado.\n");
        }
    }
    static void menuOpt()
    {
        System.out.println("O que deseja?\n1 - Listar outro filme\n2 - Ver lista\n3 - Remover filme\n4 - Encerrar");
        switch (scanner.nextLine())
        {
            case "1" -> MainMovies();
            case "2" -> {ShowMoviesList(); menuOpt();}
            case "3" -> {removeMovie(); menuOpt();}
            default -> System.out.println("Encerrando...");
        }
    }
    public static void MainMovies()
    {
        Movie movie = new Movie();

        System.out.println("===========================");
        String movieName;
        String movieGender;
        String movieDuration;
        do
        {
            findMovieName = false;
            System.out.println("Informe o nome do filme:");
            movieName = scanner.nextLine();
            for (Movie name : moviesList)
            {
                if (name.getMovieName().equals(movieName))
                {
                    findMovieName = true;
                    System.out.println("Filme já presente na lista.\n");
                }
            }
        }
        while (movieName.trim().isEmpty() || findMovieName);

        do
        {
            System.out.println("Informe o gênero do filme:");
            movieGender = scanner.nextLine();
        }
        while (movieGender.trim().isEmpty() );

        do
        {
            validMovieDuration = true;

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
                validMovieDuration = false;
            }
        }
        while (movieDuration.trim().isEmpty() || !validMovieDuration || Integer.parseInt(movieDuration) <= 0);

        System.out.println("Filme " + "'" + movieName + "'" + " adicionado com sucesso!\n");
        movie.setMovieName(movieName);
        movie.setMovieGender(movieGender);
        movie.setMovieDuration(Integer.parseInt(movieDuration));
        moviesList.add(movie);
        menuOpt();
    }
}