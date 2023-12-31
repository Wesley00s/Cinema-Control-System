package repositories;
import entities.movie.Actor;
import entities.movie.Character;
import entities.movie.Gender;
import entities.movie.Movie;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static repositories.ActorManager.actorManagerMenu;
import static Utilities.GenerateID.idGenerate;
import static repositories.ManagerProgram.managerMenu;

public class MoviesManager
{
    public static List<Movie> moviesList = new ArrayList<>();
    public static final List<Actor> actorList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean findMovieName;

    public static void moviesMenu()
    {
        while (true)
        {
            System.out.println("\n\n\t############## APLICAÇÃO 1 - ADICIONAR FILMES ##############\n");
            System.out.println("""
                O que deseja?
                1 - Listar filme
                2 - Ver lista
                3 - Remover filme
                4 - Procurar filme
                5 - Vizualizar atores
                R - Retornar ao menu do administrador""");
            switch (scanner.nextLine().toUpperCase())
            {
                case "1" -> addMovies();
                case "2" -> displayMoviesList();
                case "3" -> removeMovie();
                case "4" -> searchMovie();
                case "5" -> actorManagerMenu(actorList);
                case "R" -> {System.out.println("Retornado ao menu do administrador..."); managerMenu();}
                default -> System.out.println("Opção inválida!\n");
            }
        }
    }

    public static void addPrevMovies ()
    {
        Actor mattew = new Actor("Mattew McConaghey");
        Actor stallone = new Actor("Sylvester Stallone");
        Actor arnold = new Actor("Arnold Swarznegger");
        Actor keanu = new Actor("Keanu Reeves");

        Character john = new Character("", "John", "John Wick");
        Character neo = new Character("", "Neo", "The Matrix");
        Character balboa = new Character("", "Rocky Balboa", "Rocky");
        Character cooper = new Character("", "Cooper", "Interestellar");
        Character rambo = new Character("", "Rambo", "Rambo I");
        Character terminatorC = new Character("", "Terminator", "O Exterminador do futuro");

        Gender action = new Gender("Ação");
        Gender scifi = new Gender("Ficção Científica");
        Gender drama = new Gender("Drama");

        Movie matrix = new Movie( "The Matrix", 126, 10,scifi, keanu.getNameActor(), neo);
        Movie wick = new Movie("John Wick", 117, 14,action, keanu.getNameActor(), john);
        Movie inter = new Movie("Interestellar", 169, 0,scifi, mattew.getNameActor(), cooper);
        Movie ramboI = new Movie( "Rambo I", 139, 16,action, stallone.getNameActor(), rambo);
        Movie rocky = new Movie("Rocky", 128, 10,drama, stallone.getNameActor(), balboa);
        Movie terminator = new Movie( "O Exterminador do futuro", 137, 12,scifi, arnold.getNameActor(), terminatorC);

        keanu.addCharacter(neo);
        keanu.addCharacter(john);
        stallone.addCharacter(rambo);
        stallone.addCharacter(balboa);
        mattew.addCharacter(cooper);
        arnold.addCharacter(terminatorC);

        moviesList.add(matrix);
        moviesList.add(wick);
        moviesList.add(inter);
        moviesList.add(ramboI);
        moviesList.add(rocky);
        moviesList.add(terminator);

        actorList.add(keanu);
        actorList.add(mattew);
        actorList.add(stallone);
        actorList.add(arnold);
    }

    static void searchMovie ()
    {
        findMovieName = false;
        System.out.println("Informe o nome ou ID do filme que deseja procurar: ");
        String movieSearch = scanner.nextLine();

        for (Movie movie : moviesList)
        {
            if (movie.getMovieName().equals(movieSearch) || movie.getId().equals(movieSearch))
            {
                System.out.println("\n\tFILME ENCONTRADO");
                movie.movieInfo();
                findMovieName = true;
            }
        }
        if (!findMovieName)
            System.out.println("Filme não '" + movieSearch + "' encontrado.\n");
    }
    public static void displayMoviesList()
    {
        if (moviesList.isEmpty())
        {
            System.out.println("A lista de filmes está vazia!");
            return;
        }
        int contMovies = 1;
        for (Movie movie : moviesList)
        {
            System.out.println("\n\n* FILME " + contMovies + " =============================\n");
            movie.movieInfo();
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
        boolean findMovieToRemove = false;
        Movie movieRemoved = null;

        System.out.println("Informe o nome do filme que deseja remover:");
        String movieRemove = scanner.nextLine();

        for (Movie movie : moviesList)
        {
            if (movie.getMovieName().equals(movieRemove))
            {
                System.out.println("Filme '" + movie.getMovieName() + "' removido.\n");
                movieRemoved = movie;
                findMovieToRemove = true;
            }
        }

        if (findMovieToRemove)
            moviesList.remove(movieRemoved);
        else
            System.out.println("Filme '" + movieRemove + "' não encontrado.\n");
    }

    public static void addMovies()
    {
        String movieName;
        String movieGenderDesc;
        String movieDuration;
        String indicativeRating;
        String actorName;
        String characterName;
        boolean findActor;
        boolean invalidData;
        Character newCharacter = null;

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
            movieGenderDesc = scanner.nextLine();
        }
        while (movieGenderDesc.trim().isEmpty() );

        do
        {
            invalidData = false;

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
                invalidData = true;
            }
        }
        while (movieDuration.trim().isEmpty() || invalidData || Integer.parseInt(movieDuration) <= 0);

        do
        {
            invalidData = false;
            System.out.println("Informe a classificação indicativa do filme:");
            indicativeRating = scanner.nextLine();

            try
            {
                if (Integer.parseInt(indicativeRating) < 0)
                {
                    System.out.println("Informe uma classificação válida!\n");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("ERROR: Tipo de dado inválido!\n");
                invalidData = true;
            }
        }
        while(indicativeRating.trim().isEmpty() || invalidData || Integer.parseInt(indicativeRating) < 0);

        do
        {
            System.out.println("Informe o(a) ator(a) principal de '" + movieName + "':");
            actorName = scanner.nextLine();
        }
        while (actorName.trim().isEmpty());

        do
        {
            findActor = false;

            System.out.println("Informe o papel de " + actorName + " no filme '" + movieName + "':");
            characterName = scanner.nextLine();

        }
        while (characterName.trim().isEmpty());

        for (Actor actor : actorList)
        {
            if (actor.getNameActor().equals(actorName))
            {
                newCharacter = new Character(actorName, characterName, movieName);
                if (!actor.characters.contains(newCharacter))
                {
                    actor.addCharacter(newCharacter);
                    findActor = true;
                }
            }
        }

        if (!findActor)
        {
            newCharacter = new Character(actorName, characterName, movieName);
            Actor newActor = new Actor(actorName);
            newActor.addCharacter(newCharacter);
            actorList.add(newActor);
        }

        Gender movieGender = new Gender(movieGenderDesc);
        Movie movie = new Movie(movieName, Integer.parseInt(movieDuration), Integer.parseInt(indicativeRating), movieGender, actorName, newCharacter);
        moviesList.add(movie);
        System.out.println("Filme '" + movieName + "' adicionado com sucesso!\n");
        moviesMenu();
    }
}