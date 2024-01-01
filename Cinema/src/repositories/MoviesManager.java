package repositories;
import entities.movie.Actor;
import entities.movie.Character;
import entities.movie.Gender;
import entities.movie.Movie;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static repositories.ActorManager.actorManagerMenu;
import static repositories.ManagerProgram.managerMenu;
import static utilities.Attempts.TOTAL_ATTEMPTS;
import static utilities.Attempts.attempts;
import static utilities.GenerateID.idGenerate;

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
            System.out.println("\n\n\t############## GERENCIAR FILMES ##############\n");
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
        Actor mattew = new Actor(idGenerate(),"Mattew McConaghey");
        Actor stallone = new Actor(idGenerate(),"Sylvester Stallone");
        Actor arnold = new Actor(idGenerate(),"Arnold Swarznegger");
        Actor keanu = new Actor(idGenerate(),"Keanu Reeves");

        Character john = new Character("", "John", "John Wick");
        Character neo = new Character("", "Neo", "The Matrix");
        Character balboa = new Character("", "Rocky Balboa", "Rocky");
        Character cooper = new Character("", "Cooper", "Interestellar");
        Character rambo = new Character("", "Rambo", "Rambo I");
        Character terminatorC = new Character("", "Terminator", "O Exterminador do futuro");

        Gender action = new Gender("Ação");
        Gender scifi = new Gender("Ficção Científica");
        Gender drama = new Gender("Drama");

        Movie matrix = new Movie( idGenerate(), "The Matrix", 126, 10,scifi, keanu.getNameActor(), neo);
        Movie wick = new Movie(idGenerate(), "John Wick", 117, 14,action, keanu.getNameActor(), john);
        Movie inter = new Movie(idGenerate(), "Interestellar", 169, 0,scifi, mattew.getNameActor(), cooper);
        Movie ramboI = new Movie( idGenerate(), "Rambo I", 139, 16,action, stallone.getNameActor(), rambo);
        Movie rocky = new Movie(idGenerate(), "Rocky", 128, 10,drama, stallone.getNameActor(), balboa);
        Movie terminator = new Movie( idGenerate(), "O Exterminador do futuro", 137, 12,scifi, arnold.getNameActor(), terminatorC);

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

    public static void searchMovie()
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
    public static void removeMovie()
    {
        if (moviesList.isEmpty())
        {
            System.out.println("A lista de filmes está vazia.");
            return;
        }
        boolean findMovieToRemove = false;
        Movie movieRemoved = null;

        System.out.println("Informe o nome ou ID do filme que deseja remover:");
        String movieRemove = scanner.nextLine();

        for (Movie movie : moviesList)
        {
            if (movie.getMovieName().equals(movieRemove) || movie.getId().equals(movieRemove))
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

        int availableAttempt = TOTAL_ATTEMPTS;
        do
        {
            findMovieName = false;
            if (attempts(availableAttempt--))
                managerMenu();

            System.out.println("(" + (availableAttempt + 1) + " tentativas) Informe o nome do filme:");
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

        availableAttempt = TOTAL_ATTEMPTS;
        do
        {
            if (attempts(availableAttempt--))
                managerMenu();

            System.out.println("(" + (availableAttempt + 1) + " tentativas) Informe o gênero do filme:");
            movieGenderDesc = scanner.nextLine();
        }
        while (movieGenderDesc.trim().isEmpty() );

        availableAttempt = TOTAL_ATTEMPTS;
        do
        {
            invalidData = false;
            if (attempts(availableAttempt--))
                managerMenu();

            System.out.println("(" + (availableAttempt + 1) + " tentativas) Informe a duração do filme em minutos:");
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

        availableAttempt = TOTAL_ATTEMPTS;
        do
        {
            invalidData = false;
            if (attempts(availableAttempt--))
                managerMenu();

            System.out.println("(" + (availableAttempt + 1) + " tentativas) Informe a classificação indicativa do filme:");
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

        availableAttempt = TOTAL_ATTEMPTS;
        do
        {
            if (attempts(availableAttempt--))
                managerMenu();

            System.out.println("(" + (availableAttempt + 1) + " tentativas) Informe o(a) ator(a) principal de '" + movieName + "':");
            actorName = scanner.nextLine();
        }
        while (actorName.trim().isEmpty());

        availableAttempt = TOTAL_ATTEMPTS;
        do
        {
            findActor = false;
            if (attempts(availableAttempt--))
                managerMenu();

            System.out.println("(" + (availableAttempt + 1) + " tentativas) Informe o papel de " + actorName + " no filme '" + movieName + "':");
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
            Actor newActor = new Actor(idGenerate(), actorName);
            newActor.addCharacter(newCharacter);
            actorList.add(newActor);
        }

        Gender movieGender = new Gender(movieGenderDesc);
        Movie movie = new Movie(idGenerate(), movieName, Integer.parseInt(movieDuration), Integer.parseInt(indicativeRating), movieGender, actorName, newCharacter);
        moviesList.add(movie);
        System.out.println("Filme '" + movieName + "' adicionado com sucesso!\n");
        moviesMenu();
    }
}