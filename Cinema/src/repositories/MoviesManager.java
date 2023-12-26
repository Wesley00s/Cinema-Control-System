package repositories;
import entities.movie.Movie;
import java.util.ArrayList;
import java.util.Scanner;

public class MoviesManager
{
    static ArrayList<Movie> moviesList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int contMovies;
    static boolean findMovieToRemove;
    static Movie movieRemoved;
    static boolean invalidMovieDuration;
    static boolean findMovieName;

    static void searchMovie ()
    {
        findMovieName = false;
        System.out.println("Informe o nome do filme que deseja procurar: ");
        String movieSearch = scanner.nextLine();


        for (Movie movie : moviesList)
        {
            if (movie.getMovieName().equals(movieSearch))
            {
                System.out.println("\n\tFILME ENCONTRADO");
                movie.getMovie();
                findMovieName = true;
            }
        }
        if (!findMovieName)
        {
            System.out.println("Filme não '" + movieSearch + "' encontrado.\n");
        }
    }
    static void showMoviesList()
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
            movie.getMovie();
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
                System.out.println("Filme '" + movie.getMovieName() + "' removido.\n");
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
            System.out.println("Filme '" + movieRemove + "' não encontrado.\n");
        }
    }
    static void menuOpt()
    {
        System.out.println("O que deseja?\n1 - Listar outro filme\n2 - Ver lista\n3 - Remover filme\n4 - Procurar filme\n5 - Encerrar");
        switch (scanner.nextLine())
        {
            case "1" -> addMovies();
            case "2" -> {showMoviesList(); menuOpt();}
            case "3" -> {removeMovie(); menuOpt();}
            case "4" -> {searchMovie(); menuOpt();}
            case "5" -> System.out.println("Encerrando...");
            default -> {System.out.println("Opção inválida!\n"); menuOpt();}
        }
    }
    public static void addMovies()
    {
        Movie movie = new Movie();
        String movieName;
        String movieGender;
        String movieDuration;
        String actor;
        String actorRole;

        System.out.println("===========================");
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
                    System.out.println("Filme '" + movieName + "' já presente na lista.\n");
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
            invalidMovieDuration = false;

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
                System.out.println("ERROR: Tipo de dado inválido!\n");
                invalidMovieDuration = true;
            }
        }
        while (movieDuration.trim().isEmpty() || invalidMovieDuration || Integer.parseInt(movieDuration) <= 0);

        do
        {
            System.out.println("Informe o(a) ator(a) principal de '" + movieName + "':");
            actor = scanner.nextLine();
        }
        while (actor.trim().isEmpty());

        do
        {
            System.out.println("Informe o papel de " + actor + " no filme '" + movieName + "':");
            actorRole = scanner.nextLine();
        }
        while (actorRole.trim().isEmpty());

        movie.setMovieName(movieName);
        movie.setMovieGender(movieGender);
        movie.setMovieDuration(Integer.parseInt(movieDuration));
        movie.setActorName(actor);
        movie.setActorRole(actorRole);
        moviesList.add(movie);
        System.out.println("Filme '" + movieName + "' adicionado com sucesso!\n");
        menuOpt();
    }
}